@file:JsExport

package krono

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

@JsName("localDate")
fun LocalDateKx(year: Int, month: Int = 1, day: Int = 1): LocalDate = LocalDateKx(KxLocalDate(year, month, day))

@JsName("parseLocalDateKx")
@Deprecated("Use LocalDateKx instead")
fun LocalDate(isoString: String): LocalDate = LocalDateKx(isoString)

@JsName("localDateKx")
@Deprecated("Use LocalDateKx instead")
fun LocalDate(year: Int, month: Int, day: Int): LocalDate = LocalDateKx(KxLocalDate(year, month, day))