package klivvr.test.day8.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import klivvr.test.day8.data.retrofit.RetrofitService
import klivvr.test.day8.presentation.mappers.toUi
import klivvr.test.day8.presentation.models.ProductUiModel
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _productList = MutableLiveData<List<ProductUiModel>>()
    val productList: LiveData<List<ProductUiModel>> get() = _productList

    init {
        getProductList()
    }

    private fun getProductList() {
        viewModelScope.launch {
            val list = RetrofitService.service.getProducts().products?.map {
                it.toUi {
                    Log.d("MainViewModel", "getProductList: ${it.title}")
                }
            }.orEmpty()

            _productList.postValue(list)
        }

    }
}