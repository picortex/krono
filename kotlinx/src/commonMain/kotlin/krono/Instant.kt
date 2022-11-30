@file:JsExport

package krono

import kotlinx.serialization.Serializable
import krono.serializers.InstantSerializer
import kotlin.js.JsExport
import kotlin.js.JsName

@Serializable(with = InstantSerializer::class)
interface Instant : TemporalComparable<Instant> {

    val epochMilliSecondsAsLong: Long

    val epochMilliSecondsAsDouble get() = epochMilliSecondsAsLong.toDouble()

    val epochSeconds get() = (epochMilliSecondsAsLong / 1_000).toInt()

    fun atZone(tz: TimeZone): ZonedDateTime

    fun atSystemZone(): ZonedDateTime

    @JsName("atZoneWithId")
    fun atZone(id: String) = atZone(TimeZone(id))
}