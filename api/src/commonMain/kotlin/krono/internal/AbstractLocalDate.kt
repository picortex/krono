package krono.internal

import krono.LocalDate
import krono.Patterns
import krono.PureDateFormatter
import krono.utils.DaysOfMonth

abstract class AbstractLocalDate : LocalDate {

    override fun atEndOfMonth(): LocalDate = atDate(DaysOfMonth(year, monthNumber))

    override fun format(pattern: String): String = PureDateFormatter(pattern).formatDate(year, monthNumber, dayOfMonth)

    override fun toIsoString(): String = format(Patterns.ISO_DATE)

    override fun toString(): String = toIsoString()
}