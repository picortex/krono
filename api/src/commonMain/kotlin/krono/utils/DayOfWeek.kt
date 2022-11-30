@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package krono.utils

import krono.DayOfWeek
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlin.math.floor

@JsName("dayOfWeekOf")
fun DayOfWeek(year: Int, month: Int, day: Int): DayOfWeek {
    val k = day
    val m = (12 + (month - 2)) % 12
    val c = Century(year)
    val y = year - (100 * c)
    // Formula: https://cs.uwaterloo.ca/~alopez-o/math-faq/node73.html#:~:text=For%20a%20Gregorian%20date,%20add,7%20and%20take%20the%20remainder.
    var w = (k + floor((2.6 * m) - 0.2).toInt() - (2 * c) + y + floor(y.toDouble() / 4).toInt() + floor(c.toDouble() / 4).toInt()) % 7
    while (w < 0) {
        w += 7
    }
    return DayOfWeek.values().firstOrNull {
        it.ordinal == w
    } ?: throw IllegalArgumentException("Failed to calculate day of the week for $year-$month-$day")
}