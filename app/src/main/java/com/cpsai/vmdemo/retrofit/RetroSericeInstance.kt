package com.cpsai.vmdemo.retrofit

import com.cpsai.vmdemo.data.CountryList
import retrofit2.Call
import retrofit2.http.GET

interface RetroSericeInstance {

    @GET("countries")
    fun getCountries(): Call<List<CountryList>>
}

