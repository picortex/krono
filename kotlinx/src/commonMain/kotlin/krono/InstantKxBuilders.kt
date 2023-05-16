@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE", "NOTHING_TO_INLINE")

package krono

import kotlinx.datetime.Clock
import krono.internal.InstantImpl
import kotlin.js.JsExport
import kotlin.js.JsName

@JsName("_ignore_instantFromLong")
inline fun Instant(epochMilliSeconds: Long): Instant = InstantImpl(epochMilliSeconds * 1000)

inline fun Now(): Instant = InstantImpl(Clock.System.now().toEpochMilliseconds())