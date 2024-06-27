package com.example.t2_tapiadavila

import java.math.BigDecimal
import java.text.DecimalFormat

data class Producto(
                    var descripcion: String = "",
                    var precioVenta: Double = 0.0,
                    var precioCompra: Double = 0.0,
                    var stock: Int = 0,
                    var isHourGlass: Boolean = false)
