package klivvr.test.day8.data.repository

import klivvr.test.day8.data.remoteDataSource.source.RemoteDataSource

class Repository(private val remoteDataSource: RemoteDataSource) {
    suspend fun getProducts() = remoteDataSource.getProducts()
    suspend fun getProductById(id: Int) = remoteDataSource.getProductById(id)
}