package krono.internal.formatters

internal val Int.to2digits get() = (if (this < 10) "0" else "") + this