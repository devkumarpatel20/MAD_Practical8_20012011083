package com.example.mad_practical8_20012011083

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashActivity : AppCompatActivity() {
    lateinit var guni_image : ImageView
    lateinit var logo_frambyframanimetion : AnimationDrawable
    lateinit var twinanimetion : Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        guni_image = findViewById(R.id.image)
        guni_image.setBackgroundResource(R.drawable.uvpce_logo_list)
        logo_frambyframanimetion = guni_image.background as AnimationDrawable

        twinanimetion = AnimationUtils.loadAnimation(this,R.anim.twin_animation)
        twinanimetion.setAnimationListener(this)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)

        if (hasFocus){
            logo_frambyframanimetion.start()
            guni_image.startAnimation(twinanimetion)
        }
    }

    fun onAnimationStart(p0: Animation?) {

    }

    fun onAnimationEnd(p0: Animation?) {
        Intent(this,MainActivity::class.java).also {
            startActivity(it)
            overridePendingTransition(R.anim.scale_center_in,R.anim.scale_center_out)
            finish()
        }
    }

    fun onAnimationRepeat(p0: Animation?) {

    }
}

private fun Animation.setAnimationListener(splashActivity: SplashActivity) {

}
