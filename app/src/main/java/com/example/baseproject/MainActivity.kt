package com.example.baseproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.example.baseproject.databinding.ActivityMainBinding
import com.tencent.mmkv.MMKV

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        val navController = Navigation.findNavController(this@MainActivity, R.id.main)
        navController.setGraph(R.navigation.navigation)
        initMMKV()
    }

    private fun initMMKV(){
        val rootDir = MMKV.initialize(this)
        println("mmkv root: $rootDir")
    }

    private fun initData(){

    }
}