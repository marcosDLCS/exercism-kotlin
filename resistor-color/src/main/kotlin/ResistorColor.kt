object ResistorColor {

    fun colorCode(input: String): Int {
        return Color.valueOf(input.uppercase()).value
    }

    fun colors(): List<String> {
        return Color.values().map { c -> c.name.lowercase() }
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

}
