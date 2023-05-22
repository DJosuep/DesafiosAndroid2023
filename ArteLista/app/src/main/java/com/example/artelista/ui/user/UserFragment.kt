package com.example.artelista.ui.user

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
import com.example.artelista.adapter.AdapterUser
import com.example.artelista.adapter.UserListener
import com.example.artelista.databinding.FragmentUserBinding
import com.example.artelista.model.User
import com.example.artelista.viewmodel.UserViewModel

class UserFragment : Fragment() , UserListener {

    private var fbinding: FragmentUserBinding? = null
    private val binding get() = fbinding!!

    private lateinit var userAdapter: AdapterUser
    private lateinit var viewModelUser: UserViewModel

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

        viewModelUser = ViewModelProvider(this)[UserViewModel::class.java]
        viewModelUser.getUserVM()
        userAdapter = AdapterUser(this)
        binding.rvUsuario.apply {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            adapter = userAdapter
        }
        observerViewModel()

        return view
    }

    override fun onUserClicked(User: User, position: Int) {
        val bundle = bundleOf("user" to User)
        NavHostFragment.findNavController(this).navigate(R.id.userDetalleFragment, bundle)
    }

    private fun observerViewModel(){
        viewModelUser.listUser.observe(viewLifecycleOwner) { user ->
            userAdapter.updateData(user)
        }
        viewModelUser.isLoading.observe(viewLifecycleOwner){
            if(it!=null){
                binding.progressUser.visibility = View.INVISIBLE
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }

}