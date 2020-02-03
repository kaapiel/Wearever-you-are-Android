package com.stackqa.models

import java.io.Serializable

class Environments (

    val environments: List<Environment>,
    val sonarServer: String,
    val jenkinsServer: String,
    val jiraServer: String,
    val graphanaServer: String,
    val sdmServer: String,
    val splunkServer: String

): Serializable

{
    override fun toString(): String {
        return "[Environments: ${this.environments} " +
                "[Servers: Sonar ${ this.sonarServer} | Jenkins ${ this.jenkinsServer} | " +
                "Jira ${ this.jiraServer} | Graphana ${ this.graphanaServer} | SDM ${ this.sdmServer} " +
                "| Splunk ${ this.splunkServer}]]"
    }
}