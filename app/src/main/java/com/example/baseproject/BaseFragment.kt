package com.example.baseproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.lang.reflect.ParameterizedType

abstract class BaseFragment<T : ViewBinding?> : Fragment() {
    private var rootView: T? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val type = javaClass.genericSuperclass
        val aClass = (type as ParameterizedType).actualTypeArguments[0] as Class<*>
        try {
            val method = aClass.getDeclaredMethod(
                "inflate",
                LayoutInflater::class.java,
                ViewGroup::class.java,
                Boolean::class.javaPrimitiveType
            )
            @Suppress("UNCHECKED_CAST")
            rootView = method.invoke(null, layoutInflater, container, false) as T
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return rootView!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preCreate(view, arguments)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
        exitFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        rootView = null
    }

    abstract fun preCreate(view: View?, bundle: Bundle?)

    abstract fun exitFragment()

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessage(event: GlobalEvent) {
        when (event.flag) {
            GlobalEvent.FRAGMENT_HOME -> {
                FragmentHelper.toHome(this)
            }
        }
    }
}