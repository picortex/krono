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
 * ```
 */
interface PureDateFormatter {
    fun formatDate(year: Int, month: Int, day: Int): String
}