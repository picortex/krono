@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE", "NOTHING_TO_INLINE")

package krono

import kotlinx.datetime.toInstant
import krono.internal.InstantImpl
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.datetime.LocalDateTime as LocalDateTimeKx

@JsName("_ignore_instantFromLong")
inline fun Instant(epochMilliSeconds: Long): Instant = InstantImpl(epochMilliSeconds * 1000)

fun DateTimePresenter.toInstant(): Instant {
    val ldt = LocalDateTimeKx(year, monthNumber, dayOfMonth, hour, minute, second, nanosecond)
    return ldt.toInstant(zone.toTimeZoneKx()).toInstant()
}

fun Clock.currentInstant(): Instant = InstantImpl(currentMicrosAsLong())