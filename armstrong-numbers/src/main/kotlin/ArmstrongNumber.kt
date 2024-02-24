import kotlin.math.pow

object ArmstrongNumber {

    fun check(input: Int): Boolean {

        val str = input.toString()

        if (str.length <= 1) return true

        return str.map { it.toString().toDouble().pow(str.length) }.sum().toInt() == input
    }
}
