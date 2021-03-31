package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/*

 url = https://www.acmicpc.net/problem/1946
 solved by 2021.03.31

 */

class BOJ_1946 {
    fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
        BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
            for(i in 1..readLine().toInt()) {
                val gradeRanks = Array(readLine().toInt()){ IntArray(2) }

                for(j in gradeRanks.indices) {
                    gradeRanks[j] = readLine().split(" ").map { it.toInt() }.toIntArray()
                }

                gradeRanks.sortBy { it[0] }
                var flag = gradeRanks[0][1]
                var answer = 1

                for(i in 1 until gradeRanks.size) {
                    if(flag > gradeRanks[i][1]) {
                        answer++
                        flag = gradeRanks[i][1]
                    }
                }
                writer.write("$answer\n")
            }
            writer.flush()
        }
    }
}