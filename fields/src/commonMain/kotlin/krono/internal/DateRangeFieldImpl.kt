package krono.internal

import krono.LocalDate
import neat.ValidationFactory
import symphony.Changer
import krono.DateRangeField
import symphony.Range
import symphony.Visibility
import symphony.internal.AbstractRangeField
import kotlin.reflect.KMutableProperty0

@PublishedApi
internal class DateRangeFieldImpl(
    name: KMutableProperty0<Range<LocalDate>?>,
    label: String,
    visibility: Visibility,
    onChange: Changer<Range<LocalDate>>?,
    factory: ValidationFactory<Range<LocalDate>>?
) : AbstractRangeField<LocalDate>(name, label, visibility, onChange, factory), DateRangeField {
    override fun setStart(iso: String?) = setStart(LocalDate(iso).getOrNull())
    override fun setEnd(iso: String?) = setEnd(LocalDate(iso).getOrNull())
}