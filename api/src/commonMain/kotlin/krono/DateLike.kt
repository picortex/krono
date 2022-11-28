@file:JsExport

package krono

import kotlin.js.JsExport

interface DateLike<out D : DateLike<D>> {
    val year: Int
    val monthNumber: Int
    val month: Month
    val dayOfMonth: Int
    val dayOfWeek: DayOfWeek
    val dayOfYear: Int

    fun atDate(date: Int): D

    fun atEndOfMonth(): D

    fun format(pattern: String): String

    fun toIsoString(): String
}