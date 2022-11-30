@file:JsExport

package krono

import krono.internal.LocalDateTimeImpl
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlin.jvm.JvmOverloads

@JsName("localDateTime")
@JvmOverloads
fun LocalDateTime(year: Int = 1970, month: Int = 1, dayOfMonth: Int = 1, hour: Int = 0, minutes: Int = 0, seconds: Int = 0, nanoseconds: Int = 0): LocalDateTime {
    val date = LocalDate(year, month, dayOfMonth)
    val time = LocalTime(hour, minutes, seconds, nanoseconds)
    return LocalDateTimeImpl(date, time)
}

@JsName("localDateTimeEpoch")
fun LocalDateTimeEpoch(): LocalDateTime = LocalDateTime(1970, 1, 1)

@JsName("parseLocalDateTime")
fun LocalDateTime(isoString: String): LocalDateTime {
    val (year, month, date) = isoString.split("-")
    val day = if (date.contains("T", ignoreCase = true)) date.split("T")[0] else date
    return LocalDateTime(year.toInt(), month.toInt(), day.toInt())
}