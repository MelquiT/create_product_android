package com.example.t2_tapiadavila

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.t2_tapiadavila.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding

    private lateinit var mAdapter: ProductoAdapter

    private lateinit var mGridLayout: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            val product = Producto(

                descripcion = binding.edDescription.editText?.text.toString(),
                precioVenta = binding.edPrecVenta.editText?.text.toString().toFloat().toDouble(),
                precioCompra = binding.edPrecCompra.editText?.text.toString().toFloat().toDouble(),
                stock = binding.edStock.editText?.text.toString().toInt())

            mAdapter.add(product)
        }
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        mAdapter = ProductoAdapter(mutableListOf(), this)
        mGridLayout = GridLayoutManager(this, 1)

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = mGridLayout
            adapter = mAdapter
        }
    }

    override fun onClick(producto: Producto) {
        TODO("Not yet implemented")
    }
}