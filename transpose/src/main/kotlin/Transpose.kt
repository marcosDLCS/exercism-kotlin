object Transpose {

    fun transpose(input: List<String>): List<String> {

        if (input.isEmpty()) return emptyList()

        val paddedInput = input.mapIndexed { idx, str -> str.padEnd(input.drop(idx).maxOf { it.length }, ' ') }

        return 0.until(input.maxOf { it.length })
            .map { i -> paddedInput.mapNotNull { it.getOrNull(i) }.joinToString("") }
    }

    // Kudos to xandeer's solution
}
