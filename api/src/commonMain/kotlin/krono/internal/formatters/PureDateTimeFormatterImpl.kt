package krono.internal.formatters

import krono.PureDateFormatter
import krono.PureDateTimeFormatter
import krono.PureTimeFormatter
import kotlin.js.JsExport

@PublishedApi
internal class PureDateTimeFormatterImpl private constructor(
    private val pattern: String,
    private val dateFormatter: (String) -> PureDateFormatter,
    private val timeFormatter: (String) -> PureTimeFormatter
) : PureDateTimeFormatter, PureDateFormatter by dateFormatter(pattern), PureTimeFormatter by timeFormatter(pattern) {
    constructor(pattern: String) : this(pattern, { PureDateFormatterImpl(it) }, { PureTimeFormatterImpl(it) })

    override fun formatDateTime(year: Int, month: Int, day: Int, hour: Int, minutes: Int, seconds: Int): String {
        val timePattern = dateFormatter(pattern).formatDate(year, month, day)
        return timeFormatter(timePattern).formatTime(hour, minutes, seconds)
    }
}