@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import kotlinx.datetime.Clock
import kotlinx.datetime.toLocalDateTime
import krono.internal.LocalDateKx
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.datetime.LocalDate as KxLocalDate

@JsName("parseLocalDate")
fun LocalDateKx(isoString: String): LocalDate = try {
    val (year, month, date) = isoString.split("-")
    val day = if (date.contains("T", ignoreCase = true)) date.split("T")[0] else date
    LocalDateKx(KxLocalDate(year.toInt(), month.toInt(), day.toInt()))
} catch (_: Throwable) {
    LocalDateKx(KxLocalDate.parse(isoString))
}

@JsName("today")
fun Today(tz: TimeZone = TimeZones.System): LocalDate {
    val i = Clock.System.now()
    return LocalDateKx(wrapped = i.toLocalDateTime(tz.toTimeZoneKx()).date)
}