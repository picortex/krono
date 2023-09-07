@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import krono.internal.AbstractZonedDateTime
import krono.utils.DaysOfMonth
import kotlin.js.JsExport
import kotlin.js.JsName

data class DateTimePresenter(
    override val date: LocalDate,
    override val time: LocalTime,
    override val zone: TimeZone,
    val pattern: PresenterPattern
) : AbstractZonedDateTime(date, time, zone) {

    @JsName("_ignore_from")
    constructor(
        year: Int,
        monthNumber: Int,
        dayOfMonth: Int,
        hour: Int,
        minute: Int,
        second: Int,
        nanosecond: Int,
        tz: TimeZone,
        pattern: PresenterPattern
    ) : this(LocalDate(year, monthNumber, dayOfMonth).getOrThrow(), LocalTime(hour, minute, second, nanosecond).getOrThrow(), tz, pattern)

    override fun atDate(date: Int) = DateTimePresenter(year, monthNumber, date, hour, minute, second, nanosecond, zone, pattern)

    override fun atEndOfMonth() = DateTimePresenter(date.atDate(DaysOfMonth(year, monthNumber)), time, zone, pattern)

    val formatter = pattern.formatter
    fun toDateString(): String = formatter.date.formatDate(date.year, date.monthNumber, date.dayOfMonth)
    fun toTimeString(): String = formatter.time.formatTime(time.hour, time.minute, time.second)
    fun toDateTimeString(): String = formatter.dateTime.formatDateTime(date.year, date.monthNumber, date.dayOfMonth, time.hour, time.minute, time.second)
}