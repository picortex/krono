package krono.utils.conversions

import krono.DurationUnit
import kotlin.math.pow

internal fun convertSeconds(value: Double, into: DurationUnit) = value * when (into) {
    DurationUnit.NanoSeconds -> 10.0.pow(9)
    DurationUnit.MicroSeconds -> 10.0.pow(6)
    DurationUnit.MilliSeconds -> 10.0.pow(3)
    DurationUnit.Seconds -> 1.0
    DurationUnit.Minutes -> 1.0 / 60
    DurationUnit.Hours -> 1.0 / 60 / 60
    DurationUnit.Days -> 1.0 / 60 / 60 / 24
    DurationUnit.Weeks -> 1.0 / 60 / 60 / 24 / 7
    DurationUnit.Months -> 1.0 / 60 / 60 / 24 / 30
    DurationUnit.Years -> 1.0 / 60 / 60 / 24 / 30 / 354.25
}