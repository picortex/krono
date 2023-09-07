package krono.internal.formatters

import krono.LocalDate
import krono.PureDateFormatter

@PublishedApi
internal class PureDateFormatterImpl(private val pattern: String) : PureDateFormatter {

    private val Int.to2digits get() = (if (this < 10) "0" else "") + this

    override fun formatDate(year: Int, month: Int, day: Int): String {
        val date = LocalDate(year, month, day).getOrThrow()
        val YYYY = date.year.toString()
        val YY = YYYY.takeLast(2)
        val mnth = date.month
        val MMMM = mnth.name.lowercase().replaceFirstChar { it.titlecase() }
        val MMM = MMMM.take(3)
        val monthNumber = mnth.number
        val MM = monthNumber.to2digits
        val M = monthNumber.toString()
        val dayOfWeek = date.dayOfWeek
        val DDDD = dayOfWeek.name.lowercase().replaceFirstChar { it.titlecase() }
        val DDD = DDDD.take(3)
        val day = date.dayOfMonth
        val DD = day.to2digits
        val D = day.toString()
        val th = when {
            day in 10..20 -> "th"
            day % 10 == 1 -> "st"
            day % 10 == 2 -> "nd"
            day % 10 == 3 -> "rd"
            else -> "th"
        }
        return pattern
            .replace("{YYYY}", YYYY)
            .replace("{YY}", YY)
            .replace("{MMMM}", MMMM)
            .replace("{MMM}", MMM)
            .replace("{MM}", MM)
            .replace("{M}", M)
            .replace("{DDDD}", DDDD)
            .replace("{DDD}", DDD)
            .replace("{DD}", DD)
            .replace("{D}", D)
            .replace("{th}", th)
    }
}