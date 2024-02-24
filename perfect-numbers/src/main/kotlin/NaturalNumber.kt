enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(n: Int): Classification {

    require(n > 0)

    val sum = (1 until n).filter { n % it == 0 }.sum()

    return when {
        sum < n -> Classification.DEFICIENT
        sum > n -> Classification.ABUNDANT
        else -> Classification.PERFECT
    }
}
