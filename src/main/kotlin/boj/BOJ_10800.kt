package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/*

    url = https://www.acmicpc.net/problem/10800
    solved by 2021.04.22

*/

class BOJ_10800 {
    fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
        BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
            val ballCount = readLine().toInt()
            val balls = Array(ballCount){ IntArray(2) }
            val answerMap = mutableMapOf<String, Int>()
            val weights = IntArray(2001)
            val colors = IntArray(200001)
            var weightSum = 0


            for(i in balls.indices) {
                balls[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
            }

            for(ball in balls.sortedBy { it[1] }) {
                if(answerMap.getOrDefault("${ball[0]},${ball[1]}", -1) == -1){
                    answerMap["${ball[0]},${ball[1]}"] =
                        if(weightSum - colors[ball[0]] - weights[ball[1]] < 0) 0
                        else weightSum - colors[ball[0]] - weights[ball[1]]
                }
                colors[ball[0]] += ball[1]
                weights[ball[1]] += ball[1]
                weightSum += ball[1]
            }

            for(i in balls){
                writer.write("${answerMap["${i[0]},${i[1]}"]}\n")
            }

            writer.flush()
        }
    }
}