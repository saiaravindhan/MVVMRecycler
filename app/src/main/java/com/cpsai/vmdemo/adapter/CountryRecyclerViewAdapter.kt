package com.cpsai.vmdemo.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cpsai.vmdemo.MainActivity
import com.cpsai.vmdemo.R
import com.cpsai.vmdemo.data.CountryList
import kotlinx.android.synthetic.main.recyclerview_layout.view.*

class CountryRecyclerViewAdapter(val activity: Activity): RecyclerView.Adapter<CountryRecyclerViewAdapter.CountryViewHolder>() {
    private var countryData : List<CountryList>? = null

    fun setCountryData(countryData : List<CountryList>?){
        this.countryData = countryData
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_layout,parent,false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countryData?.get(position)!!)
    }

    override fun getItemCount(): Int {
        if(countryData == null) return 0
        else return countryData?.size!!
    }


    class CountryViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val country = view.country
        val region = view.region

        fun bind(data: CountryList){
            country.text = data.country
            region.text = data.region
        }
    }
}