fun main() {
    // write your code here
    // Read URL and split to get query parameters
    val url = readln()
    val queryPart = url.substringAfter('?')

    // Split into individual parameters
    val params = queryPart.split('&')
    var password = ""

    // Print each parameter
    for (param in params) {
        val (key, value) = if ('=' in param) {
            param.split('=')
        } else {
            listOf(param, "")
        }

        // Store password if found
        if (key == "pass") {
            password = value
        }

        // Print parameter
        print("$key : ")
        println(value.ifEmpty { "not found" })
    }

    // Print password at end if it exists and isn't empty
    if (password.isNotEmpty()) {
        print("password : $password")
    }
}