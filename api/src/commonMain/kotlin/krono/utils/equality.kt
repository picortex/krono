package krono.utils

import kotlin.math.abs

fun equals(lhs: Double, rhs: Double, tolerance: Double = 0.001) = abs(rhs - lhs) <= tolerance