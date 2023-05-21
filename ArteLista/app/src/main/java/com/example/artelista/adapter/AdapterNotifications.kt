package com.example.artelista.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.artelista.R
import com.example.artelista.model.Notification

class AdapterNotifications(private val NotificationListener: NotificationListener): RecyclerView.Adapter<AdapterNotifications.NotificationViewHolder>() {

    var listNotifications = ArrayList<Notification>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_notifications, parent, false)
        return NotificationViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val notification: Notification = listNotifications[position]
        holder.tvTituloNotification.text = notification.tituloNotification
        holder.tvCategoriaNotification.text = notification.categoriaNotification
        holder.tvHoraNotification.text = notification.horaNotification
        holder.itemView.setOnClickListener {
            NotificationListener.onNotificationClicked(notification, position)
        }
    }
    //-----------
    override fun getItemCount(): Int {
        return listNotifications.size
    }

    fun updateData(data:List<Notification>?){
        listNotifications.clear()
        listNotifications.addAll(data!!)
        notifyDataSetChanged()
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