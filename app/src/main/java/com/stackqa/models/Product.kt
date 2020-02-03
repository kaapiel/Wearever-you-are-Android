package com.stackqa.models

import java.io.Serializable

data class Product (

    val product: String,
    val title: String,
    val description: String,
    val projects: ArrayList<String>

): Serializable

{
    override fun toString(): String {
        return "Product: ${this.product} [title: ${this.title}, description: ${this.description}, projects: ${this.projects}]"
    }
}