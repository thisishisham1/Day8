package klivvr.test.day8.data.remoteDataSource.retrofit.responseModel

import com.google.gson.annotations.SerializedName
import klivvr.test.day8.data.models.Product


data class ProductsListResponse(

    @SerializedName("products") val products: List<Product>?,
    @SerializedName("total") val total: Int?,
    @SerializedName("skip") val skip: Int?,
    @SerializedName("limit") val limit: Int?

)