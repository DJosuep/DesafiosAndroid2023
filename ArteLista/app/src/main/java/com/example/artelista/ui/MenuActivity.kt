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

        //--- Carga de datos
        val jsonNotification = JSONArray("[\n" +
                "            {\n" +
                "                'tituloNotificacion' : 'Subasta de pañuelos usados',\n" +
                "                'categoriaNotificacion' : 'Subasta',\n" +
                "                'horaNotificacion' : '10:15'\n" +
                "            },\n" +
                "            {\n" +
                "                'tituloNotificacion' : 'Subasta de pañuelos usados',\n" +
                "                'categoriaNotificacion' : 'Subasta',\n" +
                "                'horaNotificacion' : '10:15'\n" +
                "            },\n" +
                "            {\n" +
                "                'tituloNotificacion' : 'Subasta de pañuelos usados',\n" +
                "                'categoriaNotificacion' : 'Subasta',\n" +
                "                'horaNotificacion' : '10:15'\n" +
                "            },\n" +
                "            {\n" +
                "                'tituloNotificacion' : 'Subasta de pañuelos usados',\n" +
                "                'categoriaNotificacion' : 'Subasta',\n" +
                "                'horaNotificacion' : '10:15'\n" +
                "            },\n" +
                "            {\n" +
                "                'tituloNotificacion' : 'Subasta de pañuelos usados',\n" +
                "                'categoriaNotificacion' : 'Subasta',\n" +
                "                'horaNotificacion' : '10:15'\n" +
                "            },\n" +
                "            {\n" +
                "                'tituloNotificacion' : 'Subasta de pañuelos usados',\n" +
                "                'categoriaNotificacion' : 'Subasta',\n" +
                "                'horaNotificacion' : '10:15'\n" +
                "            }\n" +
                "        ]")

        val fireDB: FirebaseFirestore = FirebaseFirestore.getInstance()
//-----------------------
        for (i in 0 until jsonNotification.length())
        {
            val objNotification = jsonNotification.get(i) as JSONObject
            val notification = com.example.artelista.model.Notification()

            notification.tituloNotification = objNotification.getString("tituloNotificacion")
            notification.categoriaNotification = objNotification.getString("categoriaNotificacion")
            notification.horaNotification = objNotification.getString("horaNotificacion")
            fireDB.collection("Notification").document().set(notification)
        }

         */
    }

    private fun configurarNavegacion(navHostFragment:NavHostFragment){
        val bmenu: BottomNavigationView = binding.navView
        NavigationUI.setupWithNavController(bmenu, navHostFragment.navController)
    }

}