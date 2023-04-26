package com.example.artelista.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.artelista.R
import com.example.artelista.model.Notification

class AdapterNotifications(
    notifications: ArrayList<Notification>,
    resource:Int, activity: Activity): RecyclerView.Adapter<AdapterNotifications.NotificationViewHolder>() {
    //------------
    private val notifications: ArrayList<Notification>
    private val resource: Int
    private val activity: Activity
    //------------
    init {
        this.notifications = notifications
        this.resource = resource
        this.activity = activity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(resource, parent, false)
        return NotificationViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val notification : Notification = notifications[position]
        holder.tvTituloNotification.text = notification.getTituloNotification()
        holder.tvCategoriaNotification.text = notification.getCategoriaNotification()
        holder.tvHoraNotification.text = notification.getHoraNotification()
        holder.itemView.setOnClickListener {
            Navigation.findNavController(holder.itemView).navigate(
                R.id.ubicacionFragment)
        }
    }
    //-----------
    override fun getItemCount(): Int {
        return notifications.size
    }
    //Adapter versus la interface de cada item
    inner class NotificationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //---------------
        val tvTituloNotification: TextView
        val tvCategoriaNotification: TextView
        val tvHoraNotification: TextView
        //---------------
        init {
            tvTituloNotification = itemView.findViewById<View>(R.id.tvTituloNotification) as TextView
            tvCategoriaNotification = itemView.findViewById<View>(R.id.tvCategoriaNotification) as TextView
            tvHoraNotification = itemView.findViewById<View>(R.id.tvNotificationHora) as TextView
        }
    }
}