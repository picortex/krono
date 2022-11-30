@file:JsExport

package krono

import kotlin.js.JsExport

object Patterns {
    const val ISO_DATE = "{YYYY}-{MM}-{DD}"
    const val ISO_TIME = "{HH}:{mm}:{ss}"
    const val ISO_DATE_TIME = "${ISO_DATE}T$ISO_TIME"
}