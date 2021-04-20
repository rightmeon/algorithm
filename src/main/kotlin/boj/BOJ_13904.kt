package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class BOJ_13904 {
    fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
        BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
            val arr = Array(readLine().toInt()){ IntArray(2) }
            val intArr = IntArray(1001){0}
            for(i in arr.indices) {
                arr[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
            }

            arr.sortByDescending { it[1] }

            arr.forEach {
                if(intArr[it[0]] == 0) {
                    intArr[it[0]] = it[1]
                } else {
                    for(i in it[0] -1 downTo 1) {
                        if(intArr[i] == 0) {
                            intArr[i] = it[1]
                            break
                        }
                    }
                }
            }
            writer.write("${intArr.sum()}")
            writer.flush()
        }
    }
}