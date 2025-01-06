fun main() {
    val sentence = readln()
    val wordToFind = "the"

    // Convert sentence to lowercase and split into words
    val words = sentence.lowercase().split(" ")

    // Get index of first "the"
    var index = -1
    for ((i, word) in words.withIndex()) {
        if (word.startsWith(wordToFind)) {
            // Calculate character position by counting lengths of previous words plus spaces
            index = words.slice(0 until i).sumOf { it.length } + i
            break
        }
    }

    println(index)

}