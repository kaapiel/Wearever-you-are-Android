package com.stackqa.management

import android.content.Context
import android.graphics.Color
import android.util.Log
import com.stackqa.models.tools.*
import java.io.InputStream
import kotlin.random.Random

class Utils {

    val TAG: String = "Utils"

    fun readJson(context: Context, raw_id: Int): String {
        val inputStream: InputStream = context.resources.openRawResource(raw_id)
        val textFromFile = inputStream.bufferedReader().use{it.readText()}
        Log.d(TAG, textFromFile)
        return textFromFile
    }

    fun generateStubTools(): Tools {

        val passed = Random.nextDouble(0.0, 100.0)
        val failed = 100-passed

        return Tools(
            Sonar("Project X",
            Random.nextDouble(60.0, 100.0),
            Random.nextDouble(0.0, 4.0),
            Random.nextInt(0, 30),
            Random.nextInt(1, 5),
            Random.nextInt(0, 20),
            Random.nextInt(1, 5),
            Random.nextInt(0, 20),
            Random.nextInt(1, 5),
            Random.nextBoolean()
        ),
            Jenkins(
                Random.nextDouble(60.0, 100.0),
                Random.nextDouble(0.0, 4.0),
                Random.nextInt(0, 30),
                Random.nextInt(0, 20),
                Random.nextInt(0, 20)
            ),
            Jira(
                Random.nextInt(0, 15),
                Random.nextInt(0, 40),
                Execution(
                    Random.nextInt(1, 100),
                    if (Random.nextBoolean()) { "PASSED" } else { "FAILED" },
                    passed,
                    failed
                    )
            ),
            Splunk(
                Random.nextDouble(60.0, 100.0),
                Random.nextDouble(0.0, 4.0),
                Random.nextInt(0, 30),
                Random.nextInt(0, 20),
                Random.nextInt(0, 20)
            ),
            SDM(
                Random.nextDouble(60.0, 100.0),
                Random.nextDouble(0.0, 4.0),
                Random.nextInt(0, 30),
                Random.nextInt(0, 20),
                Random.nextInt(0, 20)

            ),
            Graphana(
                Random.nextDouble(60.0, 100.0),
                Random.nextDouble(0.0, 4.0),
                Random.nextInt(0, 30),
                Random.nextInt(0, 20),
                Random.nextInt(0, 20)
            ))
    }

    val okNokColors = intArrayOf(
        Color.rgb(51, 255, 0),
        Color.rgb(255, 0, 0)
    )

    val nokOkColors = intArrayOf(
        Color.rgb(255, 0, 0),
        Color.rgb(51, 255, 0)
    )

    val sonarRatingColors = intArrayOf(
        Color.rgb(0, 185, 0),   //A
        Color.rgb(146, 226, 0), //B
        Color.rgb(248, 193, 0), //C
        Color.rgb(250, 109, 0), //D
        Color.rgb(249, 0, 27)   //E

    )

}