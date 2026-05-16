package com.sopt.android3.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TehoonRequest(
    @SerialName("content") val content: String
)
