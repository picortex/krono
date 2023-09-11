@file:Suppress("NOTHING_TO_INLINE")

package krono

import krono.internal.InstantImpl
import kotlinx.datetime.Instant as KxInstant

inline fun KxInstant.toInstant(): Instant = InstantImpl(toEpochMilliseconds() * 1000)