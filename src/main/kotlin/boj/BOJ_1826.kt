package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/*

    url = https://www.acmicpc.net/problem/1826
    solved by 2021.04.22

*/

class BOJ_1826 {
    fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
        BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
            val maxHeap = PriorityQueue(compareBy<IntArray> { it[1] }.reversed())
            val minHeap = PriorityQueue(compareBy<IntArray> { it[0] })
            var answer = 0
            var sum = 0
            var p = 0

            val arr = Array(readLine().toInt()){ IntArray(2) }
            for(i in arr.indices) {
                arr[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
                sum += arr[i][1]
            }
            var (d, o) = readLine().split(" ").map { it.toInt() }

            minHeap.addAll(arr)

            while(p+o < d) {
                while (!minHeap.isEmpty() && minHeap.peek()[0] <= p+o){
                    maxHeap.offer(minHeap.poll())
                }

                if(maxHeap.isEmpty()){
                    answer = -1
                    break
                }

                val info = maxHeap.poll()
                o = o - (info[0] - p) + info[1]
                p = info[0]
                answer++
            }

            writer.write("${answer}")
            writer.flush()
        }
    }
}