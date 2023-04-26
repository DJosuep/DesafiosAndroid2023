package com.example.artelista

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.artelista.databinding.ActivityMenuBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

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

        //Color top action bar
        //Objects.requireNonNull(supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.WHITE)))
    }

    private fun setContentView(HomeFragment: Any) {
        TODO("Not yet implemented")
    }
}