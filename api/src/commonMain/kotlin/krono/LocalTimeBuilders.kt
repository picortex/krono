@file:JsExport
//@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import krono.internal.LocalTimeImpl
import krono.internal.utils.ensure
import kotlin.js.JsExport
import kotlin.js.JsName

@JsName("localTime")
fun LocalTime(hour: Int = 0, minutes: Int = 0, seconds: Int = 0, nanoseconds: Int = 0): LocalTime {
    ensure("hour", hour, isWithin = 0..24)
    ensure("minutes", minutes, isWithin = 0..59)
    ensure("seconds", seconds, isWithin = 0..59)
    return LocalTimeImpl(hour, minutes, seconds, nanoseconds)
}

@JsName("parseLocalTime")
fun LocalTime(isoString: String): LocalTime {
    val splits = isoString.split(":")
    val hour = splits.getOrNull(0)?.toInt() ?: throw IllegalArgumentException("Hour is missing in missing in $isoString")
    val minute = splits.getOrNull(1)?.toInt() ?: 0
    val seconds = splits.getOrNull(2)?.toInt() ?: 0
    val nanos = splits.getOrNull(3)?.toInt() ?: 0
    return LocalTime(hour, minute, seconds, nanos)
}

@JsName("parseLocalTimeOrMidnight")
fun LocalTimeOrMidnight(isoString: String): LocalTime = try {
    LocalTime(isoString)
} catch (_: Throwable) {
    LocalTime(0, 0)
}