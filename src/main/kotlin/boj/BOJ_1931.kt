package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs

/*

 url = https://www.acmicpc.net/problem/1931
 solved by 2021.03.24

 */

class BOJ_1931 {
    fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
        BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
            val count = readLine().toInt()
            val times = Array(count) { IntArray(2) }

            for(i in times.indices) {
                times[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
            }
            times.sortWith(compareBy({ abs((it[0] - it[1])) + it[0]}, {it[0]}))

            var end = times[0][1]
            var utilization = 1
            for(i in 1 until times.size) {
                if(times[i][0] >= end) {
                    utilization++
                    end = times[i][1]
                }
            }
            writer.write("$utilization")
            writer.flush()
        }
    }
}