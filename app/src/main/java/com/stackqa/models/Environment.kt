package com.stackqa.models

import java.io.Serializable

class Environment (

    val environment: String,
    val title: String,
    val description: String

): Serializable

{
    override fun toString(): String {
        return "[Environment: ${this.environment} [title: ${this.title} [description: ${this.description}]]]"
    }
}