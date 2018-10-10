import java.util.*

fun main(args: Array<String>) {

    val scanner = Scanner(System.`in`)

    val a = scanner.nextInt()
    val b = scanner.nextInt()

    scanner.close()

    println(String.format("gcd(%d, %d) = %d%n", a, b, gcd(a, b)))

}

fun gcd(a: Int,b:Int): Int{
    if (a < b) return gcd(b, a)
    if (b == 0) return a
    return gcd(b, a % b)
}