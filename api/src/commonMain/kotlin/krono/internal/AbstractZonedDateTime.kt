package krono.internal

import krono.DateLike
import krono.DayOfWeek
import krono.LocalDate
import krono.LocalDateTime
import krono.LocalTime
import krono.Month
import krono.TimeLike
import krono.TimeZone
import krono.ZonedDateTime
import krono.utils.DaysOfMonth

abstract class AbstractZonedDateTime(
    override val date: LocalDate,
    override val time: LocalTime,
    override val zone: TimeZone
) : AbstractDateLike(), ZonedDateTime, DateLike, TimeLike by time {

    override val year: Int get() = date.year
    override val monthNumber: Int get() = date.monthNumber
    override val month: Month get() = date.month
    override val dayOfMonth: Int get() = date.dayOfMonth
    override val dayOfWeek: DayOfWeek get() = date.dayOfWeek
    override val dayOfYear: Int get() = date.dayOfYear

    private val compareError = """
        [  ERROR  ] Can't compare Dates from different timezones
        [ FIX TIP ] Bring all the dates to UTC and compare them then 
    """.trimIndent()

    override fun compareTo(other: ZonedDateTime): Int {
        if (zone.id != other.zone.id) throw UnsupportedOperationException(compareError)
        return date.compareTo(other.date) + time.compareTo(other.time)
    }

    override fun format(pattern: String): String {
        return super.format(pattern)
    }

    override fun toIsoString(): String {
        return super.toIsoString()
    }
}