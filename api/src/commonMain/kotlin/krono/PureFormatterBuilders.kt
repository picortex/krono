@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import krono.internal.formatters.PureDateFormatterImpl
import krono.internal.formatters.PureDateTimeFormatterImpl
import krono.internal.formatters.PureTimeFormatterImpl
import kotlin.js.JsExport
import kotlin.js.JsName

@JsName("pureDateFormatter")
fun PureDateFormatter(pattern: String): PureDateFormatter = PureDateFormatterImpl(pattern)

@JsName("pureTimeFormatter")
fun PureTimeFormatter(pattern: String): PureTimeFormatter = PureTimeFormatterImpl(pattern)

@JsName("pureDateTimeFormatter")
fun PureDateTimeFormatter(pattern: String): PureDateTimeFormatter = PureDateTimeFormatterImpl(pattern)