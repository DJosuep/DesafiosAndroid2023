package com.example.artelista.ui.carrito

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.artelista.R
import com.example.artelista.databinding.FragmentCarritoDetalleBinding

/**
 * A simple [Fragment] subclass.
 * Use the [CarritoDetalleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CarritoDetalleFragment : Fragment() {
    private var fbinding: FragmentCarritoDetalleBinding?=null
    private val binding get() = fbinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fbinding = FragmentCarritoDetalleBinding.inflate(inflater, container, false)
        val view: View = binding.root

        val toolbar: Toolbar = fbinding!!.tbGaleriaDet
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_back )
        toolbar.setTitle(R.string.strCarrito)
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.setNavigationOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }
}