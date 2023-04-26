package com.example.artelista.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.artelista.R
import com.example.artelista.model.User

class AdapterUser(users: ArrayList<User>,
                        resource:Int, activity: Activity): RecyclerView.Adapter<AdapterUser.UserViewHolder>() {
    //------------
    private val users: ArrayList<User>
    private val resource: Int
    private val activity: Activity
    //------------
    init {
        this.users = users
        this.resource = resource
        this.activity = activity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(resource, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user : User = users[position]
        holder.tvNombreUsuario.text = user.getNombreUsuario()
        holder.tvCategoriaUsuario.text = user.getCategoriaUsuario()
        holder.tvPaisUsuario.text = user.getPaisUsuario()
        holder.itemView.setOnClickListener {
            Navigation.findNavController(holder.itemView).navigate(
                R.id.userDetalleFragment)
        }
    }
    //-----------
    override fun getItemCount(): Int {
        return users.size
    }
    //Adapter versus la interface de cada item
    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //---------------
        val tvNombreUsuario: TextView
        val tvCategoriaUsuario: TextView
        val tvPaisUsuario: TextView
        //---------------
        init {
            tvNombreUsuario = itemView.findViewById<View>(R.id.tvNombreUsuario) as TextView
            tvCategoriaUsuario = itemView.findViewById<View>(R.id.tvCategoriaUsuario) as TextView
            tvPaisUsuario = itemView.findViewById<View>(R.id.tvPaisUsuario) as TextView
        }
    }
}