package krono

import kotlinx.datetime.LocalDateTime as LocalDateTimeKx

fun LocalDateTimeKx.toLocalDateTime() = LocalDateTime(year, monthNumber, dayOfMonth, hour, minute, second, nanosecond)