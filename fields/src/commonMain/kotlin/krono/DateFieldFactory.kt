package krono

import neat.ValidationFactory
import krono.internal.DateFieldImpl
import symphony.Changer
import symphony.Fields
import symphony.Visibility
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