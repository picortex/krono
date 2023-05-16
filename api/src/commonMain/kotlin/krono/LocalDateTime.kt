@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import kotlinx.serialization.Serializable
import krono.serializers.LocalDateIsoSerializer
import krono.serializers.LocalDateTimeIsoSerializer
import kotlin.js.JsExport

@Serializable(with = LocalDateTimeIsoSerializer::class)
interface LocalDateTime : DateLike, TimeLike, Dateable<LocalDateTime>, TemporalComparable<LocalDateTime> {
    val date: LocalDate
    val time: LocalTime
}