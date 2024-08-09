package klivvr.test.day8.data.remoteDataSource.source

import klivvr.test.day8.data.models.Product

interface RemoteDataSource {
    suspend fun getProducts(): List<Product>
    suspend fun getProductById(id: Int): Product
}