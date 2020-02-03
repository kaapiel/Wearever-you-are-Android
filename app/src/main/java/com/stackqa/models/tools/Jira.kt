package com.stackqa.models.tools

import java.io.Serializable

class Jira (

    var bugs: Int,
    var improvements: Int,
    var execution: Execution

): Serializable
{
    override fun toString(): String {
        return "[Jira: " +
                "[bugs: ${this.bugs}%] " +
                "[improvements: ${this.improvements}%] " +
                "[execution: ${this.execution}]"
    }
}