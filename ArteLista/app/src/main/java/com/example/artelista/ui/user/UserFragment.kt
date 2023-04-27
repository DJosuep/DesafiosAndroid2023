package com.example.artelista.ui.user

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
import com.example.artelista.adapter.AdapterUser
import com.example.artelista.databinding.FragmentUserBinding
import com.example.artelista.model.User

class UserFragment : Fragment() {

    private var fbinding: FragmentUserBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = fbinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        ViewModelProvider(this)[UserViewModel::class.java]

        fbinding = FragmentUserBinding.inflate(inflater, container, false)
        val view: View = binding.root

        val toolbar: Toolbar = fbinding!!.tbUsuario
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.setTitle(R.string.strUsuarios)
        toolbar.setTitleTextColor(Color.WHITE)

        //------
        val reciclerUser : RecyclerView = fbinding!!.rvUsuario
        reciclerUser.layoutManager = LinearLayoutManager(context)
        val adapterNotification = AdapterUser(getUsers(), R.layout.item_usuario , Activity())
        reciclerUser.adapter = adapterNotification

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }

    private fun getUsers() : ArrayList<User>{
        //-----
        val users: ArrayList<User> = ArrayList()
        //-----
        users.add(User("Armando José Aguirre", "Muebles", "Guatemala"))
        users.add(User("German Traña Obando", "Tecnología", "Costa Rica"))
        users.add(User("Pol Ledent", "Tecnología", "Guatemala"))
        users.add(User("Maribel Flores", "Muebles", "Honduras"))
        users.add(User("Nana Tchelidze", "Juguetes","Honduras"))
        users.add(User("Armando José Aguirre", "Juguetes", "Costa Rica"))
        users.add(User("German Traña Obando","Muebles", "Guatemala"))
        users.add(User("Pol Ledent", "Muebles", "Nicaragua"))
        users.add(User("Maribel Flores", "Juguetes", "Nicaragua"))

        return users
    }
}