@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import krono.internal.TimeZoneImpl
import kotlin.js.JsExport
import kotlin.js.JsName

@JsName("timeZoneOf")
fun TimeZone(id: String): TimeZone = TimeZoneImpl(id)