package com.example.baseproject.home

import androidx.databinding.Bindable
import com.example.baseproject.base.BaseViewModel
import com.tencent.mmkv.MMKV

class HomeViewModel : BaseViewModel() {

    private lateinit var mmkv: MMKV
    @Bindable
    val numbers = ArrayList<Int>()
    fun loadData(){
        mmkv = MMKV.defaultMMKV()
        for (i in 0 until 100){
            numbers.add(i)
        }
        mmkv.encode("data", numbers.toString())
    }

    fun getData(): String? {
        return mmkv.decodeString("data", "0")
    }

}