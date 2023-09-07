package krono

import neat.ValidationFactory
import krono.internal.DateRangeFieldImpl
import symphony.Changer
import symphony.Fields
import symphony.Range
import symphony.Visibility
import kotlin.reflect.KMutableProperty0

fun Fields<*>.range(
    name: KMutableProperty0<Range<LocalDate>?>,
    label: String = name.name,
    visibility: Visibility = Visibility.Visible,
    onChange: Changer<Range<LocalDate>>? = null,
    factory: ValidationFactory<Range<LocalDate>>? = null
): DateRangeField = getOrCreate(name) {
    DateRangeFieldImpl(name, label, visibility, onChange, factory)
}