import java.util.*
import kotlin.math.sqrt

object CryptoSquare {

    fun ciphertext(plaintext: String): String {

        // Test 01: empty plaintext results in empty ciphertext
        if (plaintext.isEmpty()) return ""

        // Test 02: letters are lower cased during encryption
        // Test 03: spaces are removed during encryption
        // Test 04: punctuation is removed during encryption
        val normalizedText = plaintext.normalize()

        return normalizedText
    }

    private fun String.normalize(): String {
        return this
            .lowercase(Locale.getDefault())
            .replace(Regex("[\\s\\p{P}]"), "")
    }
}
