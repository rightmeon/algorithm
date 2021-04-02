package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/*

    url = https://www.acmicpc.net/problem/1339
    solved by 2021.03.29

*/

class BOJ_1339 {
    fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
        BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
            val unit = arrayOf(1,10,100,1000,10000,100000,1000000,10000000)
            val alphabets = mutableMapOf<Char, Int>()
            var num = 9
            var answer = 0
            for(i in 1..readLine().toInt()) {
                for((index, value) in readLine().reversed().withIndex()) {
                    alphabets[value] = alphabets.getOrDefault(value, 0) + unit[index]
                }
            }

            alphabets.toList().sortedByDescending { it.second }.forEach {
                answer += it.second * num
                num--
            }

            writer.write("$answer")
            writer.flush()
        }
    }
}