package krono

import kotlinx.datetime.Clock

class SystemClock : krono.Clock {
    private val clk = Clock.System
    override fun currentMillisAsLong() = clk.now().toEpochMilliseconds()
    override fun currentMicrosAsLong() = currentMillisAsLong() * 1000
}