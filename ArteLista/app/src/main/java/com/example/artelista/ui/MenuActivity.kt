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
        val jsonCarrito = JSONArray("[\n" +
                "            {\n" +
                "                'artistacarrito' : 'Henciel Daniel Bulimar',\n" +
                "                'titulocarrito' : 'Memories',\n" +
                "                'preciocarrito' : '1,600',\n" +
                "                'imagencarrito' : 'https://artelista.s3.amazonaws.com/obras/big/3/5/5/1209702-607458d7c0c2a.jpg'\n" +
                "            },\n" +
                "            {\n" +
                "                'artistacarrito' : 'María Berroterán',\n" +
                "                'titulocarrito' : 'Pallace',\n" +
                "                'preciocarrito' : '1,800',\n" +
                "                'imagencarrito' : 'https://artelista.s3.amazonaws.com/obras/big/8/3/9/1201563-602e9746f3abf.jpg'\n" +
                "            },\n" +
                "            {\n" +
                "                'artistacarrito' : 'Marilin López',\n" +
                "                'titulocarrito' : 'Amanecer',\n" +
                "                'preciocarrito' : '1,200',\n" +
                "                'imagencarrito' : 'https://artelista.s3.amazonaws.com/obras/big/3/6/8/1204092-6006ef285e45d.jpg'\n" +
                "            },\n" +
                "            {\n" +
                "                'artistacarrito' : 'German Aguirre',\n" +
                "                'titulocarrito' : 'Atardecer',\n" +
                "                'preciocarrito' : '800',\n" +
                "                'imagencarrito' : 'https://artelista.s3.amazonaws.com/obras/big/3/5/5/1209702-607458d7c0c2a.jpg'\n" +
                "            },\n" +
                "            {\n" +
                "                'artistacarrito' : 'Brenda Martinez',\n" +
                "                'titulocarrito' : 'Hogar',\n" +
                "                'preciocarrito' : '1,100',\n" +
                "                'imagencarrito' : 'https://artelista.s3.amazonaws.com/obras/big/5/5/7/1191748-5f1033f19f2e4.jpg'\n" +
                "            },\n" +
                "            {\n" +
                "                'artistacarrito' : 'Karla Martinez',\n" +
                "                'titulocarrito' : 'Memories',\n" +
                "                'preciocarrito' : '1,600',\n" +
                "                'imagencarrito' : 'https://artelista.s3.amazonaws.com/obras/big/7/2/3/1190859-5ef3a721f3127.jpg'\n" +
                "            }\n" +
                "        ]")

        val fireDB: FirebaseFirestore = FirebaseFirestore.getInstance()
//-----------------------
        for (i in 0 until jsonCarrito.length())
        {
            val objGaleria = jsonCarrito.get(i) as JSONObject
            val carrito = Carrito()

            carrito.artistaCarrito = objGaleria.getString("artistacarrito")
            carrito.precioCarrito = objGaleria.getString("preciocarrito")
            carrito.imagenCarrito = objGaleria.getString("imagencarrito")
            carrito.tituloCarrito = objGaleria.getString("titulocarrito")
            fireDB.collection("Carrito").document().set(carrito)
        }

         */
    }

    private fun configurarNavegacion(navHostFragment:NavHostFragment){
        val bmenu: BottomNavigationView = binding.navView
        NavigationUI.setupWithNavController(bmenu, navHostFragment.navController)
    }

}