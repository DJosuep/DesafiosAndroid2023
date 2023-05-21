package com.example.artelista.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.artelista.R
import com.example.artelista.model.Carrito
import com.squareup.picasso.Picasso

class AdapterCarrito(private val CarritoListener: CarritoListener): RecyclerView.Adapter<AdapterCarrito.CarritoViewHolder>() {

    var listCarrito = ArrayList<Carrito>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarritoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_carrito, parent, false)
        return CarritoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarritoViewHolder, position:Int){
        val carrito:Carrito = listCarrito[position]
        holder.tvVendedorArticulo.text = carrito.artistaCarrito
        holder.tvPrecioArticulo.text = carrito.precioCarrito
        holder.tvTituloArticulo.text = carrito.tituloCarrito
        Picasso.get().load(carrito.imagenCarrito).into(holder.imgCompras)
        holder.itemView.setOnClickListener{
            CarritoListener.onCarritoClicked(carrito, position)
        }
    }

    override fun getItemCount(): Int {
        return listCarrito.size
    }

    fun updateData(data:List<Carrito>?){
        listCarrito.clear()
        listCarrito.addAll(data!!)
        notifyDataSetChanged()
    }


    inner class CarritoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val tvVendedorArticulo: TextView
        val tvPrecioArticulo: TextView
        val tvTituloArticulo: TextView
        val imgCompras: ImageView

        init {
            tvVendedorArticulo = itemView.findViewById<View>(R.id.tvVendedorArticulo) as TextView
            tvPrecioArticulo = itemView.findViewById<View>(R.id.tvPrecioArticulo) as TextView
            tvTituloArticulo = itemView.findViewById<View>(R.id.tvTituloArticulo) as TextView
            imgCompras = itemView.findViewById<View>(R.id.imgCompras) as ImageView
        }
    }
}