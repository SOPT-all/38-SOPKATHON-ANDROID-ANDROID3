package com.sopt.android3.data.service

import com.sopt.android3.data.dto.base.BaseResponse
import com.sopt.android3.data.dto.response.SeohyunDataDTO
import com.sopt.android3.data.dto.response.SeohyunResponseDTO
import retrofit2.http.GET

interface SeohyunService {
    @GET("users/me/posts")
    suspend fun getUserPosts(): SeohyunResponseDTO
}