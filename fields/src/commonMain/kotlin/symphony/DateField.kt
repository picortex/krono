@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package symphony

import krono.LocalDate
import kotlin.js.JsExport
import kotlin.js.JsName

interface DateField : BaseField<LocalDate> {
    @JsName("setIso")
    fun set(iso: String?)
}