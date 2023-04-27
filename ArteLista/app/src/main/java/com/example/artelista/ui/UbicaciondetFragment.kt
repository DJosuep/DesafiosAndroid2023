package com.example.artelista.ui

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import com.example.artelista.R
import com.example.artelista.databinding.FragmentUbicaiondetBinding


class UbicaciondetFragment : Fragment() {

    private var fbinding: FragmentUbicaiondetBinding? = null
    private val binding get() = fbinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fbinding = FragmentUbicaiondetBinding.inflate(inflater, container, false)
        val view: View = binding.root

        val toolbar: Toolbar = fbinding!!.tbUbicacionDet
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_back )
        toolbar.setTitle(R.string.strUbicacion)
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.setNavigationOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }

        return view
    }

}