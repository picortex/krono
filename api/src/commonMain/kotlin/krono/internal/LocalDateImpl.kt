package krono.internal

import krono.utils.DayOfWeek
import krono.LocalDate
import krono.Month
import krono.utils.DayOfYear

internal class LocalDateImpl(
    override val year: Int,
    override val monthNumber: Int,
    override val dayOfMonth: Int
) : AbstractLocalDate() {

    override val month: Month = Month.values().firstOrNull {
        it.number == monthNumber
    } ?: throw IllegalArgumentException("Can't get month of $monthNumber")

    override val dayOfWeek = DayOfWeek(year, monthNumber, dayOfMonth)

    override val dayOfYear = DayOfYear(year, monthNumber, dayOfMonth)

    override fun atDate(date: Int): LocalDate = LocalDateImpl(year, monthNumber, date)

    override fun isBefore(other: LocalDate): Boolean {
        TODO("Not yet implemented")
    }

    override fun isAfter(other: LocalDate): Boolean {
        TODO("Not yet implemented")
    }
}