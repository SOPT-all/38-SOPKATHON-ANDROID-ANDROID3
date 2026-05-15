package com.sopt.android3.presentation.tehoon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.android3.data.network.ServicePool
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TehoonViewModel: ViewModel() {
    // 이거 ServicePool에서 꺼내는 Service 만들어서 써야돼요! 이거 바꿔야됨 (변수명도 바꿔주세용)
    private val exampleServce = ServicePool.exampleService
    private val _uiState = MutableStateFlow(TehoonUiState())
    val uiState: StateFlow<TehoonUiState> = _uiState.asStateFlow()

    private fun example() {
        viewModelScope.launch {
            //request 는 따로 데이터 담아서 보내면 되고, 이런식으로 service 객체에서 함수 뽑아 쓰면 됩니다
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


