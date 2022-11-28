package krono.internal

import krono.DateLike
import krono.DayOfWeek
import krono.LocalDate
import krono.LocalDateTime
import krono.LocalTime
import krono.Month
import krono.TimeLike
import krono.utils.DaysOfMonth

class LocalDateTimeImpl(
    override val date: LocalDate,
    override val time: LocalTime
) : AbstractDateLike(),
    LocalDateTime, DateLike, TimeLike by time {

    constructor(
        year: Int,
        monthNumber: Int,
        dayOfMonth: Int,
        hour: Int,
        minute: Int,
        second: Int,
        nanosecond: Int
    ) : this(LocalDate(year, monthNumber, dayOfMonth), LocalTime(hour, minute, second, nanosecond))

    override val year: Int get() = date.year
    override val monthNumber: Int get() = date.monthNumber
    override val month: Month get() = date.month
    override val dayOfMonth: Int get() = date.dayOfMonth
    override val dayOfWeek: DayOfWeek get() = date.dayOfWeek
    override val dayOfYear: Int get() = date.dayOfYear

    override fun compareTo(other: LocalDateTime): Int = date.compareTo(other.date) + time.compareTo(other.time)

    override fun atDate(date: Int) = LocalDateTimeImpl(year, monthNumber, date, hour, minute, second, nanosecond)

    override fun atEndOfMonth() = LocalDateTimeImpl(date.atDate(DaysOfMonth(year, monthNumber)), time)
}