@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import krono.utils.convert
import krono.utils.equals
import kotlin.js.JsExport
import kotlin.math.roundToInt

data class Duration(val value: Double, val unit: DurationUnit) {
    val nanoSeconds by lazy { convert(value, unit, DurationUnit.NanoSeconds) }
    val microSeconds by lazy { convert(value, unit, DurationUnit.MicroSeconds) }
    val milliSeconds by lazy { convert(value, unit, DurationUnit.MilliSeconds) }
    val seconds by lazy { convert(value, unit, DurationUnit.Seconds) }
    val minutes by lazy { convert(value, unit, DurationUnit.Minutes) }
    val hours by lazy { convert(value, unit, DurationUnit.Hours) }
    val weeks by lazy { convert(value, unit, DurationUnit.Weeks) }
    val days by lazy { convert(value, unit, DurationUnit.Days) }
    val months by lazy { convert(value, unit, DurationUnit.Months) }
    val years by lazy { convert(value, unit, DurationUnit.Years) }

    operator fun plus(other: Duration): Duration {
        val converted = convert(other.value, from = other.unit, into = unit)
        return Duration(value + converted, unit)
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Duration) return false
        val converted = convert(other.value, from = other.unit, into = unit)
        return equals(value, converted, 0.001)
    }

    fun toRelativeString(): String {
        var dur: Duration = this
        for(entry in DurationUnit.values().reversed()) {
            val converted = convert(value, unit, entry)
            dur = Duration(converted, entry)
            if (converted >= 1) break
        }
        return buildString {
            val rounded = dur.value.roundToInt()
            if (rounded == 1) {
                append("a")
            } else {
                append(rounded)
            }
            append(" ")
            var siUnit = dur.unit.name.lowercase()
            if (rounded == 1) {
                siUnit = siUnit.removeSuffix("s")
            }
            append(siUnit)
        }
    }
}