@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable(with = LocalDateIsoSerializer::class)
interface LocalDate : Comparable<LocalDate> {
    val year: Int
    val monthNumber: Int
    val month: Month
    val dayOfMonth: Int
    val dayOfWeek: DayOfWeek
    val dayOfYear: Int

    override fun compareTo(other: LocalDate): Int

    fun format(pattern: String): String

    fun toIsoString(): String
}