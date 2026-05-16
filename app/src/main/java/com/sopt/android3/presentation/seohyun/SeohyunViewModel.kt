package com.sopt.android3.presentation.seohyun

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.android3.data.network.ServicePool
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SeohyunViewModel : ViewModel() {
    private val userPostService = ServicePool.SeohyunService

    private val _uiState = MutableStateFlow(SeohyunUiState())
    val uiState: StateFlow<SeohyunUiState> = _uiState.asStateFlow()

    init {
        fetchMyPosts()
    }

    private fun fetchMyPosts() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }

            try {
                val response = userPostService.getUserPosts()

                val posts = response.data.posts.map { post ->
                    PostUiModel(
                        postId = post.postId,
                        title = post.title,
                        content = post.content,
                        reactions = post.reactions,
                    )
                }

                _uiState.update {
                    it.copy(
                        posts = posts,
                        isLoading = false,
                        isSuccess = true,
                    )
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
}