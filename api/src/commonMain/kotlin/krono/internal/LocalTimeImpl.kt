package krono.internal

import krono.LocalTime
import krono.Patterns
import krono.PureTimeFormatter

@PublishedApi
internal data class LocalTimeImpl(
    override val hour: Int,
    override val minute: Int,
    override val second: Int,
    override val nanosecond: Int
) : LocalTime {
    private fun LocalTime.toNanos() = nanosecond + (((second) + (minute * 60) + (hour * 60 * 60)) * 1_000_000_000)

    override fun compareTo(other: LocalTime): Int = toNanos().compareTo(other.toNanos())

    override fun format(pattern: String): String = PureTimeFormatter(pattern).formatTime(hour, minute, second)

    override fun toIsoString(): String = format(Patterns.ISO_TIME)
}