object RunLengthEncodingLong {

    private val regex: Regex = "(?<count>\\d+)?(?<letter>[A-Za-z ])".toRegex()

    fun encode(input: String): String {

        if (input.isBlank()) return ""

        val letters = input.toCharArray()

        val groups: MutableList<Group> = mutableListOf()
        var groupItem: Group? = null

        letters.forEachIndexed { idx, item ->

            if (groupItem == null) {
                groupItem = Group(item)
            }

            if (idx + 1 < letters.size && item == letters[idx + 1]) {
                groupItem = groupItem?.increase()
            } else {
                groupItem?.let { groups.add(it) }
                groupItem = null
            }
        }

        return groups.joinToString("") { "${if (it.count > 1) it.count.toString() else ""}${it.letter}" }
    }

    fun decode(input: String): String {

        if (input.isBlank()) return ""

        val groups: MutableList<Group?> = regex.findAll(input)
            .map { m ->
                if (m.groups["count"] == null)
                    m.groups["letter"]?.let { l -> Group(l.value.single()) }
                else
                    m.groups["count"]?.let { c -> m.groups["letter"]?.let { l ->
                        Group(l.value.single(), c.value.toInt())
                    }}
            }.toMutableList()

        return groups.joinToString("") { m -> "${m?.let { m.letter.toString().repeat(it.count) }}" }
    }
}

data class Group(val letter: Char, val count: Int = 1) {

    fun increase(): Group = copy(count = count + 1)
}
