package com.stackqa.models.tools

import java.io.Serializable

class Tools (

    var sonar: Sonar,
    var jenkins: Jenkins,
    var jira: Jira,
    var splunk: Splunk,
    var sdm: SDM,
    var graphana: Graphana


): Serializable
{
    override fun toString(): String {
        return "[Tools: [Sonar: ${this.sonar}] " +
                "[Jenkins: ${this.jenkins}] " +
                "[Jira: ${this.jira}] " +
                "[Splunk: ${this.splunk}] " +
                "[SDM: ${this.sdm}] " +
                "[Graphana: ${this.graphana}]"
    }
}