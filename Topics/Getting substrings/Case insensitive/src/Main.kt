fun main() {
    // put your code here
    val str1 = readln()
    val str2 = readln()

    println(isSame(str1,str2))
}

fun isSame(str1: String, str2: String): Boolean {
    return str1.let { first ->
        str2.let { second ->
            first.equals(second, ignoreCase = true)
        }
    }
}
