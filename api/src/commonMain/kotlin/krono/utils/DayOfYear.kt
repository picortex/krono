@file:JsExport

package krono.utils

import kotlin.js.JsExport
import kotlin.js.JsName
import kotlin.math.floor

@JsName("dayOfYear")
// https://astronomy.stackexchange.com/questions/2407/calculate-day-of-the-year-for-a-given-date
fun DayOfYear(year: Int, month: Int, day: Int): Int {
    val N1 = floor((275 * month).toDouble() / 9)
    val N2 = floor((month + 9).toDouble() / 12)
    val N3 = (1 + floor((year - 4 * floor(year.toDouble() / 4) + 2) / 3))
    val N = N1 - (N2 * N3) + day - 30
    return N.toInt()
}