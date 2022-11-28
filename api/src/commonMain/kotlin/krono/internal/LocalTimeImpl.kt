package krono.internal

import krono.LocalTime

internal class LocalTimeImpl(
    override val hour: Int,
    override val minute: Int,
    override val second: Int,
    override val nanosecond: Int
) : LocalTime {
    constructor(lt: LocalTime) : this(hour = lt.hour, minute = lt.minute, second = lt.second, nanosecond = lt.nanosecond)

    fun toNanos() = nanosecond + (((second) + (minute * 60) + (hour * 60 * 60)) * 1_000_000_000)
}