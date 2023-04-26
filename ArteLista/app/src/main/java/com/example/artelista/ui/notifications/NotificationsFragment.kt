package com.example.artelista.ui.notifications

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.artelista.R
import com.example.artelista.adapter.AdapterNotifications
import com.example.artelista.databinding.FragmentNotificationsBinding
import com.example.artelista.model.Notification

class NotificationsFragment : Fragment() {

    private var fbinding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = fbinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel = ViewModelProvider(this)[NotificationsViewModel::class.java]

        fbinding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val view: View = binding.root

        //------
        val reciclerNotification : RecyclerView = fbinding!!.rvNotification
        reciclerNotification.layoutManager = LinearLayoutManager(context)
        val adapterNotification = AdapterNotifications(getNotifications(), R.layout.item_notifications , Activity())
        reciclerNotification.adapter = adapterNotification

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }

    //Carga con valores hardcode de notifications
    //-----Llenar con datos hardcode
    fun getNotifications() : ArrayList<Notification>{
        //-----
        val notification: ArrayList<Notification> = ArrayList()
        //-----
        notification.add(Notification("Subasta de pañuelos usados","Subasta","10:15"))
        notification.add(Notification("Subasta de pañuelos usados","Subasta","10:15"))
        notification.add(Notification("Subasta de pañuelos usados","Subasta","10:15"))
        notification.add(Notification("Subasta de pañuelos usados","Subasta","10:15"))
        notification.add(Notification("Subasta de pañuelos usados","Subasta","10:15"))
        notification.add(Notification("Subasta de pañuelos usados","Subasta","10:15"))
        notification.add(Notification("Subasta de pañuelos usados","Subasta","10:15"))
        notification.add(Notification("Subasta de pañuelos usados","Subasta","10:15"))
        notification.add(Notification("Subasta de pañuelos usados","Subasta","10:15"))
        notification.add(Notification("Subasta de pañuelos usados","Subasta","10:15"))
        notification.add(Notification("Subasta de pañuelos usados","Subasta","10:15"))
        notification.add(Notification("Subasta de pañuelos usados","Subasta","10:15"))
        notification.add(Notification("Subasta de pañuelos usados","Subasta","10:15"))
        notification.add(Notification("Subasta de pañuelos usados","Subasta","10:15"))
        notification.add(Notification("Subasta de pañuelos usados","Subasta","10:15"))
        notification.add(Notification("Subasta de pañuelos usados","Subasta","10:15"))
        notification.add(Notification("Subasta de pañuelos usados","Subasta","10:15"))
        notification.add(Notification("Subasta de pañuelos usados","Subasta","10:15"))
        notification.add(Notification("Subasta de pañuelos usados","Subasta","10:15"))
        notification.add(Notification("Subasta de pañuelos usados","Subasta","10:15"))
        notification.add(Notification("Subasta de pañuelos usados","Subasta","10:15"))
        notification.add(Notification("Subasta de pañuelos usados","Subasta","10:15"))
        notification.add(Notification("Subasta de pañuelos usados","Subasta","10:15"))
        notification.add(Notification("Subasta de pañuelos usados","Subasta","10:15"))
        notification.add(Notification("Subasta de pañuelos usados","Subasta","10:15"))
        notification.add(Notification("Subasta de pañuelos usados","Subasta","10:15"))
        notification.add(Notification("Subasta de pañuelos usados","Subasta","10:15"))

        return notification
    }
}