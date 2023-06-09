package com.example.artelista.ui

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import com.example.artelista.R
import com.example.artelista.databinding.FragmentUbicacionBinding

class UbicacionFragment : Fragment() {

    private var fbinding:FragmentUbicacionBinding? = null
    private val binding get() = fbinding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fbinding = FragmentUbicacionBinding.inflate(inflater, container, false)
        val view: View = binding.root
        val imgMapa: ImageView = fbinding!!.imgMapa

        imgMapa.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.ubicaiondetFragment)
        }

        val toolbar: Toolbar = fbinding!!.toolUbicacion
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_back )
        toolbar.setTitle(R.string.strUbicacion)
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.setNavigationOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        fbinding = null
    }

}