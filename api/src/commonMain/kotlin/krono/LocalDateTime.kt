@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import kotlinx.serialization.Serializable
import krono.serializers.LocalDateIsoSerializer
import kotlin.js.JsExport

@JsExport
@Serializable(with = LocalDateIsoSerializer::class)
interface LocalDateTime : DateLike, TimeLike, Dateable<LocalDateTime>, TemporalComparable<LocalDateTime> {
    val date: LocalDate
    val time: LocalTime
}