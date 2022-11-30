@file:JsExport

package krono.utils

import kotlin.js.JsExport
import kotlin.js.JsName
import kotlin.math.floor

@JsName("centuryOf")
fun Century(year: Int): Int = floor(year.toDouble() / 100).toInt()