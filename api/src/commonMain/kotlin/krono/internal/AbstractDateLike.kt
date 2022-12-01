package krono.internal

import krono.DateLike
import krono.Patterns
import krono.PureDateFormatter

abstract class AbstractDateLike : DateLike {

    override fun format(pattern: String): String = PureDateFormatter(pattern).formatDate(year, monthNumber, dayOfMonth)

    override fun toIsoString(): String = format(Patterns.ISO_DATE)

    override fun toString(): String = toIsoString()
}