package com.szy.kotlindemo.test

fun main() {
//    getListByMaxItem()
    printNamesLength()
}

fun getListByMaxItem() {
    val data = listOf("茶市场价安徽省出超级卡死", "2121212121", "casjncasncask", "231212", "cbhjascj")
    val message = data.maxBy { it.length }
    print(message)
    print("\n${message}的长度：${message?.lastLength()}")
}

fun String.lastLength(): Int {
    return if (this.isEmpty())
        0
    else
        this.length
}

fun printNamesLength() {
    val name1 = "activity"
    val name2 = "service"
    name1Andname2Length(name1, name2) { a, b ->
       "$a$b"
    }
    name1Andname2Length(name1, name2) { a, b ->
        val message="内联函数方法是否能执行"
        if(message.length>10){
            print("内联函数执行了\n")
            return
        }

        message
    }
}

inline fun name1Andname2Length(
    name1: String,
    name2: String,
    length: (a: String, b: String) -> String
) {
    val message = length(name1, name2)
    print("$name1 和$name2 两个字符串的组合之后是：$message 总和长度是：${message.length}\n")

}