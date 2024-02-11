import kotlin.math.log10
import kotlin.math.pow

object ResistorColorTrio {

    fun text(vararg colors: Color): String {

        val inputValue = colors.take(2).joinToString("") { it.ordinal.toString() }.toInt()
        val addedZeros = colors[2].ordinal
        val resistorValue = inputValue * 10.0.pow(addedZeros)
        val unit = Unit.values()[log10(resistorValue).toInt().div(3)]

        return "${(resistorValue / 1000.0.pow(unit.ordinal)).toInt()} ${unit.name.lowercase()}"
    }

}
