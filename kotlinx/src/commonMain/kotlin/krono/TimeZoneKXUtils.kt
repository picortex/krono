package krono

fun TimeZone.toTimeZoneKx() = kotlinx.datetime.TimeZone.of(id)