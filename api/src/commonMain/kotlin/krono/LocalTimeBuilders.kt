@file:JsExport

package krono

import krono.internal.LocalTimeImpl
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.datetime.LocalDate as KxLocalDate

@JsName("localTime")
fun LocalTime(hour: Int = 0, minutes: Int = 0, seconds: Int = 0, nanoseconds: Int = 0): LocalTime {
    require(hour in 0..24) { invalid("hour", hour, "0 - 23") }
    require(minutes in 0..59) { invalid("minute", minutes, "0 - 59") }
    require(seconds in 0..59) { invalid("second", seconds, " 0 - 59") }
    return LocalTimeImpl(hour, minutes, seconds, nanoseconds)
}

private fun invalid(key: String, value: Int, range: String) = "$key: $value is not in the $range range"