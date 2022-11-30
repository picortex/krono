@file:JsExport

package krono

import krono.internal.LocalDateImpl
import krono.internal.utils.ensure
import krono.utils.DaysOfMonth
import kotlin.js.JsExport
import kotlin.js.JsName

@JsName("localDate")
fun LocalDate(year: Int = 1970, month: Int = 1, dayOfMonth: Int = 1): LocalDate {
    ensure("month", month, isWithin = 1..12)
    ensure("day of month", dayOfMonth, isWithin = 1..DaysOfMonth(year, month))
    return LocalDateImpl(year, month, dayOfMonth)
}

@JsName("localDateEpoch")
fun LocalDateEpoch(): LocalDate = LocalDateImpl(1970, 1, 1)

@JsName("parseLocalDate")
fun LocalDate(isoString: String): LocalDate {
    val (year, month, date) = isoString.split("-")
    val day = if (date.contains("T", ignoreCase = true)) date.split("T")[0] else date
    return LocalDateImpl(year.toInt(), month.toInt(), day.toInt())
}