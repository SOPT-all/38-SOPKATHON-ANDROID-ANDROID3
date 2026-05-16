package com.sopt.android3.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeohyunResponseDTO(
    @SerialName("code")
    val code: String,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: SeohyunDataDTO,
)

@Serializable
data class SeohyunDataDTO(
    @SerialName("posts")
    val posts: List<SeohyunPostDTO>,
)

@Serializable
data class SeohyunPostDTO(
    @SerialName("postId")
    val postId: Int,
    @SerialName("title")
    val title: String?,
    @SerialName("content")
    val content: String,
    @SerialName("reactions")
    val reactions: List<String>,
)