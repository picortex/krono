@file:JsExport

package krono

import kotlinx.serialization.Serializable
import krono.serializers.LocalTimeIsoSerializer
import kotlin.js.JsExport

@Serializable(with = LocalTimeIsoSerializer::class)
interface LocalTime : TimeLike, TemporalComparable<LocalTime>