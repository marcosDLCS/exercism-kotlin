fun translate(rna: String?): List<String> {
    if (rna == null) return emptyList()

    val codons = rna.chunked(3).map {
        when (it) {
            "AUG" -> "Methionine"
            "UUU", "UUC" -> "Phenylalanine"
            "UUA", "UUG" -> "Leucine"
            "UCU", "UCC", "UCA", "UCG" -> "Serine"
            "UAU", "UAC" -> "Tyrosine"
            "UGU", "UGC" -> "Cysteine"
            "UGG" -> "Tryptophan"
            "UAA", "UAG", "UGA" -> "STOP"
            else -> "INVALID"
        }
    }.takeWhile { item -> item != "STOP" }

    require(!(codons.contains("INVALID"))) { "Invalid codon" }

    return codons
}
