package com.example.ktolin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fun getSignReceiptData() {
            suspend fun main() = coroutineScope {
                launch {
                    println("Kotlin Coroutines World!")
                }
                println("Hello")
            }
        }

    }
}
fun main() {
    test()
    GlobalScope.launch { // 在后台启动一个新的协程并继续
        delay(1000L)
        println("World!")
    }
    println("Hello,") // 主线程中的代码会立即执行
    runBlocking {
        println("runBlockingrunBlocking!")// 但是这个表达式阻塞了主线程
        delay(50000L)  // ……我们延迟 2 秒来保证 JVM 的存活
    } // 阻塞主线程 2 秒钟来保证 JVM 存活

    GlobalScope.launch {
        val token = getToken()
        val userInfo = getUserInfo(token)
        setUserInfo(userInfo)
    }
    repeat(8){
        println("World!-------\"主线程执行$it\"")
    }
}
private fun test() = runBlocking {
    repeat(8) {println("Worsssssssssld!")

        delay(1000)
    }
}

private fun setUserInfo(userInfo: String) {
    println("World!-----${userInfo}")
}

private suspend fun getToken(): String {
    delay(2000)
    return "token"
}

private suspend fun getUserInfo(token: String): String {
    delay(2000)
    return "$token - userInfo"
}