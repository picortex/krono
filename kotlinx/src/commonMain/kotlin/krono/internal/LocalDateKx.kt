package krono.internal

import krono.DayOfWeek
import krono.LocalDate
import krono.Month
import krono.PureDateFormatter
import kotlin.jvm.JvmInline
import kotlinx.datetime.LocalDate as KxLocalDateTime

@JvmInline
internal value class LocalDateKx(private val wrapped: KxLocalDateTime) : LocalDate {
    override val year: Int get() = wrapped.year
    override val monthNumber: Int get() = wrapped.monthNumber
    override val month: Month get() = Month.valueOf(wrapped.month.name)
    override val dayOfMonth: Int get() = wrapped.dayOfMonth
    override val dayOfWeek: DayOfWeek get() = DayOfWeek.valueOf(wrapped.dayOfWeek.name)
    override val dayOfYear: Int get() = wrapped.dayOfYear

    override fun compareTo(other: LocalDate): Int = wrapped.compareTo(KxLocalDateTime(other.year, other.monthNumber, other.dayOfMonth))

    override fun format(pattern: String): String = PureDateFormatter(pattern).formatDate(year, monthNumber, dayOfMonth)

    override fun toIsoString(): String = format(ISO_PATTERN)

    override fun toString(): String = toIsoString()

    companion object {
        private val ISO_PATTERN = "{YYYY}-{MM}-{DD}"
    }
}