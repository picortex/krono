package symphony

import krono.LocalDate
import neat.ValidationFactory
import symphony.internal.DateRangeFieldImpl
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