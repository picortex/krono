@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import kase.Result
import kase.catching
import krono.internal.LocalDateImpl
import krono.internal.utils.ensure
import krono.utils.DaysOfMonth
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

@JsName("localDateAt")
@JvmName("localDateAt")
@JvmOverloads
fun LocalDate(year: Int = 1970, month: Int = 1, dayOfMonth: Int = 1): Result<LocalDate> = catching {
    ensure("month", month, isWithin = 1..12)
    ensure("day of month", dayOfMonth, isWithin = 1..DaysOfMonth(year, month))
    LocalDateImpl(year, month, dayOfMonth)
}

@JsName("localDateEpoch")
@JvmName("localDateEpoch")
inline fun LocalDateEpoch(): LocalDate = LocalDateImpl(1970, 1, 1)

@JsName("parseLocalDate")
@JvmName("parseLocalDate")
fun LocalDate(isoString: String?): Result<LocalDate> = catching {
    val (year, month, date) = isoString?.split("-") ?: throw IllegalArgumentException("isoString can't be null")
    val day = if (date.contains("T", ignoreCase = true)) date.split("T")[0] else date
    LocalDateImpl(year.toInt(), month.toInt(), day.toInt())
}

@JsName("parseLocalDateOrNUll")
@JvmName("parseLocalDateOrNull")
fun LocalDateOrNull(isoString: String?): LocalDate? = LocalDate(isoString).getOrNull()