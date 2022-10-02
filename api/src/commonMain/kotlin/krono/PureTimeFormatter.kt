@file:JsExport

package krono

import kotlin.js.JsExport

/**
 * A class to format date
 * ```
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
interface PureTimeFormatter {
    fun formatTime(hour: Int, minutes: Int, seconds: Int): String
}