package symphony.internal

import krono.LocalDate
import krono.LocalDateOrNull
import neat.ValidationFactory
import symphony.Changer
import symphony.DateField
import symphony.Visibility
import kotlin.reflect.KMutableProperty0

@PublishedApi
internal class DateFieldImpl(
    name: KMutableProperty0<LocalDate?>,
    label: String,
    visibility: Visibility,
    hint: String,
    onChange: Changer<LocalDate>?,
    factory: ValidationFactory<LocalDate>?
) : BaseFieldImpl<LocalDate>(name, label, visibility, hint, onChange, factory), DateField {
    override fun set(iso: String?) = set(LocalDateOrNull(iso))
}