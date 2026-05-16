package com.sopt.android3.presentation.tehoon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.android3.data.dto.request.HomeRequest
import com.sopt.android3.data.dto.request.TehoonRequest
import com.sopt.android3.data.network.ServicePool
import com.sopt.android3.presentation.gominModel
import com.sopt.android3.presentation.seohyun.PostUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TehoonViewModel : ViewModel() {
    // 이거 ServicePool에서 꺼내는 Service 만들어서 써야돼요! 이거 바꿔야됨 (변수명도 바꿔주세용)
    private val exampleServce = ServicePool.exampleService
    private val tehoonService = ServicePool.tehoonService
    private val tehoonGetService = ServicePool.tehoonGetService


    private val dummyPosts = listOf(
        gominModel(
            postId = 1,
            title = "첫 번째 고민",
            content = "첫 번째 더미 데이터 내용입니다. 화가 많이 나는 날이네요.",
            hashtags = listOf("분노", "화남")
        ),
        gominModel(
            postId = 2,
            title = "두 번째 고민",
            content = "두 번째 더미 데이터 내용입니다. 롱탭을 눌러서 잘 넘어오셨군요!",
            hashtags = listOf("슬픔", "눈물")
        ),
        gominModel(
            postId = 3,
            title = "세 번째 고민",
            content = "세 번째 더미 데이터 내용입니다. 오늘따라 마음이 싱숭생숭해요.",
            hashtags = listOf("우울", "답답")
        ),
        gominModel(
            postId = 4,
            title = "네 번째 고민",
            content = "네 번째 더미 데이터 내용입니다. 좋은 일이 생길 것 같아요.",
            hashtags = listOf("설렘", "기쁨")
        ),
        gominModel(
            postId = 5,
            title = "다섯 번째 고민",
            content = "다섯 번째 더미 데이터 내용입니다. 기분이 아주 날아갈 것 같습니다.",
            hashtags = listOf("신남", "대박")
        ),
        gominModel(
            postId = 6,
            title = "여섯 번째 고민",
            content = "여섯 번째 더미 데이터 내용입니다. 아무 생각이 없는 상태입니다.",
            hashtags = listOf("평온", "멍")
        ),
        gominModel(
            postId = 7,
            title = "일곱 번째 고민",
            content = "일곱 번째 더미 데이터 내용입니다. 예상치 못한 일로 멘붕이 왔어요.",
            hashtags = listOf("황당", "멘붕")
        ),
        gominModel(
            postId = 8,
            title = "여덟 번째 고민",
            content = "여덟 번째 더미 데이터 내용입니다. 날씨가 좋아서 행복해요.",
            hashtags = listOf("행복", "만족")
        ),
        gominModel(
            postId = 9,
            title = "아홉 번째 고민",
            content = "아홉 번째 더미 데이터 내용입니다. 다 귀찮고 짜증나는 순간입니다.",
            hashtags = listOf("짜증", "예민")
        ),
        gominModel(
            postId = 10,
            title = "열 번째 고민",
            content = "마지막 더미 데이터 내용입니다. 다시 처음으로 돌아갈 준비가 되셨나요?",
            hashtags = listOf("기대", "종료")
        )
    )

    private var currentPosts: List<gominModel> = dummyPosts
    private var currentPostIndex = 0
    private val _uiState = MutableStateFlow(
        TehoonUiState(
            gomin = dummyPosts[currentPostIndex],
            isLoading = false,
            error = null,
            isSuccess = true
        )
    )
    val uiState: StateFlow<TehoonUiState> = _uiState.asStateFlow()

    init {
        tehoonGet()
    }

    fun changeToNextGomin() {
        if (currentPosts.isEmpty()) return

        currentPostIndex = (currentPostIndex + 1) % dummyPosts.size

        _uiState.update { currentState ->
            currentState.copy(
                gomin = currentPosts[currentPostIndex]
            )
        }
    }

    private fun tehoonGet() {
        _uiState.update { it.copy(isLoading = true, error = null, isSuccess = false) }

        viewModelScope.launch {
            try {
                val response = tehoonGetService.getPosts()

                val gomin = response.data.posts.map { post ->
                    gominModel(
                        postId = post.postId,
                        title = post.title ?: "",
                        content = post.content,
                        hashtags = post.hashtags,
                    )
                }


                if (gomin.isNotEmpty()) {
                    currentPosts = gomin
                    currentPostIndex = 0

                    _uiState.update {
                        it.copy(
                            gomin = currentPosts[currentPostIndex],
                            isLoading = false,
                            isSuccess = true,
                            textfieldText = ""
                        )
                    }
                } else {
                    _uiState.update { it.copy(isLoading = false, isSuccess = true) }
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        isSuccess = false,
                        error = e.message ?: "게시글 조회 실패",
                    )
                }
            }
        }
    }

    fun tehoonPost() {
        val reactionContent = _uiState.value.textfieldText

        if (reactionContent.isBlank()) return

        _uiState.update { it.copy(isLoading = true, error = null, isSuccess = false) }

        viewModelScope.launch {
            try {
                val request = TehoonRequest(
                    content = reactionContent,
                )

                val response =
                    tehoonService.postTehoonData(postId = currentPostIndex, tehoonRequest = request)

                if (response.isSuccessful) {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            isSuccess = true
                        )
                    }
                } else {
            _uiState.update {
                it.copy(
                    isLoading = false,
                    isSuccess = false,
                    error = "공감 전송에 실패했습니다."
                )
            }
        }
        } catch (e: Exception) {
            _uiState.update {
                it.copy(
                    isLoading = false,
                    isSuccess = false,
                    error = e.message ?: "네트워크 오류가 발생했습니다."
                )
            }
        }
        }
        changeToNextGomin()
    }

    fun onChangedValue(value: String) {
        _uiState.update { it.copy(textfieldText = value) }
    }
}


