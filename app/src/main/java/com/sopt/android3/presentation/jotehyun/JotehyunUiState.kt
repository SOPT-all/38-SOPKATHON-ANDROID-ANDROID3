package com.sopt.android3.presentation.jotehyun

data class JotehyunUiState(
    val title: String = "",

    val isLoading: Boolean = false,
    val error: String? = null,
    val isSuccess: Boolean = false,
) {

}
