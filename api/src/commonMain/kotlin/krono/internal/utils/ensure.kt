package krono.internal.utils

internal fun ensure(key: String, value: Int, isWithin: IntRange) = require(value in isWithin) {
    "$key: $value is not in the $isWithin range"
}