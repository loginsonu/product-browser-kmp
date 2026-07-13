package com.sony.productbrowser.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sony.productbrowser.core.result.AppResult
import com.sony.productbrowser.domain.usecase.SearchProductsUseCase
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class SearchViewModel(
    private val searchProductsUseCase: SearchProductsUseCase
) : ViewModel() {

    private val searchQuery = MutableStateFlow("")

    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState = _uiState.asStateFlow()

    init {

        searchQuery
            .debounce(500)
            .distinctUntilChanged()
            .onEach { query ->

                _uiState.update {
                    it.copy(query = query)
                }

                if (query.isBlank()) {

                    _uiState.update {
                        it.copy(
                            products = emptyList(),
                            error = null,
                            isLoading = false
                        )
                    }

                } else {

                    searchProducts(query)

                }

            }
            .launchIn(viewModelScope)

    }

    fun onQueryChange(query: String) {
        _uiState.update {
            it.copy(query = query)
        }

        searchQuery.value = query
    }

    fun searchProducts(query: String = uiState.value.query) {

        viewModelScope.launch {

            _uiState.update {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            when (val result = searchProductsUseCase(query)) {

                is AppResult.Success -> {

                    _uiState.update {

                        it.copy(
                            isLoading = false,
                            products = result.data
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