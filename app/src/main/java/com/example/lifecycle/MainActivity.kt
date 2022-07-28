package com.example.lifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.example.lifecycle.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val TAG = "MainActivityLog"
    private var temp = model()
    private var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        //burada sayfa değişimlerinde istek atmamız gereken bir api olduğunu var sayalım burada istek atarsak sadece bir kere atmış olur sayfa değişimlerini takip edemeyiz
        //counter += 1

        //burada bağlantıyı başka bir statede oluşturdum artışı resumde da yaptım bağlantı olmadı
        /*var currentCounter = temp.getCounter()
        binding.textView3.text = currentCounter.toString()*/


        Log.d(TAG,"OnCreate")


        /*bindig kullanırsak burada ui işlemkerini handle edbiliyor ama
        hala bir sorun oluşmaması açısından burada ui işlemleri yapmamamlı*/
        /*val tw = findViewById<TextView>(R.id.textView3)
        tw.text = "test"*/
        setContentView(view)
    }

    override fun onStart() {
        super.onStart()
        //Thread.sleep(6000L)//kullanıcıyı boş bir geçişte beklettik hiç olmadı
        Log.d(TAG,"onStart")
    }

    override fun onResume() {

        super.onResume()
        counter += 1
        Log.d(TAG,"onResume")
        binding.openSecondBtn.setOnClickListener {
            startActivity(Intent(this,MainActivity2::class.java))
            /*temp.up()
            var currentCounter = temp.getCounter()
            binding.textView3.text = currentCounter.toString()*/
        }
        binding.textView3.text = counter.toString()
    }

    override fun onPause() {
        //onResume de başlayan onPouse da bitmeli efendim
        //son işlemler burada değil onStopta yapılmalı
        super.onPause()
        Log.d(TAG,"onPause")
    }

    override fun onStop() {
        //api yazmaları vb burada olmalı birde onstartta bşlayan onstopta bitmeli
        super.onStop()
        Log.d(TAG,"onStop")
    }

    override fun onDestroy() {
        //arka planda binding boşa yer kaplamasın diye atlama olur diye nulla eşitliyoruz
        super.onDestroy()
        binding != null
        Log.d(TAG,"onDestroy")
    }
}