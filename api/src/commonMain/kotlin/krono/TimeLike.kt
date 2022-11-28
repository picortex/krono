@file:JsExport

package krono

import kotlin.js.JsExport

interface TimeLike : TemporalFormattable {
    val hour: Int
    val minute: Int
    val second: Int
    val nanosecond: Int
}