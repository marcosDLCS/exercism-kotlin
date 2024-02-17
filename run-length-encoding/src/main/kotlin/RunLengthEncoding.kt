object RunLengthEncoding {

    // KUDOS: Amazing "Perkel's solution" in Exercism. Superb! (I need more practice with regex...)

    fun encode(input: String) =
        input.replace("""(.)\1+""".toRegex()) { it.value.length.toString() + it.groupValues[1] }


    fun decode(input: String) =
        input.replace("""(\d+)(.)""".toRegex()) { it.groupValues[2].repeat(it.groupValues[1].toInt()) }
}
