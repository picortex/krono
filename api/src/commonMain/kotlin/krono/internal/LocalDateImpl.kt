package krono.internal

import krono.utils.DayOfWeek
import krono.LocalDate
import krono.Month
import krono.utils.DayOfYear
import krono.utils.DaysOfMonth

internal data class LocalDateImpl(
    override val year: Int, override val monthNumber: Int, override val dayOfMonth: Int
) : AbstractDateLike(), LocalDate {

    override val month: Month = Month.values().firstOrNull {
        it.number == monthNumber
    } ?: throw IllegalArgumentException("Can't get month of $monthNumber")

    override val dayOfWeek = DayOfWeek(year, monthNumber, dayOfMonth)

    override val dayOfYear = DayOfYear(year, monthNumber, dayOfMonth)

    override fun atEndOfMonth(): LocalDate = atDate(DaysOfMonth(year, monthNumber))

    override fun atDate(date: Int): LocalDate = LocalDateImpl(year, monthNumber, date)

    override fun compareTo(other: LocalDate): Int = dayOfYear.compareTo(other.dayOfYear)

    override fun isBefore(other: LocalDate): Boolean = this < other

    override fun isAfter(other: LocalDate): Boolean = this > other

    override fun toString() = toIsoString()
}