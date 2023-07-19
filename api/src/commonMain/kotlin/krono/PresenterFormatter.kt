@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import kotlin.js.JsExport

class PresenterFormatter(
    val pattern: PresenterPattern,
    val date: PureDateFormatter,
    val time: PureTimeFormatter,
    val dateTime: PureDateTimeFormatter
)