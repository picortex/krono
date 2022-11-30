@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable(with = LocalDateIsoSerializer::class)
interface ZonedDateTime : DateLike, TimeLike, Dateable<ZonedDateTime>, TemporalComparable<ZonedDateTime> {
    val tz: TimeZone
    val date: LocalDate
    val time: LocalTime
}