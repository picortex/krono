package krono

import kotlinx.datetime.LocalDate as LocalDateKx

fun LocalDateKx.toLocalDate() = LocalDate(year, monthNumber, dayOfMonth)