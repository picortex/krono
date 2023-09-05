package symphony

import krono.LocalDate
import neat.ValidationFactory
import symphony.internal.DateFieldImpl
import kotlin.reflect.KMutableProperty0

fun Fields<*>.date(
    name: KMutableProperty0<LocalDate?>,
    label: String = name.name,
    hint: String = label,
    visibility: Visibility = Visibility.Visible,
    onChange: Changer<LocalDate>? = null,
    factory: ValidationFactory<LocalDate>? = null
): DateField = getOrCreate(name) {
    DateFieldImpl(name, label, visibility, hint, onChange, factory)
}