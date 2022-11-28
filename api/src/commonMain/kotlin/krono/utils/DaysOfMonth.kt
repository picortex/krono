@file:JsExport

package krono.utils

import kotlin.js.JsExport
import kotlin.js.JsName

@JsName("daysOfMonth")
fun DaysOfMonth(year: Int, month: Int): Int {
    if (month == 2) return if (isLeapYear(year)) 29 else 28
    return 31 - (month - 1) % 7 % 2
}