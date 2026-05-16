package com.sopt.android3.data.service

import com.sopt.android3.data.dto.base.BaseResponse
import com.sopt.android3.data.dto.request.HomeRequest
import com.sopt.android3.data.dto.response.HomeResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface HomeService {
    @POST("/posts")
    suspend fun postHomeData(
        @Body homeRequest: HomeRequest
    ): Response<BaseResponse<HomeResponse>>
}