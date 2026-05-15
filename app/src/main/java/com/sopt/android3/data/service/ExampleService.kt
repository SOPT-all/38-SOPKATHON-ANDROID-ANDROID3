package com.sopt.android3.data.service

import com.sopt.android3.data.dto.base.BaseResponse
import com.sopt.android3.data.dto.request.ExampleRequest
import com.sopt.android3.data.dto.response.ExampleResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ExampleService {
    @GET("api/v1/data")
    suspend fun getExampleData(): BaseResponse<ExampleResponse>

    @POST("api/v1/data")
    suspend fun postExampleData(
        @Body exampleRequestDto: ExampleRequest,
    ): BaseResponse<Unit>
}
