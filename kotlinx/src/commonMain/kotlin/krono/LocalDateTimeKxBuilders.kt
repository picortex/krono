@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import kotlinx.datetime.Clock
import kotlinx.datetime.toLocalDateTime
import kotlin.js.JsExport
import kotlin.js.JsName

@JsName("now")
fun Now(tz: TimeZone = TimeZones.System): LocalDateTime {
    val i = Clock.System.now()
    return i.toLocalDateTime(tz.toTimeZoneKx()).toLocalDateTime()
}