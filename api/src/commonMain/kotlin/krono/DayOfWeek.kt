@file:JsExport

package krono;

import kotlin.js.JsExport

enum class DayOfWeek {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    val number get() = ordinal + 1
}