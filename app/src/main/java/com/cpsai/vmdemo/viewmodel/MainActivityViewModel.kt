package com.cpsai.vmdemo.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cpsai.vmdemo.data.CountryList
import com.cpsai.vmdemo.retrofit.RetroInstance
import com.cpsai.vmdemo.retrofit.RetroSericeInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel: ViewModel() {

    lateinit var livedatalist: MutableLiveData<List<CountryList>>
    init {
        livedatalist = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<List<CountryList>>{
        return livedatalist
    }

    fun makeApiCall(){
        val retroInstance = RetroInstance.getRetroInstance()
        val retroservice = retroInstance.create(RetroSericeInstance::class.java)
        val call = retroservice.getCountries()
        call.enqueue(object : Callback<List<CountryList>>{
            override fun onFailure(call: Call<List<CountryList>>, t: Throwable) {
                livedatalist.postValue(null)
                Log.e("LOGS","FAILED")
            }

            override fun onResponse(
                call: Call<List<CountryList>>,
                response: Response<List<CountryList>>
            ) {
                livedatalist.postValue(response.body())
                Log.e("LOGS",""+response.body().toString())
            }
        })

    }
}