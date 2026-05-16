package com.sopt.android3.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeRequest(
    @SerialName("title") val title: String,
    @SerialName("content") val content: String
)