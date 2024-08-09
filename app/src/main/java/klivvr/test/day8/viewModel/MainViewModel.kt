package klivvr.test.day8.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import klivvr.test.day8.data.repository.Repository
import klivvr.test.day8.presentation.mappers.toUi
import klivvr.test.day8.presentation.models.ProductUiModel
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {
    private val _productList = MutableLiveData<List<ProductUiModel>>()
    val productList: LiveData<List<ProductUiModel>> get() = _productList
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading
    private val _product = MutableLiveData<ProductUiModel>()
    val product: LiveData<ProductUiModel> get() = _product


    init {
        getProductList()
    }

    private fun getProductList() {
        viewModelScope.launch {
            _isLoading.postValue(true)
            val list = repository.getProducts().map {
                it.toUi {
                    Log.d("MainViewModel", "getProductList: ${it.title}")
                }
            }
            _productList.postValue(list)
            _isLoading.postValue(false)
        }
    }

    fun getProductById(id: Int) {
        viewModelScope.launch {
            _isLoading.postValue(true)
            val product = repository.getProductById(id).toUi {
                Log.d("MainViewModel", "getProductById")
            }
            _product.postValue(product)
            _isLoading.postValue(false)
        }
    }

}

class MainViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}