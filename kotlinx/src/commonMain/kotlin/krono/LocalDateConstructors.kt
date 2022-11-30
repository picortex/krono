@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import kotlinx.datetime.Clock
import kotlinx.datetime.toLocalDateTime
import kotlin.js.JsExport
import kotlin.js.JsName

@JsName("today")
fun Today(tz: TimeZone = TimeZones.System): LocalDate {
    val i = Clock.System.now()
    return i.toLocalDateTime(tz.toTimeZoneKx()).date.toLocalDate()
}