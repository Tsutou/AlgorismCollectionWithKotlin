import java.util.*

/**
 * リストをスタックに変換
 * @param list リスト
 * @return スタック
 */

fun listToStack(list: List<Int>): Stack<Int> {

    val stack = Stack<Int>()

    for (e in list) {
        stack.push(e)
    }

    return stack
}

/**
 * ユークリッドの互除法を用いて、最大公約数を導出する
 * @param list 最大公約数を求める対象となる数が格納されたリスト
 * @return 最大公約数
 */

fun gcd(list: List<Int>): Int {
    // 最大公約数を求める対象となる数が格納されたスタック
    val stack = listToStack(list)

    // ユークリッドの互除法を用いて、最大公約数を導出する
    // (最終的にスタック内に1つだけ数が残り、それが最大公約数となる)
    while (1 < stack.size) {
        //スタックから2つの数をポップ
        val pops = (0 until 2).map {
            stack.pop()
        }


        val minIndex = if (pops[1] < pops[0]) {
            1
        } else {
            0
        }

        //スタックからpopした２つの数のうち、小さい方をプッシュ
        stack.push(pops[minIndex])

        // スタックからpopした2つの数の剰余
        val r = pops[(minIndex + 1) % 2] % pops[minIndex]

        if (0 < r) {
            stack.push(r)
        }
    }

    return stack.pop()
}

fun main(args: Array<String>) {

    // 座標Xと座標x_iの距離が格納されるリスト
    val xx = mutableListOf<Int>()

    Scanner(System.`in`).use {
        val n = it.nextInt()
        val x = it.nextInt()
        for (i in 0 until n) {
            val xxI = it.nextInt()
            if (xxI < x) {
                xx.add(x - xxI)
            } else {
                xx.add(xxI - x)
            }
        }
    }

    println(gcd(xx))
}