package com.team.dbgo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler()
        handler.postDelayed({
            //startActivity(Intent(applicationContext, MypageActivity::class.java))
            startActivity(Intent(applicationContext, LoginActivity::class.java))
            finish()
        }, 3000)
    }
}
