object ResistorColorDuo {

    fun value(vararg colors: Color): Int {
        return colors.slice(0..1).joinToString(separator = "") { color -> color.value.toString() }.toInt()
    }
}

enum class Color(val value: Int) {
    BLACK(0),
    BROWN(1),
    RED(2),
    ORANGE(3),
    YELLOW(4),
    GREEN(5),
    BLUE(6),
    VIOLET(7),
    GREY(8),
    WHITE(9),
}
