package krono.utils.conversions

import krono.DurationUnit
import kotlin.math.pow

internal fun convertMonths(value: Double, into: DurationUnit) = value * when (into) {
    DurationUnit.NanoSeconds -> 30.0 * 10.0.pow(9) * 60 * 60 * 24
    DurationUnit.MicroSeconds -> 30.0 * 10.0.pow(6) * 60 * 60 * 24
    DurationUnit.MilliSeconds -> 30.0 * 10.0.pow(3) * 60 * 60 * 24
    DurationUnit.Seconds -> 30.0 * 60 * 60 * 24
    DurationUnit.Minutes -> 30.0 * 60 * 24
    DurationUnit.Hours -> 30.0 * 24
    DurationUnit.Days -> 30.0
    DurationUnit.Weeks -> 4.0
    DurationUnit.Months -> 1.0
    DurationUnit.Years -> 1.0 / 12.0
}