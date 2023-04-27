package com.example.artelista.ui.carrito

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.artelista.R
import com.example.artelista.adapter.AdapterCarrito
import com.example.artelista.databinding.FragmentCarritoBinding
import com.example.artelista.model.Carrito

class CarritoFragment : Fragment() {

    private var fbinding: FragmentCarritoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = fbinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val CarritoViewModel =
            ViewModelProvider(this)[CarritoViewModel::class.java]

        fbinding = FragmentCarritoBinding.inflate(inflater, container, false)
        val view: View = binding.root

        val toolbar: Toolbar = fbinding!!.tbCompras
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.setTitle(R.string.strCarrito)
        toolbar.setTitleTextColor(Color.WHITE)

        val recyclerCarrito: RecyclerView = fbinding!!.rvCompras
        recyclerCarrito.layoutManager = LinearLayoutManager(context)
        val adapterCarrito = AdapterCarrito(getCarrito(), R.layout.item_carrito, Activity())
        recyclerCarrito.adapter = adapterCarrito

        return view
    }

    fun getCarrito(): ArrayList<Carrito> {
        //--------------
        val carrito: ArrayList<Carrito> = ArrayList()
        //-------------
        carrito.add(Carrito("Henciel Daniel Bulimar", "1,600", "https://artelista.s3.amazonaws.com/obras/big/3/5/5/1209702-607458d7c0c2a.jpg", "Memories"))
        carrito.add(Carrito("Jesús Cuenca", "1,200", "https://artelista.s3.amazonaws.com/obras/big/1/6/4/1209582.jpg", "Memories"))
        carrito.add(Carrito("Pol Ledent", "1,600", "https://artelista.s3.amazonaws.com/obras/fichas/1/4/6/1209343.jpg", "Como en invierno"))
        carrito.add(Carrito("Maribel Flores", "1,600", "https://artelista.s3.amazonaws.com/obras/fichas/7/4/0/1208970.jpg", "Blossom"))
        carrito.add(Carrito("Nana Tchelidze", "575", "https://artelista.s3.amazonaws.com/obras/big/2/3/8/1245944.jpg", "El Puente"))
        return carrito
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }
}