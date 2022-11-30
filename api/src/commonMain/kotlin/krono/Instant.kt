@file:JsExport

package krono

import kotlin.js.JsExport

interface Instant : TemporalComparable<Instant> {
//    fun atLocalDateTimeAt(tz: TimeZone): LocalDateTime
//    fun atLocalDateTimeAtTimeZone(id: String) = atLocalDateTimeAt(TimeZone(id))
}