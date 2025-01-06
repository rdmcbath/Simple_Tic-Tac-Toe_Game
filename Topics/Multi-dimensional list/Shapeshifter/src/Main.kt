fun main() {
    // Do not touch code below
    val inputList: MutableList<MutableList<String>> = mutableListOf()
    val n = readLine()!!.toInt()
    for (i in 0 until n) {
        val strings = readLine()!!.split(' ').toMutableList()
        inputList.add(strings)
    }
    // write your code here
    inputList.reverse()
    val firstList = inputList[0]
    val lastList = inputList[inputList.size - 1]

    val mutList2D = mutableListOf(
        firstList,
        lastList
    )
    println(mutList2D)
}