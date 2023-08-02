package krono.utils

import krono.DurationUnit
import krono.DurationUnit.Days
import krono.DurationUnit.Hours
import krono.DurationUnit.MicroSeconds
import krono.DurationUnit.MilliSeconds
import krono.DurationUnit.Minutes
import krono.DurationUnit.Months
import krono.DurationUnit.NanoSeconds
import krono.DurationUnit.Seconds
import krono.DurationUnit.Weeks
import krono.DurationUnit.Years
import krono.utils.conversions.convertDays
import krono.utils.conversions.convertHours
import krono.utils.conversions.convertMicroSeconds
import krono.utils.conversions.convertMilliSeconds
import krono.utils.conversions.convertMinutes
import krono.utils.conversions.convertMonths
import krono.utils.conversions.convertNanoSeconds
import krono.utils.conversions.convertSeconds
import krono.utils.conversions.convertWeeks
import krono.utils.conversions.convertYears

internal fun convert(value: Double, from: DurationUnit, into: DurationUnit) = when (from) {
    NanoSeconds -> convertNanoSeconds(value, into)
    MicroSeconds -> convertMicroSeconds(value, into)
    MilliSeconds -> convertMilliSeconds(value, into)
    Seconds -> convertSeconds(value, into)
    Minutes -> convertMinutes(value, into)
    Hours -> convertHours(value, into)
    Days -> convertDays(value, into)
    Weeks -> convertWeeks(value, into)
    Months -> convertMonths(value, into)
    Years -> convertYears(value, into)
}