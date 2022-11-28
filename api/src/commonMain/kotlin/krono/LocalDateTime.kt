@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable(with = LocalDateIsoSerializer::class)
interface LocalDateTime : LocalDate, LocalTime, Comparable<LocalDateTime> {

    override fun atDate(date: Int): LocalDateTime

    override fun atEndOfMonth(): LocalDateTime

    override fun format(pattern: String): String

    override fun toIsoString(): String
}