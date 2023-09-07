@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import kase.Result
import kase.catching
import krono.internal.LocalDateTimeImpl
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlin.jvm.JvmOverloads

@JsName("localDateTimeFromDateAndTime")
@JvmOverloads
fun LocalDateTime(date: LocalDate,time: LocalTime): Result<LocalDateTime> = catching {
    LocalDateTimeImpl(date, time)
}

@JsName("localDateTime")
@JvmOverloads
fun LocalDateTime(year: Int = 1970, month: Int = 1, dayOfMonth: Int = 1, hour: Int = 0, minutes: Int = 0, seconds: Int = 0, nanoseconds: Int = 0): Result<LocalDateTime> = catching {
    val date = LocalDate(year, month, dayOfMonth).getOrThrow()
    val time = LocalTime(hour, minutes, seconds, nanoseconds).getOrThrow()
    LocalDateTimeImpl(date, time)
}

@JsName("localDateTimeEpoch")
inline fun LocalDateTimeEpoch(): LocalDateTime = LocalDateTimeImpl(LocalDateEpoch(), Midnight())

@JsName("parseLocalDateTime")
fun LocalDateTime(isoString: String?): Result<LocalDateTime> = catching{
    val iso = isoString ?: throw IllegalArgumentException("isoString can't be null")
    val date = LocalDate(iso).getOrThrow()
    val time = LocalTimeOrMidnight(iso.split("T").getOrNull(1) ?: "")
    LocalDateTimeImpl(date, time)
}