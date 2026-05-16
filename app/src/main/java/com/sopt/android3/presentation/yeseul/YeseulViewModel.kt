package com.sopt.android3.presentation.yeseul

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.android3.data.dto.request.HomeRequest
import com.sopt.android3.data.network.ServicePool
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class YeseulViewModel : ViewModel() {
    private val homeService = ServicePool.homeService
    private val _uiState = MutableStateFlow(YeseulUiState())
    val uiState: StateFlow<YeseulUiState> = _uiState.asStateFlow()

    fun postMemory(content: String) {
        _uiState.update { it.copy(isLoading = true, error = null, isSuccess = false) }

        viewModelScope.launch {
            try {
                val request = HomeRequest(
                    title = "",
                    content = content,
                )

                val response = homeService.postHomeData(request)

                if (response.isSuccessful) {
                    val body = response.body()
                    val postId = body?.data?.postId

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
                            error = "서버 에러가 발생했습니다."
                        )
                    }
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        isSuccess = false,
                        error = e.message ?: "메시지 전송에 실패했습니다."
                    )
                }
            }
        }
    }

    fun resetUiState() {
        _uiState.update { YeseulUiState() }
    }
}


