package com.example.artelista.ui.notifications

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
import com.example.artelista.adapter.AdapterNotifications
import com.example.artelista.adapter.NotificationListener
import com.example.artelista.databinding.FragmentNotificationsBinding
import com.example.artelista.model.Notification
import com.example.artelista.viewmodel.NotificationsViewModel

class NotificationsFragment : Fragment() , NotificationListener{

    private var fbinding: FragmentNotificationsBinding? = null
    private val binding get() = fbinding!!

    private lateinit var notificationAdapter: AdapterNotifications
    private lateinit var viewModelNotifications: NotificationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        ViewModelProvider(this)[NotificationsViewModel::class.java]

        fbinding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val view: View = binding.root

        val toolbar: Toolbar = fbinding!!.tvNotif
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.setTitle(R.string.strNotificaciones)
        toolbar.setTitleTextColor(Color.WHITE)

        viewModelNotifications = ViewModelProvider(this)[NotificationsViewModel::class.java]
        viewModelNotifications.getNotificationsVM()
        notificationAdapter = AdapterNotifications(this)
        binding.rvNotification.apply {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            adapter = notificationAdapter
        }
        observerViewModel()

        return view
    }

    override fun onNotificationClicked(Notification: Notification, position: Int) {
        val bundle = bundleOf("notification" to Notification)
        NavHostFragment.findNavController(this).navigate(R.id.carritoDetalleFragment, bundle)
    }

    private fun observerViewModel(){
        viewModelNotifications.listNotification.observe(viewLifecycleOwner) { notification ->
            notificationAdapter.updateData(notification)
        }
        viewModelNotifications.isLoading.observe(viewLifecycleOwner){
            if(it!=null){
                binding.progressNotification.visibility = View.INVISIBLE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }
}