import java.util.*

fun <T : Comparable<T>> quicksort(items: List<T>): List<T> {
    if (items.count() < 2) {
        return items
    }
    val pivot = items[items.count() / 2]
    val equal = items.filter { it == pivot }
    val less = items.filter { it < pivot }
    val greater = items.filter { it > pivot }

    return quicksort(less) + equal + quicksort(greater)
}

fun <T : Comparable<T>> binarySearch(list: List<T>, key: T): Int? {
    var rangeStart = 0
    var rangeEnd = list.count()

    while (rangeStart < rangeEnd) {
        val middleIndex = rangeStart + (rangeEnd - rangeStart) / 2

        if (list[middleIndex] == key) {
            return middleIndex
        } else if (list[middleIndex] < key) {
            rangeStart = middleIndex + 1
        } else {
            rangeEnd = middleIndex
        }
    }
    return null
}

fun <T : Comparable<T>> binarySearchRec(list: List<T>, key: T): Optional<Int> {
    require(list == list.sorted())

    fun helper(start: Int, end: Int): Optional<Int> {

        val mid: Int = start + (end - start) / 2

        if (end < start) return Optional.empty()

        if (key == list[mid]) {
            return Optional.of(mid)
        } else if (key < list[mid]) {
            return helper(start, mid - 1)
        } else {
            return helper(mid + 1, end)
        }
    }

    return helper(0, list.count())
}

fun main(args: Array<String>) {

    println("\\nOrdered list:")

    val names = listOf<String>(
            "Stevie wonder",
            "Alicia Keys",
            "Eric Clapton",
            "Aretha Flanklin",
            "Metallica",
            "Steely Dan",
            "Xcape"
    )

    val nums = listOf<Int>(2, 76, 4, 8, 39, 1, 76, 45, 41, 63, 85, 9, 4, 73, 5, 24, 1, 68, 49, 5, 8, 62, 5)

    println(quicksort(names))
    println(quicksort(nums))

    val searchName = "Metallica"
    val searchNum = 62

    println("\n$searchName is int the positon ${binarySearch(quicksort(names), searchName)} in the ordered List.")
    println("\n$searchName is int the positon ${binarySearchRec(quicksort(names), searchName)} in the ordered List.")
    println("\n$searchNum is int the positon ${binarySearch(quicksort(nums), searchNum)} in the ordered List.")
    println("\n$searchNum is int the positon ${binarySearchRec(quicksort(nums), searchNum)} in the ordered List.")

}