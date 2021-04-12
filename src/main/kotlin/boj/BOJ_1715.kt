package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/*

    url = https://www.acmicpc.net/problem/1715
    solved by 2021.04.12

*/

class BOJ_1715 {
    fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
        BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
            val pq = PriorityQueue<Long>()
            var answer : Long = 0
            for(i in 1..readLine().toInt()) {
                pq.offer(readLine().toLong())
            }

            while(pq.size >= 2){
                val pivot = pq.poll() + pq.poll()
                answer += pivot
                pq.offer(pivot)
            }

            writer.write("${answer}")
            writer.flush()
        }
    }
}