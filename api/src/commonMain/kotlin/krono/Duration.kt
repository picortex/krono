@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import krono.utils.convert
import krono.utils.equals
import kotlin.js.JsExport

data class Duration(val value: Double, val unit: DurationUnit) {
    val nanoSeconds by lazy {
        when (unit) {
            DurationUnit.NanoSeconds -> value
            DurationUnit.MicroSeconds -> value
            DurationUnit.MilliSeconds -> value / 1000
            DurationUnit.Seconds -> value / 1_000_000
            DurationUnit.Minutes -> TODO()
            DurationUnit.Hours -> TODO()
            DurationUnit.Days -> TODO()
            DurationUnit.Weeks -> TODO()
            DurationUnit.Months -> TODO()
            DurationUnit.Years -> TODO()
        }
    }
    val microSeconds by lazy {
        when (unit) {
            DurationUnit.NanoSeconds -> value * 1000
            DurationUnit.MicroSeconds -> value
            DurationUnit.MilliSeconds -> value / 1000
            DurationUnit.Seconds -> value / 1_000_000
            DurationUnit.Minutes -> TODO()
            DurationUnit.Hours -> TODO()
            DurationUnit.Days -> TODO()
            DurationUnit.Weeks -> TODO()
            DurationUnit.Months -> TODO()
            DurationUnit.Years -> TODO()
        }
    }

    val millenniums by lazy {
        when (unit) {
            DurationUnit.NanoSeconds -> value * 1000
            DurationUnit.MicroSeconds -> value
            DurationUnit.MilliSeconds -> value / 1000
            DurationUnit.Seconds -> value / 1_000_000
            DurationUnit.Minutes -> TODO()
            DurationUnit.Hours -> TODO()
            DurationUnit.Days -> TODO()
            DurationUnit.Weeks -> TODO()
            DurationUnit.Months -> TODO()
            DurationUnit.Years -> TODO()
        }
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Duration) return false
        val converted = convert(other.value, other.unit, into = unit)
        return equals(value,converted,0.001)
    }
}