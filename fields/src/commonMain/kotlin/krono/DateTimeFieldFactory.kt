package krono

import krono.internal.DateTimeFieldImpl
import neat.ValidationFactory
import symphony.Changer
import symphony.Fields
import symphony.Visibility
import kotlin.reflect.KMutableProperty0

fun Fields<*>.dateTime(
    name: KMutableProperty0<DateTimePresenter?>,
    label: String = name.name,
    hint: String = label,
    visibility: Visibility = Visibility.Visible,
    pattern: PresenterPattern = name.get()?.pattern ?: PresenterPattern(
        date = "{YYYY}-{MM}-{DD}",
        time = "{HH}:{mm}:{ss}",
        dateTime = "{YYYY}-{MM}-{DD} {HH}:{mm}:{ss}"
    ),
    onChange: Changer<DateTimePresenter>? = null,
    factory: ValidationFactory<DateTimePresenter>? = null
): DateTimeField = getOrCreate(name) {
    DateTimeFieldImpl(name, label, pattern, visibility, hint, onChange, factory)
}