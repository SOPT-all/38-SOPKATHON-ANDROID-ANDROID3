package com.sopt.android3.data.service

import com.sopt.android3.data.dto.base.BaseResponse
import com.sopt.android3.data.dto.request.HomeRequest
import com.sopt.android3.data.dto.request.TehoonRequest
import com.sopt.android3.data.dto.response.HomeResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface TehoonService {
    @POST("/posts/{postId}/reactions")
    suspend fun postTehoonData(
        @Path("postId") postId: Int,
        @Body tehoonRequest: TehoonRequest
    ): Response<BaseResponse<String>>
}
