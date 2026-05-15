package com.sopt.android3.presentation.tehoon

data class TehoonUiState(
    val title: String = "",

    val isLoading: Boolean = false,
    val error: String? = null,
    val isSuccess: Boolean = false,
) {

}
