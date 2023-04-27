package com.example.artelista.ui.user

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
import com.example.artelista.databinding.FragmentUserDetalleBinding

class UserDetalleFragment : Fragment() {

    private var fbinding: FragmentUserDetalleBinding? = null
    private val binding get() = fbinding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fbinding = FragmentUserDetalleBinding.inflate(inflater, container, false)
        val view: View = binding.root

        val toolbar: Toolbar = fbinding!!.tbDetalleUsuario
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_back )
        toolbar.setTitle(R.string.strUsuarios)
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.setNavigationOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }
        return view
    }
}