package krono.internal

import kotlinx.datetime.toLocalDateTime
import krono.Instant
import krono.TimeZone
import krono.TimeZones
import krono.ZonedDateTime
import krono.toLocalDateTime
import krono.toTimeZoneKx
import kotlinx.datetime.Instant.Companion as InstantKx

data class InstantImpl(override val epochMilliSecondsAsLong: Long) : Instant {

    override fun compareTo(other: Instant) = epochMilliSecondsAsLong.compareTo(other.epochMilliSecondsAsLong)

    override fun atZone(tz: TimeZone): ZonedDateTime {
        val instant = InstantKx.fromEpochMilliseconds(epochMilliSecondsAsLong)
        val datetime = instant.toLocalDateTime(tz.toTimeZoneKx()).toLocalDateTime()
        return ZonedDateTimeImpl(datetime, tz)
    }

    override fun atSystemZone(): ZonedDateTime = atZone(TimeZones.System)
}