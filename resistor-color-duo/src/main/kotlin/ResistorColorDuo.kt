object ResistorColorDuo {

    fun value(vararg colors: Color): Int {
        return colors.slice(0..1).joinToString(separator = "") { color -> color.ordinal.toString() }.toInt()
    }
}
