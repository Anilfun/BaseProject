package com.example.baseproject.home

import android.os.Bundle
import android.view.View
import com.example.baseproject.base.BaseFragment
import com.example.baseproject.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun preCreate(view: View?, bundle: Bundle?) {
        val homeVm = HomeViewModel()
        rootView.homeVM = homeVm
    }

    override fun exitFragment() {

    }

}