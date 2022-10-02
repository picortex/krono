@file:JsExport

package krono

import kotlin.js.JsExport

/**
 * A class to format date
 * ```
 * token:    description:             example:
 * {YYYY}     4-digit year             1999
 * {YY}       2-digit year             99
 * {MMMM}     full month name          February
 * {MMM}      3-letter month name      Feb
 * {MM}       2-digit month number     02
 * {M}        month number             2
 * {DDDD}     full weekday name        Wednesday
 * {DDD}      3-letter weekday name    Wed
 * {DD}       2-digit day number       09
 * {D}        day number               9
 * {th}       day ordinal suffix       nd
 * {HH}       2-digit 24-based hour    17
 * {H}        1-digit 24-based hour    9
 * {hh}       2-digit hour             05
 * {h}        1-digit hour             5
 * {mm}       2-digit minute           07
 * {m}        minute                   7
 * {ss}       2-digit second           09
 * {s}        second                   9
 * {ampm}     "am" or "pm"             pm
 * {AMPM}     "AM" or "PM"             PM
 * ```
 */
interface PureDateTimeFormatter : PureDateFormatter, PureTimeFormatter {
    fun formatDateTime(year: Int, month: Int, day: Int, hour: Int, minutes: Int, seconds: Int): String
}