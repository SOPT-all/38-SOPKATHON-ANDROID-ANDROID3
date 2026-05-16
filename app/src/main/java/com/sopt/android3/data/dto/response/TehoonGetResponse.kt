package com.sopt.android3.data.dto.response

import com.sopt.android3.presentation.gominModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TehoonGetResponse(
    @SerialName("posts")
    val posts: List<PostDto>
)

@Serializable
data class PostDto(
    @SerialName("postId")
    val postId: Int,

    @SerialName("title")
    val title: String,

    @SerialName("content")
    val content: String,

    @SerialName("hashtags")
    val hashtags: List<String>
) {
    fun toDomain(): gominModel {
        return gominModel(
            postId = this.postId,
            title = this.title,
            content = this.content,
            hashtags = this.hashtags
        )
    }
}
