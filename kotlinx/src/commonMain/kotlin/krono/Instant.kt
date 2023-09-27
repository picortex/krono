@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import kotlinx.serialization.Serializable
import krono.serializers.InstantSerializer
import kotlin.js.JsExport
import kotlin.js.JsName

@Serializable(with = InstantSerializer::class)
interface Instant : TemporalComparable<Instant> {

    val epochMicroSecondsAsLong: Long

    val epochMicroSecondsAsDouble: Double get() = epochMicroSecondsAsLong.toDouble()

    val epochMilliSecondsAsLong: Long

    val epochMilliSecondsAsDouble get() = epochMilliSecondsAsLong.toDouble()

    val epochSeconds get() = (epochMilliSecondsAsLong / 1_000).toInt()

    fun atZone(tz: TimeZone): ZonedDateTime

    fun atSystemZone(): ZonedDateTime

    operator fun plus(duration: Duration) : Instant

    operator fun minus(other: Instant) : Duration

    @JsName("atZoneWithId")
    fun atZone(id: String) = atZone(TimeZone(id))
}