@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import kotlin.js.Date

fun dateOf(ld: LocalDate): LocalDate = Date(ld.year, ld.monthNumber - 1, ld.dayOfMonth)

fun dateOrNullOf(ld: LocalDate?): LocalDate? = if (ld == null) null else dateOf(ld)

fun localDateOf(d: LocalDate) = LocalDate(d.toISOString())