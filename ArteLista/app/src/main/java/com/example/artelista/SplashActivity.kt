package com.example.artelista

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.artelista.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        try
        {
            super.onCreate(savedInstanceState)
            binding = ActivitySplashBinding.inflate(layoutInflater)
            setContentView(binding.root)

            //Agregamos la referencia al ImageView
            val animLogo: Animation = AnimationUtils.loadAnimation(this, R.anim.anim1)
            binding.imgArteLista.startAnimation(animLogo)

            //Intent para crear instancia de la activity Login
            val intent = Intent(this, LoginActivity::class.java)
            animLogo.setAnimationListener(object:
                Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                }
                override fun onAnimationEnd(animation: Animation?) {
                    startActivity(intent)
                    finish()
                }
                override fun onAnimationRepeat(animation: Animation?) {
                }
            })
        }
        catch (e:java.lang.Exception)
        { e.printStackTrace() }
    }
}