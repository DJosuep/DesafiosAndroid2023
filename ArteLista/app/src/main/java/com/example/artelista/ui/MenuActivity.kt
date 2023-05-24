package com.example.artelista.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.artelista.R
import com.example.artelista.databinding.ActivityMenuBinding
import com.example.artelista.model.User
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.firestore.FirebaseFirestore
import org.json.JSONArray
import org.json.JSONObject
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
        configurarNavegacion(navHostFragment)

        /*
        val jsonUser = JSONArray("[\n" +
                "            {\n" +
                "                'nombreUsuario' : 'Armando José Aguirre',\n" +
                "                'categoriaUsuario' : 'Muebles',\n" +
                "                'paisUsuario' : 'Guatemala'\n" +
                "            },\n" +
                "            {\n" +
                "                'nombreUsuario' : 'German Traña Obando',\n" +
                "                'categoriaUsuario' : 'Tecnología',\n" +
                "                'paisUsuario' : 'Costa Rica'\n" +
                "            },\n" +
                "            {\n" +
                "                'nombreUsuario' : 'Pol Ledent',\n" +
                "                'categoriaUsuario' : 'Tecnología',\n" +
                "                'paisUsuario' : 'Guatemala'\n" +
                "            },\n" +
                "            {\n" +
                "                'nombreUsuario' : 'Maribel Flores',\n" +
                "                'categoriaUsuario' : 'Muebles',\n" +
                "                'paisUsuario' : 'Honduras'\n" +
                "            },\n" +
                "            {\n" +
                "                'nombreUsuario' : 'Nana Tchelidze',\n" +
                "                'categoriaUsuario' : 'Juguetes',\n" +
                "                'paisUsuario' : 'Honduras'\n" +
                "            },\n" +
                "            {\n" +
                "                'nombreUsuario' : 'Armando José Aguirre',\n" +
                "                'categoriaUsuario' : 'Juguetes',\n" +
                "                'paisUsuario' : 'Costa Rica'\n" +
                "            }\n" +
                "        ]")

        val fireDB: FirebaseFirestore = FirebaseFirestore.getInstance()
//-----------------------
        for (i in 0 until jsonUser.length())
        {
            val objNotification = jsonUser.get(i) as JSONObject
            val user = User()

            user.nombreUsuario = objNotification.getString("nombreUsuario")
            user.categoriaUsuario = objNotification.getString("categoriaUsuario")
            user.paisUsuario = objNotification.getString("paisUsuario")
            fireDB.collection("Usuario").document().set(user)
        }
        */
    }

    private fun configurarNavegacion(navHostFragment:NavHostFragment){
        val bmenu: BottomNavigationView = binding.navView
        NavigationUI.setupWithNavController(bmenu, navHostFragment.navController)
    }

}