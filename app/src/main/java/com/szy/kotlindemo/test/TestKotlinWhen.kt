package com.szy.kotlindemo.test

import com.szy.kotlindemo.entity.Studient

fun main() {
//    print(tag + getMaxUser3(12, 90))
    showUserMessage(Studient("闻静", "女", 4))
    showUserMessage(Studient("王华", "男", 45))
    showUserMessage(Studient("张丽", "女", 81))
    showUserMessage(Studient("李伟", "男", 67))
    showUserMessage(Studient("何静", "女", 100))
    showUserMessage(Studient("何建", "男", 80))
}

private val tag = "" +
        "\n^^^^^^^^^^^^^less code,less bug^^^^^^^^^^^^^^\n" +
        "                   _ooOoo_\n" +
        "                  o8888888o\n" +
        "                  88\" . \"88\n" +
        "                  (| -_- |)\n" +
        "                  O\\  =  /O\n" +
        "               ____/`---'\\____\n" +
        "             .'  \\\\|     |//  `.\n" +
        "            /  \\\\|||  :  |||//  \\\n" +
        "           /  _||||| -:- |||||-  \\\n" +
        "           |   | \\\\\\  -  /// |   |\n" +
        "           | \\_|  ''\\---/''  |   |\n" +
        "           \\  .-\\__  `-`  ___/-. /\n" +
        "         ___`. .'  /--.--\\  `. . __\n" +
        "      .\"\" '<  `.___\\_<|>_/___.'  >'\"\".\n" +
        "     | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |\n" +
        "     \\  \\ `-.   \\_ __\\ /__ _/   .-` /  /\n" +
        "======`-.____`-.___\\_____/___.-`____.-'======\n" +
        "                   `=---='\n" +
        "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" +
        "            佛祖保佑       永无BUG\n" +
        "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n"

fun getMaxUser3(first: Int, send: Int) = if (first > send) first else send
fun showUserMessage(entity: Studient) {
    getUserExcellent(entity)
    getUserExcellent2(entity)
}

fun getUserExcellent(entity: Studient) {
    when {
        entity.achievement in 10..60 -> print("学生：" + entity.name + " 性别：" + entity.age + " 成绩" + entity.achievement + " 偏差\n")
        entity.achievement in 60..80 -> print("学生：" + entity.name + " 性别：" + entity.age + " 成绩" + entity.achievement + " 良好\n")
        entity.achievement in 80..100 -> print("学生：" + entity.name + " 性别：" + entity.age + " 成绩" + entity.achievement + " 优秀\n")
        else -> print("学生：" + entity.name + " 性别：" + entity.age + " 成绩" + entity.achievement + " 牛逼学成这样了还不去混社会上什么学\n")
    }
}

fun getUserExcellent2(entity: Studient) {
    when (entity.age) {
        "男" -> print("学生：" + entity.name + " 这是一个小伙子\n")
        "女" -> print("学生：" + entity.name + " 这是一个小姑娘\n")
    }
}

fun testdemo(studient: Studient) {
    when {
        studient.name == "王华" && studient.achievement > 0 -> getUserExcellent(
            studient
        )
    }
}