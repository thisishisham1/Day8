package klivvr.test.day8.data

import klivvr.test.day8.data.models.Product
import klivvr.test.day8.data.retrofit.responseModel.ProductsListResponse
import retrofit2.http.GET

interface ProductsService {
    @GET("/products")
    suspend fun getProducts(): ProductsListResponse

    @GET("products/{id}")
    suspend fun getProductById(id: Int): Product
}