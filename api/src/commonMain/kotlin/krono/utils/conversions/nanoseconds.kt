package krono.utils.conversions

import krono.DurationUnit
import kotlin.math.pow

internal fun convertNanoSeconds(value: Double, into: DurationUnit) = value * when (into) {
    DurationUnit.NanoSeconds -> 10.0.pow(0)
    DurationUnit.MicroSeconds -> 10.0.pow(-3)
    DurationUnit.MilliSeconds -> 10.0.pow(-6)
    DurationUnit.Seconds -> 10.0.pow(-9)
    DurationUnit.Minutes -> 10.0.pow(-9) / 60
    DurationUnit.Hours -> 10.0.pow(-9) / 60 / 60
    DurationUnit.Days -> 10.0.pow(-9) / 60 / 60 / 24
    DurationUnit.Weeks -> 10.0.pow(-9) / 60 / 60 / 24 / 7
    DurationUnit.Months -> 10.0.pow(-9) / 60 / 60 / 24 / 30
    DurationUnit.Years -> 10.0.pow(-9) / 60 / 60 / 24 / 30 / 354.25
}