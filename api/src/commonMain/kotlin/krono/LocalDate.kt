@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import kotlinx.serialization.Serializable
import krono.serializers.LocalDateIsoSerializer
import kotlin.js.JsExport
import kotlin.js.JsName

@Serializable(with = LocalDateIsoSerializer::class)
interface LocalDate : DateLike, Dateable<LocalDate>, TemporalComparable<LocalDate> {
    fun toEpochMillisAsLong(): Long
    fun toEpochMillisAsDouble(): Double
    fun toEpochMillisAsInt(): Int

    @JsName("minusDate")
    operator fun minus(other: LocalDate): Duration

    @JsName("minusDuration")
    operator fun minus(duration: Duration): LocalDate

    operator fun plus(duration: Duration) : LocalDate
}