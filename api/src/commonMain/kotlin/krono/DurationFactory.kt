package krono

inline val Number.microseconds get() = Duration(toDouble(), DurationUnit.MicroSeconds)

inline val Number.milliseconds get() = Duration(toDouble(), DurationUnit.MilliSeconds)

inline val Number.seconds get() = Duration(toDouble(), DurationUnit.Seconds)

inline val Number.minutes get() = Duration(toDouble(), DurationUnit.Minutes)

inline val Number.hours get() = Duration(toDouble(), DurationUnit.Hours)

inline val Number.days get() = Duration(toDouble(), DurationUnit.Days)

inline val Number.weeks get() = Duration(toDouble(), DurationUnit.Weeks)

inline val Number.months get() = Duration(toDouble(), DurationUnit.Months)

inline val Number.years get() = Duration(toDouble(), DurationUnit.Years)