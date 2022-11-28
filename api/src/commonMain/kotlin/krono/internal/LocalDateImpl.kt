package krono.internal

import krono.DayOfWeek
import krono.LocalDate
import krono.Month

internal class LocalDateImpl(
    override val year: Int,
    override val monthNumber: Int,
    override val dayOfMonth: Int
) : AbstractLocalDate() {

    override val month: Month = Month.values().first { it.number == monthNumber }
    override val dayOfWeek: DayOfWeek get() = TODO()
    override val dayOfYear: Int get() = TODO()

    override fun compareTo(other: LocalDate): Int {
        TODO("Not yet implemented")
    }
}