@file:JsExport

package krono

import krono.internal.KxLocalDateWrapper
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.datetime.LocalDate as KxLocalDate

@JsName("parseLocalDate")
fun LocalDate(isoString: String): LocalDate = try {
    val (year, month, date) = isoString.split("-")
    val day = if (date.contains("T", ignoreCase = true)) date.split("T")[0] else date
    KxLocalDateWrapper(KxLocalDate(year.toInt(), month.toInt(), day.toInt()))
} catch (_: Throwable) {
    KxLocalDateWrapper(KxLocalDate.parse(isoString))
}

@JsName("localDate")
fun LocalDate(year: Int, month: Int, day: Int): LocalDate = KxLocalDateWrapper(KxLocalDate(year, month, day))