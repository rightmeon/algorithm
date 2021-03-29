package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/*

 url = https://www.acmicpc.net/problem/11047
 solved by 2021.03.24

 */

class BOJ_11047 {

    fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
        BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
            var (unitCount, money) = readLine().split(" ").map { it.toInt() }
            val units = IntArray(unitCount)
            var answer = 0

            for(i in units.indices) {
                units[i] = readLine().toInt()
            }

            for(i in units.reversed()) {
                answer += money / i
                money -= (money / i) * i
                if(money == 0) break
            }

            writer.write("$answer")
            writer.flush()
        }
    }
}