@file:JsExport

package krono

import krono.internal.MonthDayImpl
import kotlin.js.JsExport
import kotlin.js.JsName

interface MonthDay {
    val value: Int
}

@JsName("monthDay")
fun MonthDay(value: Int): MonthDay {
    if (value !in 0..31) {
        throw IllegalArgumentException("$value should be between 0 and 31 for it to be a valid day of the month")
    }
    return MonthDayImpl(value)
}