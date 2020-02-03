package com.stackqa.models.tools

import java.io.Serializable

class Execution (

    val scenarios: Int,
    val executionStatus: String,
    val passed: Double,
    val failed: Double

): Serializable {

    override fun toString(): String {
        return "[Execution: " +
                "[cenarious: ${this.scenarios}] " +
                "[executionStatus: ${this.executionStatus}] " +
                "[passed: ${this.passed}] " +
                "[failed: ${this.failed}]"
    }
}