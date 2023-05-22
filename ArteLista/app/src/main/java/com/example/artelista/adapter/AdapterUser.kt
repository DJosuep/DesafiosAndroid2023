package com.example.artelista.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.artelista.R
import com.example.artelista.model.User

class AdapterUser(private val UserListener: UserListener): RecyclerView.Adapter<AdapterUser.UserViewHolder>() {

    private var listUser = ArrayList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_usuario, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user: User = listUser[position]
        holder.tvNombreUsuario.text = user.nombreUsuario
        holder.tvCategoriaUsuario.text = user.categoriaUsuario
        holder.tvPaisUsuario.text = user.paisUsuario
        holder.itemView.setOnClickListener {
            UserListener.onUserClicked(user, position)
        }
    }
    //-----------
    override fun getItemCount(): Int {
        return listUser.size
    }

    fun updateData(data:List<User>?){
        listUser.clear()
        listUser.addAll(data!!)
        notifyDataSetChanged()
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