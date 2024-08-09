package klivvr.test.day8.data.remoteDataSource.source

import klivvr.test.day8.data.models.Product
import klivvr.test.day8.data.remoteDataSource.retrofit.ProductsService

class RemoteDataSourceImpl(private val service: ProductsService) : RemoteDataSource {
    override suspend fun getProducts(): List<Product> {
        return service.getProducts().products.orEmpty()
    }

    override suspend fun getProductById(id: Int): Product {
        return service.getProductById(id)
    }
}