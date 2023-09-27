package krono.internal

import kotlinx.datetime.toLocalDateTime
import krono.Duration
import krono.DurationUnit
import krono.Instant
import krono.TimeZone
import krono.TimeZones
import krono.ZonedDateTime
import krono.microseconds
import krono.toLocalDateTime
import krono.toTimeZoneKx
import kotlinx.datetime.Instant.Companion as InstantKx

data class InstantImpl(override val epochMicroSecondsAsLong: Long) : Instant {

    override val epochMilliSecondsAsLong: Long get() = epochMicroSecondsAsLong / 1000

    override fun compareTo(other: Instant) = epochMicroSecondsAsLong.compareTo(other.epochMicroSecondsAsLong)

    override fun atZone(tz: TimeZone): ZonedDateTime {
        val instant = InstantKx.fromEpochMilliseconds(epochMilliSecondsAsLong)
        val datetime = instant.toLocalDateTime(tz.toTimeZoneKx()).toLocalDateTime().getOrThrow()
        return ZonedDateTimeImpl(datetime, tz)
    }

    override fun plus(duration: Duration) = InstantImpl((epochMicroSecondsAsLong.microseconds + duration).inMicroSeconds.toLong())

    override fun minus(other: Instant) = Duration(epochMicroSecondsAsDouble - other.epochMicroSecondsAsDouble, DurationUnit.MicroSeconds)
    override fun atSystemZone(): ZonedDateTime = atZone(TimeZones.System)
}