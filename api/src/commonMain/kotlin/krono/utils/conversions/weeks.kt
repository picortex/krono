package krono.utils.conversions

import krono.DurationUnit
import kotlin.math.pow

internal fun convertWeeks(value: Double, into: DurationUnit) = value * when (into) {
    DurationUnit.NanoSeconds -> 7.0 * 10.0.pow(9) * 60 * 60 * 24
    DurationUnit.MicroSeconds -> 7.0 * 10.0.pow(6) * 60 * 60 * 24
    DurationUnit.MilliSeconds -> 7.0 * 10.0.pow(3) * 60 * 60 * 24
    DurationUnit.Seconds -> 7.0 * 60 * 60 * 24
    DurationUnit.Minutes -> 7.0 * 60 * 24
    DurationUnit.Hours -> 7.0 * 24
    DurationUnit.Days -> 7.0
    DurationUnit.Weeks -> 1.0
    DurationUnit.Months -> 1.0 / 4
    DurationUnit.Years -> 1.0 / 4 / 12
}