package krono.internal

import krono.DayOfWeek
import krono.LocalDate
import krono.Month
import krono.utils.DaysOfMonth
import kotlinx.datetime.LocalDate as KxLocalDateTime

internal class LocalDateKx(private val wrapped: KxLocalDateTime) : AbstractDateLike(), LocalDate {
    override val year: Int get() = wrapped.year
    override val monthNumber: Int get() = wrapped.monthNumber
    override val month: Month get() = Month.valueOf(wrapped.month.name)
    override val dayOfMonth: Int get() = wrapped.dayOfMonth
    override val dayOfWeek: DayOfWeek get() = DayOfWeek.valueOf(wrapped.dayOfWeek.name)
    override val dayOfYear: Int get() = wrapped.dayOfYear

    override fun compareTo(other: LocalDate): Int = wrapped.compareTo(KxLocalDateTime(other.year, other.monthNumber, other.dayOfMonth))

    override fun atDate(date: Int) = LocalDateKx(KxLocalDateTime(year, monthNumber, date))

    override fun atEndOfMonth() = atDate(DaysOfMonth(year, monthNumber))
}