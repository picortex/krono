package krono.internal

import krono.utils.DayOfWeek
import krono.LocalDate
import krono.LocalDateEpoch
import krono.Month
import krono.TimeZone
import krono.utils.DayOfYear
import krono.utils.DaysOfMonth

@PublishedApi
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

    override fun compareTo(other: LocalDate): Int = (year * 365 + dayOfYear).compareTo((other.year * 365) + other.dayOfYear)

    override fun isBefore(other: LocalDate): Boolean = this < other

    override fun isAfter(other: LocalDate): Boolean = this > other

    private fun diffSeconds(other: LocalDate): Long = compareTo(other).toLong() * 86400

    override fun toEpochMillisAsLong(): Long = diffSeconds(LocalDateEpoch()) * 1000

    override fun toEpochMillisAsDouble(): Double = toEpochMillisAsLong().toDouble()

    override fun toEpochMillisAsInt(): Int = toEpochMillisAsInt()

    override fun toString() = toIsoString()
}