package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.ArrayDeque

/*

    url = https://www.acmicpc.net/problem/1744
    solved by 2021.04.12

*/

class BOJ_1744 {
    fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
        BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
            val dq = ArrayDeque<Int>()
            val array = IntArray(readLine().toInt())
            var answer = 0
            for (i in array.indices) {
                array[i] = readLine().toInt()
            }
            dq.addAll(array.sorted())

            while (dq.peekFirst() < 0 && dq.size >= 2) {
                val pibot = dq.pop()
                answer +=
                    when {
                        dq.peekFirst() > 0 -> pibot
                        dq.peekFirst() == 0 -> (pibot * dq.pop())
                        else -> (pibot * dq.pop())
                    }
            }

            while(dq.size >=2) {
                val pivot = dq.pollLast()
                answer +=
                    when{
                        pivot <= 1 -> pivot
                        dq.peekLast() <= 1 -> pivot
                        else -> pivot * dq.pollLast()
                    }
            }

            writer.write("${answer + if(dq.isEmpty()) 0 else dq.pop()}")
            writer.flush()
        }
    }
}