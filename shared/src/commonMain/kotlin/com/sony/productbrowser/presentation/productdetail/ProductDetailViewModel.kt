package com.sony.productbrowser.presentation.productdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sony.productbrowser.core.result.AppResult
import com.sony.productbrowser.domain.usecase.GetProductDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductDetailViewModel(
    private val productId: Int,
    private val getProductDetailUseCase: GetProductDetailUseCase
) : ViewModel() {

    private val _uiState =
        MutableStateFlow(ProductDetailUiState())

    val uiState = _uiState.asStateFlow()

    init {
        getProduct()
    }

    fun getProduct() {

        viewModelScope.launch(Dispatchers.IO) {

            _uiState.update {
                it.copy(isLoading = true)
            }

            when (
                val result = getProductDetailUseCase(productId)
            ) {

                is AppResult.Success -> {

                    _uiState.update {

                        it.copy(
                            isLoading = false,
                            product = result.data
                        )

                    }

                }

                is AppResult.Error -> {

                    _uiState.update {

                        it.copy(
                            isLoading = false,
                            error = result.message
                        )

                    }

                }

            }

        }

    }

}