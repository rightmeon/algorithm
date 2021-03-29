package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/*

    url = https://www.acmicpc.net/problem/1541
    solved by 2021.03.29

*/

class BOJ_1541 {
    fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
        BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
            val expression = { params : String ->
                if(params.split("+").size > 1)
                    params.split("+").map { it.toInt() }.sum()
                else
                    params.toInt()
            }

            val list = readLine().split("-")
            var answer = expression(list[0])

            for (i in 1 until list.size) {
                answer -= expression(list[i])
            }

            writer.write("$answer")
            writer.flush()

        }
    }
}