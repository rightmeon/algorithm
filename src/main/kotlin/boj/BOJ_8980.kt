package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/*

 url = https://www.acmicpc.net/problem/8980
 solved by 2021.04.20

 */

class BOJ_8980 {
    fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
        BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
            val (n, t) = readLine().split(" ").map { it.toInt() }
            val array = Array(readLine().toInt()) { IntArray(3) }
            val city = IntArray(n + 1) { t }
            var answer = 0

            for (i in array.indices) {
                array[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
            }
            array.sortWith(compareBy({ it[1] }, { it[0] }))

            for(i in array.indices) {
                val min = city.sliceArray(array[i][0] until array[i][1]).minOrNull()
                if(min!! > 0) {
                    if(min > array[i][2]) {
                        for(j in array[i][0] until array[i][1]) {
                            city[j] -= array[i][2]
                        }
                        answer += array[i][2]
                    } else {
                        for(j in array[i][0] until array[i][1]) {
                            city[j] -= min
                        }
                        answer += min
                    }
                }
            }

            writer.write("$answer")
            writer.flush()
        }
    }
}