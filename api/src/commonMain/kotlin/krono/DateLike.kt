@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import kotlin.js.JsExport

interface DateLike : TemporalFormattable {
    val year: Int
    val monthNumber: Int
    val month: Month
    val dayOfMonth: Int
    val dayOfWeek: DayOfWeek
    val dayOfYear: Int
}