package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/*

 url = https://www.acmicpc.net/problem/13305
 solved by 2021.03.30

 */

class BOJ_13305 {
    fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
        BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
            readLine()
            val roadLengths = readLine().split(" ").map { it.toLong() }
            val gasPrices = readLine().split(" ").map { it.toLong() }
            var minPrice = gasPrices.first()
            var answer = minPrice * roadLengths.first()

            for(i in 1..gasPrices.size-2) {
                if(gasPrices[i] < minPrice) {
                    minPrice = gasPrices[i]
                }
                answer += (minPrice * roadLengths[i])
            }

            writer.write("$answer")
            writer.flush()
        }
    }
}