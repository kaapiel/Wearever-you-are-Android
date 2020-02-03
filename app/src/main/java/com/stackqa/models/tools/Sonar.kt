package com.stackqa.models.tools

import java.io.Serializable

class Sonar (

    var component: String,
    var coverage: Double,
    var duplications: Double,
    var codeSmells: Int,
    var codeSmellRating: Int,
    var vulnerabilities: Int,
    var vulnerabilitiesRating: Int,
    var bugs: Int,
    var bugsRating: Int,
    var alertStatus: Boolean


): Serializable
{
    override fun toString(): String {
        return "[Sonar: " +
                "[component: ${this.component}] " +
                "[coverage: ${this.coverage}%] " +
                "[duplications: ${this.duplications}%] " +
                "[code smells: ${this.codeSmells} and ${this.codeSmellRating} rating]" +
                "[vulnerabilities: ${this.vulnerabilities} and ${this.vulnerabilitiesRating} rating]" +
                "[bugs: ${this.bugs} and ${this.bugsRating} rating]" +
                "[alertStatus: ${this.alertStatus}]"
    }
}