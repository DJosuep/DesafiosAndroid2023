package com.example.artelista.ui.carrito

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.artelista.R
import com.example.artelista.adapter.AdapterCarrito
import com.example.artelista.adapter.CarritoListener
import com.example.artelista.databinding.FragmentCarritoBinding
import com.example.artelista.model.Carrito
import com.example.artelista.viewmodel.CarritoViewModel

class CarritoFragment : Fragment() , CarritoListener{

    private var fbinding: FragmentCarritoBinding? = null
    private val binding get() = fbinding!!

    private lateinit var carritoAdapter: AdapterCarrito
    private lateinit var viewModelCarrito: CarritoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        ViewModelProvider(this)[CarritoViewModel::class.java]

        fbinding = FragmentCarritoBinding.inflate(inflater, container, false)
        val view: View = binding.root

        val toolbar: Toolbar = fbinding!!.tbCompras
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.setTitle(R.string.strCarrito)
        toolbar.setTitleTextColor(Color.WHITE)

        viewModelCarrito = ViewModelProvider(this)[CarritoViewModel::class.java]
        viewModelCarrito.getCarritoVM()
        carritoAdapter = AdapterCarrito(this)
        binding.rvCompras.apply {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            adapter = carritoAdapter
        }
        observerViewModel()

        return view
    }

    override fun onCarritoClicked(Carrito: Carrito, position: Int) {
        val bundle = bundleOf("carrito" to Carrito)
        NavHostFragment.findNavController(this).navigate(R.id.carritoDetalleFragment, bundle)
    }

    private fun observerViewModel(){
        viewModelCarrito.listCarrito.observe(viewLifecycleOwner) { carrito ->
            carritoAdapter.updateData(carrito)
        }
        viewModelCarrito.isLoading.observe(viewLifecycleOwner){
            if(it!=null){
                binding.progressCarrito.visibility =    View.INVISIBLE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }
}