@file:JsExport

package krono

import kotlin.js.JsExport

interface LocalTime : Comparable<LocalTime> {
    val hour: Int
    val minute: Int
    val second: Int
    val nanosecond: Int
}