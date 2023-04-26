package com.example.artelista

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.artelista.databinding.ActivityMenuBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_menu) as NavHostFragment
        val navController = navHostFragment.findNavController()

        navView.setupWithNavController(navController)

        val view = binding.root
        setContentView(view)
        configurarNavegacion()

        //Color top action bar
        //Objects.requireNonNull(supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.WHITE)))
    }

    protected fun configurarNavegacion(){
        val bmenu: BottomNavigationView = binding.navView
        NavigationUI.setupWithNavController(bmenu, Navigation.findNavController(this, R.id.nav_host_fragment_activity_menu))
    }

    private fun setContentView(HomeFragment: Any) {
        TODO("Not yet implemented")
    }
}