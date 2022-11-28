@file:JsExport

package krono

import kotlin.js.JsExport

interface Dateable<out D : Dateable<D>> {
    fun atDate(date: Int): D

    fun atEndOfMonth(): D
}