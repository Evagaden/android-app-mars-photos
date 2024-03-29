package com.example.android.marsphotos.network

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET
import kotlin.jvm.internal.Intrinsics.Kotlin


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val BASE_URL = "https:android-kotlin-fun-mars-server.appspot.com"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MarsApiService{
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}

//Object declaration
object MarsApi{ val retrofitService: MarsApiService by lazy {
    retrofit.create(MarsApiService::class.java) }
}

