package com.sopt.android3.data.service

import com.sopt.android3.data.dto.base.BaseResponse
import com.sopt.android3.data.dto.response.TehoonGetResponse
import retrofit2.http.GET

interface TehoonGetService {
    @GET("/posts")
    suspend fun getPosts(): BaseResponse<TehoonGetResponse>
}
