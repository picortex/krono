@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import kotlin.js.JsExport

class DateTimePresenter(
    val date: LocalDate,
    val time: LocalTime,
    private val formatter: PureDateTimeFormatter
) {
    fun toFormattedString() = formatter.formatDateTime(date.year, date.monthNumber, date.dayOfMonth, time.hour, time.minute, time.second)
}