import java.util.*
import kotlin.math.ceil
import kotlin.math.sqrt

object CryptoSquare {

    private const val EMPTY = ""

    fun ciphertext(plaintext: String): String {

        if (plaintext.isEmpty()) return EMPTY

        val normalizedText = plaintext.normalize()

        val c = ceil(sqrt(normalizedText.length.toDouble())).toInt()

        return normalizedText.chunked(c)
            .let { list -> (0 until c).joinToString(" ") { idx -> list.map { it.getOrNull(idx) ?: ' ' }.joinToString(EMPTY) }
        }
    }

    private fun String.normalize(): String {
        return this.lowercase(Locale.getDefault()).replace(Regex("[\\s\\p{P}]"), EMPTY)
    }
}
