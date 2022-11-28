package krono.internal

import krono.LocalDate
import krono.LocalDateTime
import krono.LocalTime
import krono.utils.DaysOfMonth

class LocalDateTimeImpl(val date: LocalDate, val time: LocalTime) : AbstractLocalDate(), LocalDateTime,
    LocalDate by date,
    LocalTime by time {

    constructor(
        year: Int,
        monthNumber: Int,
        dayOfMonth: Int,
        hour: Int,
        minute: Int,
        second: Int,
        nanosecond: Int
    ) : this(LocalDate(year, monthNumber, dayOfMonth), LocalDateTime(hour, minute, second, nanosecond))

    override fun compareTo(other: LocalDateTime): Int {
        TODO("Not yet implemented")
    }

    override fun isBefore(other: LocalDate): Boolean {
        TODO("Not yet implemented")
    }

    override fun isAfter(other: LocalDate): Boolean {
        TODO("Not yet implemented")
    }

    override fun atDate(date: Int) = LocalDateTimeImpl(year, monthNumber, date, hour, minute, second, nanosecond)

    override fun atEndOfMonth() = LocalDateTimeImpl(date.atDate(DaysOfMonth(year, monthNumber)), time)
}