package tictactoe

fun main() {
    val grid = MutableList(3) { MutableList(3) { ' ' } }
    printGrid(grid)

    var currentPlayer = 'X'
    var result = ""
    var gameEnded = false // Ends the game when someone wins or there is a draw.

    /*game loop where the program asks the user to enter the cell coordinates, analyzes the move
    for correctness and shows a grid with the changes if everything is okay.*/
    while (!gameEnded) {
        println("Enter the coordinates: ")
        makeMove(grid, currentPlayer)

        when {
            hasPlayerWon(grid, currentPlayer) -> {
                result = "$currentPlayer wins"
                gameEnded = true
            }
            isGridFull(grid) -> {
                result = "Draw"
                gameEnded = true
            }
            else -> currentPlayer = if (currentPlayer == 'X') 'O' else 'X'
        }
    }

    // Print final result
    println(result)
}

fun printGrid(grid: List<List<Char>>) {
//    Prints an empty grid at the beginning of the game
    println("---------")
    grid.forEach { row ->
        println("| ${row.joinToString(" ")} |")
    }
    println("---------")
}

fun makeMove(grid: MutableList<MutableList<Char>>, player: Char) {
    try {
        val (x, y) = readln().split(" ").map { it.toInt() }

        when {
            x !in 1..3 || y !in 1..3 -> {
                println("Coordinates should be from 1 to 3!")
                makeMove(grid, player)
            }
            grid[x-1][y-1] != ' ' -> {
                println("This cell is occupied! Choose another one!")
                makeMove(grid, player)
            }
            else -> {
                grid[x-1][y-1] = player
                printGrid(grid)
            }
        }
    } catch (e: NumberFormatException) {
        println("You should enter numbers!")
        makeMove(grid, player)
    }
}

fun isGridFull(grid: List<List<Char>>): Boolean =
    grid.all { row -> row.all { it != ' ' } }

fun hasPlayerWon(grid: List<List<Char>>, player: Char): Boolean {
    return hasWinningRow(grid, player) ||
            hasWinningColumn(grid, player) ||
            hasWinningDiagonal(grid, player)
}

fun hasWinningRow(grid: List<List<Char>>, player: Char): Boolean =
    grid.any { row -> row.all { it == player } }

fun hasWinningColumn(grid: List<List<Char>>, player: Char): Boolean =
    (0..2).any { col -> grid.all { row -> row[col] == player } }

fun hasWinningDiagonal(grid: List<List<Char>>, player: Char): Boolean =
    (grid[0][0] == player && grid[1][1] == player && grid[2][2] == player) ||
            (grid[0][2] == player && grid[1][1] == player && grid[2][0] == player)
