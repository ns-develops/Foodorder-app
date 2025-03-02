package com.example.foodorderapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AlphaAnimation
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val splashText: TextView = findViewById(R.id.splashText)
        val splashText2: TextView = findViewById(R.id.splashText2)


        animateText(splashText, 0, "Crepes and")
        animateText(splashText2, 3000, "Co.")

        // waits 6 sek before LoginActivity
        Handler().postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 8000)
    }

    // animate
    private fun animateText(textView: TextView, delay: Long, text: String) {
        val handler = Handler()
        for (i in text.indices) {
            handler.postDelayed({
                val currentText = text.substring(0, i + 1)
                textView.text = currentText


                val fadeIn = AlphaAnimation(0f, 1f)
                fadeIn.duration = 500 // duration time for letters
                textView.startAnimation(fadeIn)
            }, (i * 500).toLong() + delay) // time between letters
        }


        textView.alpha = 1f
    }
}
