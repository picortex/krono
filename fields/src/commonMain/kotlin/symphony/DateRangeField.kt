@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package symphony

import krono.LocalDate
import kotlin.js.JsExport
import kotlin.js.JsName

interface DateRangeField : RangeField<LocalDate> {
    @JsName("setStartIsoString")
    fun setStart(iso: String?)

    @JsName("setEndIsoString")
    fun setEnd(iso: String?)
}