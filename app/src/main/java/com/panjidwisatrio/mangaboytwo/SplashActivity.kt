package com.panjidwisatrio.mangaboytwo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.panjidwisatrio.mangaboytwo.databinding.ActivitySplashBinding
import com.panjidwisatrio.mangaboytwo.utils.SPLASH_SCREEN_TAG
import java.lang.Exception

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        object : Thread() {
            override fun run() {
                try {
                    sleep(3000)
                    startActivity(Intent(baseContext, MainActivity::class.java))
                    finish()
                } catch (e : Exception) {
                    Log.d(SPLASH_SCREEN_TAG, e.message.toString())
                }
            }
        }.start()
    }
}