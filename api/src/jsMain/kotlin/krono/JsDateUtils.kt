@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import kotlin.js.Date

fun dateOf(ld: LocalDate): Date = Date(ld.year, ld.monthNumber - 1, ld.dayOfMonth)

fun dateOrNullOf(ld: LocalDate?): Date? = if (ld == null) null else dateOf(ld)

fun localDateOf(d: Date) = Date(d.toISOString())