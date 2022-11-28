@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable(with = LocalDateIsoSerializer::class)
interface LocalDate {
    val year: Int
    val monthNumber: Int
    val month: Month
    val dayOfMonth: Int
    val dayOfWeek: DayOfWeek
    val dayOfYear: Int

    fun isBefore(other: LocalDate): Boolean

    fun isAfter(other: LocalDate): Boolean

    fun atDate(date: Int): LocalDate

    fun atEndOfMonth(): LocalDate

    fun format(pattern: String): String

    fun toIsoString(): String
}