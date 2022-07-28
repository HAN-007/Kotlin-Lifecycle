package com.example.lifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.lifecycle.databinding.ActivityMain2Binding
//todo bindign tanımlamazsak ugulama patlıyor herkezin bilgisine
class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    val TAG = "SecondActivityLog"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        Log.d(TAG,"OnCreate")
        setContentView(view)
    }
    override fun onStart() {
        super.onStart()
        //Thread.sleep(3000L)//burada neden işlemler yapılmamalı çok iyi anladım kullanıcı donuk bir ekranda bekletiliyor
        Log.d(TAG,"onStart")
    }

    override fun onResume() {
        super.onResume()
        binding.openHostBtn.setOnClickListener {
            startActivity(Intent(this,
                FragmentHost::class.java))
        }
        Log.d(TAG,"onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")
    }
}