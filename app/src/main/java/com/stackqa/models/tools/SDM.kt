package com.stackqa.models.tools

import java.io.Serializable

class SDM (

    var coverage: Double,
    var duplications: Double,
    var codeSmells: Int,
    var vulnerabilities: Int,
    var bugs: Int


): Serializable
{
    override fun toString(): String {
        return "[Sonar: [coverage: ${this.coverage}%] " +
                "[duplications: ${this.duplications}%] " +
                "[code smells: ${this.codeSmells}] " +
                "[vulnerabilities: ${this.vulnerabilities}] " +
                "[bugs: ${this.bugs}]"
    }
}