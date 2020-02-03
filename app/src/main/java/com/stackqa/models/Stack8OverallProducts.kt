package com.stackqa.models

import java.io.Serializable

class Stack8OverallProducts (

    val description: String,
    val products: List<Product>

): Serializable

{
    override fun toString(): String {
        return "Stack8OverallProducts: [Description: ${this.description} [products: ${this.products}]"
    }
}