@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable(with = LocalDateIsoSerializer::class)
interface LocalDateTime : DateLike<LocalDateTime>, TimeLike, TemporalComparable<LocalDateTime> {
    val date: LocalDate
    val time: LocalTime
}