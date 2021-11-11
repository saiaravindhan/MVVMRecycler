package com.cpsai.vmdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cpsai.vmdemo.adapter.CountryRecyclerViewAdapter
import com.cpsai.vmdemo.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var recyclerViewAdapter: CountryRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerViewInstance()
        initViewModel()
    }

    fun initRecyclerViewInstance(){
        countryListRecyclerView.layoutManager = LinearLayoutManager(this)
        recyclerViewAdapter = CountryRecyclerViewAdapter(this)
        countryListRecyclerView.adapter = recyclerViewAdapter
    }

    private fun initViewModel(){
        val viewmodel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewmodel.getLiveDataObserver().observe(this, Observer {
            if(it == null){
                Toast.makeText(this,"error", Toast.LENGTH_LONG).show()
            }else{
                recyclerViewAdapter.setCountryData(it)
                recyclerViewAdapter.notifyDataSetChanged()
            }
        })
        viewmodel.makeApiCall()
    }
}