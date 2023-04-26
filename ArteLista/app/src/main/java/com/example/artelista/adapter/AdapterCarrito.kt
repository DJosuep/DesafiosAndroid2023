package com.example.artelista.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.artelista.R
import com.example.artelista.model.Carrito
import com.squareup.picasso.Picasso

class AdapterCarrito(Carritos: ArrayList<Carrito>, resource:Int, activity:Activity): RecyclerView.Adapter<AdapterCarrito.CarritoViewHolder>() {
    private val carritos:ArrayList<Carrito>
    private val resource:Int
    private val activity:Activity

    init {
        this.carritos = Carritos
        this.resource = resource
        this.activity = activity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarritoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(resource, parent, false)
        return CarritoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarritoViewHolder, position: Int) {
        val carrito:Carrito = carritos[position]
        holder.tvVendedorArticulo.text = carrito.getVendedorCarrito()
        holder.tvPrecioArticulo.text = carrito.getPrecioCarrito()
        holder.tvTituloArticulo.text = carrito.getTituloCarrito()
        Picasso.get().load(carrito.getImagenCarrito()).into(holder.imgCompras)
        /*holder.itemView.setOnClickListener{
            Navigation.findNavController(holder.itemView).navigate(
                R.id.fragment_carritodet
            )
        }*/
    }

    override fun getItemCount(): Int {
        return carritos.size
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