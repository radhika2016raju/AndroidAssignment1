package com.example.myassignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {

    private lateinit var preferenceManager: PreferenceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        preferenceManager = PreferenceManager(this)
        Handler().postDelayed({
            if (preferenceManager.getBoolean() == true) {

                startActivity(Intent(this, ShowListActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this, LoginActivity::class.java))

            }
        }, SPLASH_TIME)


    }
}

