@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import kotlinx.datetime.Clock
import krono.internal.InstantImpl
import kotlin.js.JsExport
import kotlin.js.JsName

@JsName("_ignore_instantFromLong")
inline fun Instant(epochMilliSeconds: Long): Instant = InstantImpl(epochMilliSeconds)

inline fun Now(): Instant = InstantImpl(Clock.System.now().toEpochMilliseconds())