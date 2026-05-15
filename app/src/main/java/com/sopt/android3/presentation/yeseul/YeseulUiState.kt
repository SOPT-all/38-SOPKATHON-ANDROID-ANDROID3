package com.sopt.android3.presentation.yeseul

data class YeseulUiState(
    val title: String = "",

    val isLoading: Boolean = false,
    val error: String? = null,
    val isSuccess: Boolean = false,
) {

}
