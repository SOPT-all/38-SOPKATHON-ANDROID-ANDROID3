package com.sopt.android3.presentation.jotehyun

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.android3.data.network.ServicePool
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class JotehyunViewModel: ViewModel() {
    // 이거 ServicePool에서 꺼내는 Service 만들어서 써야돼요! 이거 바꿔야됨 (변수명도 바꿔주세용)
    private val exampleServce = ServicePool.exampleService
    private val _uiState = MutableStateFlow(JotehyunUiState())
    val uiState: StateFlow<JotehyunUiState> = _uiState.asStateFlow()

    private fun tehoonPost() {
        viewModelScope.launch {
//            val response = exampleService.postExampleData(request)

            try{

            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        isSuccess = false,
                        error = e.message ?: "example failed"
                    )
                }
            }
        }
    }
}


