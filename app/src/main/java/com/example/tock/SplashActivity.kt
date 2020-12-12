package com.example.tock

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceStatus : Bundle?){
        super.onCreate(savedInstanceStatus)
        setContentView(R.layout.activity_splash)
        val handler = Handler()
        /*
        handler.postDelayed({
            val intent = Intent(baseContext, MainActivity::class)
            startActivity(intent)
            finish()
        }, 3000)*/
    }
}