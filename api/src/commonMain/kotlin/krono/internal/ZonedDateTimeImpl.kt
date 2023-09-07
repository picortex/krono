package krono.internal

import krono.LocalDate
import krono.LocalDateTime
import krono.LocalTime
import krono.TimeZone
import krono.utils.DaysOfMonth

data class ZonedDateTimeImpl(
    override val date: LocalDate,
    override val time: LocalTime,
    override val zone: TimeZone
) : AbstractZonedDateTime(date, time, zone) {

    constructor(datetime: LocalDateTime, tz: TimeZone) : this(datetime.date, datetime.time, tz)

    constructor(
        year: Int,
        monthNumber: Int,
        dayOfMonth: Int,
        hour: Int,
        minute: Int,
        second: Int,
        nanosecond: Int,
        tz: TimeZone
    ) : this(LocalDate(year, monthNumber, dayOfMonth).getOrThrow(), LocalTime(hour, minute, second, nanosecond).getOrThrow(), tz)

    override fun atDate(date: Int) = ZonedDateTimeImpl(year, monthNumber, date, hour, minute, second, nanosecond, zone)

    override fun atEndOfMonth() = ZonedDateTimeImpl(date.atDate(DaysOfMonth(year, monthNumber)), time, zone)

}