package com.sopt.android3.presentation.seohyun

data class SeohyunUiState(
    val posts: List<PostUiModel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val isSuccess: Boolean = false,
)

data class PostUiModel(
    val postId: Int,
    val title: String,
    val content: String,
    val reactions: List<String>,
)