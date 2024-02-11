class CustomSet(vararg values: Int) {

    private var mySet: Set<Int> = values.toSet()

    fun isEmpty() = mySet.isEmpty()

    fun isSubset(other: CustomSet) = mySet.isEmpty() || other.mySet.containsAll(mySet)

    fun isDisjoint(other: CustomSet) = mySet.all { it !in other.mySet }

    fun contains(value: Int) = value in mySet

    fun intersection(other: CustomSet) = CustomSet(*mySet.intersect(other.mySet).toIntArray())

    fun add(value: Int) {
        mySet += value
    }

    override fun equals(other: Any?) =
        other is CustomSet && mySet.size == other.mySet.size && mySet.containsAll(other.mySet)

    operator fun plus(other: CustomSet) = CustomSet(*other.mySet.toIntArray(), *mySet.toIntArray())

    operator fun minus(other: CustomSet) = CustomSet(*mySet.minus(other.mySet).toIntArray())

    override fun hashCode() = mySet.hashCode()
}
