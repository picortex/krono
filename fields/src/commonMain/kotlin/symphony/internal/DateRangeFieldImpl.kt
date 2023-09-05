package symphony.internal

import krono.LocalDate
import krono.LocalDateOrNull
import neat.ValidationFactory
import symphony.Changer
import symphony.DateRangeField
import symphony.Range
import symphony.Visibility
import kotlin.reflect.KMutableProperty0

@PublishedApi
internal class DateRangeFieldImpl(
    name: KMutableProperty0<Range<LocalDate>?>,
    label: String,
    visibility: Visibility,
    onChange: Changer<Range<LocalDate>>?,
    factory: ValidationFactory<Range<LocalDate>>?
) : AbstractRangeField<LocalDate>(name, label, visibility, onChange, factory), DateRangeField {
    override fun setStart(iso: String?) = setStart(LocalDateOrNull(iso))
    override fun setEnd(iso: String?) = setEnd(LocalDateOrNull(iso))
}