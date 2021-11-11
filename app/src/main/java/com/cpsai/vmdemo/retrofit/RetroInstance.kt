package com.cpsai.vmdemo.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {
    companion object{
        val Base_url = "https://api.first.org/data/v1/" //countries

        fun getRetroInstance(): Retrofit{
            return Retrofit.Builder()
                .baseUrl(Base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}