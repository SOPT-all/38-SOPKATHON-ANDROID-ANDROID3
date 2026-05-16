package com.sopt.android3.presentation.tehoon

import com.sopt.android3.presentation.gominModel

data class TehoonUiState(
    val gomin: gominModel,
    val textfieldText: String = "",

    val isLoading: Boolean = false,
    val error: String? = null,
    val isSuccess: Boolean = false,
) {

}
