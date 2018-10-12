/**
 * Created by Tsutou
 */

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

fun main(args: Array<String>) {
    println("\nOriginal list:")

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

    println(names)
    println(nums)

    println("\nOrdered list:")

    println(quicksort(names))
    println(quicksort(nums))
}
