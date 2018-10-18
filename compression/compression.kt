package compression

tailrec fun runLengthEncoding(text: String, prev: String = ""): String {
    if (text.length == 0) {
        return prev
    }

    val initialChar = text.get(0)
    val count = text.takeWhile { it == initialChar }.count()
    return runLengthEncoding(text.substring(count), prev + "$count$initialChar")
}