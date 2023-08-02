package krono.utils.conversions

import krono.DurationUnit
import kotlin.math.pow

internal fun convertMilliSeconds(value: Double, into: DurationUnit) = value * when (into) {
    DurationUnit.NanoSeconds -> 10.0.pow(6)
    DurationUnit.MicroSeconds -> 10.0.pow(3)
    DurationUnit.MilliSeconds -> 10.0.pow(0)
    DurationUnit.Seconds -> 10.0.pow(-3)
    DurationUnit.Minutes -> 10.0.pow(-3) / 60
    DurationUnit.Hours -> 10.0.pow(-3) / 60 / 60
    DurationUnit.Days -> 10.0.pow(-3) / 60 / 60 / 24
    DurationUnit.Weeks -> 10.0.pow(-3) / 60 / 60 / 24 / 7
    DurationUnit.Months -> 10.0.pow(-3) / 60 / 60 / 24 / 30
    DurationUnit.Years -> 10.0.pow(-3) / 60 / 60 / 24 / 30 / 354.25
}