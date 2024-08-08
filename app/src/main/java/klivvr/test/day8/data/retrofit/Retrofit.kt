package klivvr.test.day8.data.retrofit

import klivvr.test.day8.data.ProductsService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    val interceptor = OkHttpClient.Builder().addInterceptor(logger).build()
    private val retrofit = Retrofit.Builder().baseUrl("https://dummyjson.com/").client(interceptor)
        .addConverterFactory(GsonConverterFactory.create()).build()
    val service = retrofit.create(ProductsService::class.java)
}