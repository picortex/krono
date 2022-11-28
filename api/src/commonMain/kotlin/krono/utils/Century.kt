@file:JsExport

package krono.utils

import kotlin.js.JsExport
import kotlin.js.JsName
import kotlin.math.floor

@JsName("getCenturyFor")
fun Century(year: Int): Int = floor(year.toDouble() / 100).toInt()