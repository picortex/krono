@file:JsExport

package krono

import kotlin.js.JsExport

interface TemporalFormattable {
    fun format(pattern: String): String

    fun toIsoString(): String
}