package com.example.t2_tapiadavila

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.t2_tapiadavila.databinding.ItemProductoBinding

class ProductoAdapter(private var productos: MutableList<Producto>,
                      private var listener: OnClickListener):
                        RecyclerView.Adapter<ProductoAdapter.ViewHolder>() {

    private lateinit var mContext: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context

        val view = LayoutInflater.from(mContext).inflate(R.layout.item_producto, parent, false)

        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val producto = productos.get(position)

        with(holder) {
            setListener(producto)
            binding.description.text = producto.descripcion
            binding.precioCompra.text = producto.precioCompra.toString()
            binding.precioVenta.text = producto.precioVenta.toString()
            binding.stockActual.text= producto.stock.toString()
        }
    }

    override fun getItemCount(): Int = productos.size

    fun add(producto: Producto) {
        productos.add(producto)
        notifyDataSetChanged()
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Creamos la variable para que reciba de la vista
        val binding = ItemProductoBinding.bind(view)

        fun setListener(producto: Producto) {
            binding.root.setOnClickListener { listener.onClick(producto) }
        }
    }


}