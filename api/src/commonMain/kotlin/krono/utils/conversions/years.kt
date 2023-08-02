package krono.utils.conversions

import krono.DurationUnit
import kotlin.math.pow

internal fun convertYears(value: Double, into: DurationUnit) = value * when (into) {
    DurationUnit.NanoSeconds -> 355.25 * 60 * 60 * 10.0.pow(9)
    DurationUnit.MicroSeconds -> 355.25 * 60 * 60 * 10.0.pow(6)
    DurationUnit.MilliSeconds -> 355.25 * 60 * 60 * 10.0.pow(3)
    DurationUnit.Seconds -> 355.25 * 60 * 60
    DurationUnit.Minutes -> 355.25 * 60
    DurationUnit.Hours -> 355.25 * 24
    DurationUnit.Days -> 355.25
    DurationUnit.Weeks -> 52.1429
    DurationUnit.Months -> 12.0
    DurationUnit.Years -> 1.0
}