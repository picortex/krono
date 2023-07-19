@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import kotlin.js.JsExport

class DateTimePresenter(
    val date: LocalDate,
    val time: LocalTime,
    val pattern: PresenterPattern
) {
    val formatter = pattern.formatter
    fun toDateString(): String = formatter.date.formatDate(date.year, date.dayOfMonth, date.dayOfMonth)
    fun toTimeString(): String = formatter.time.formatTime(time.hour, time.minute, time.second)
    fun toDateTimeString(): String = formatter.dateTime.formatDateTime(date.year, date.monthNumber, date.dayOfMonth, time.hour, time.minute, time.second)
}