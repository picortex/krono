package krono.internal

import neat.ValidationFactory
import symphony.Changer
import krono.DateTimeField
import krono.DateTimePresenter
import krono.LocalDate
import krono.LocalDateEpoch
import krono.LocalDateTime
import krono.LocalTime
import krono.Midnight
import krono.PresenterPattern
import krono.TimeZones
import symphony.Visibility
import symphony.internal.BaseFieldImpl
import kotlin.reflect.KMutableProperty0

@PublishedApi
internal class DateTimeFieldImpl(
    name: KMutableProperty0<DateTimePresenter?>,
    label: String,
    private val pattern: PresenterPattern,
    visibility: Visibility,
    hint: String,
    onChange: Changer<DateTimePresenter>?,
    factory: ValidationFactory<DateTimePresenter>?
) : BaseFieldImpl<DateTimePresenter>(name, label, visibility, hint, onChange, factory), DateTimeField {
    override fun setDateTimeIso(iso: String?) {
        val dt = LocalDateTime(iso).getOrNull() ?: return
        val out = state.value.output?.copy(date = dt.date, time = dt.time) ?: LocalDateTimePresenter(
            date = dt.date,
            time = dt.time,
            zone = TimeZones.System,
            pattern = pattern
        )
        set(out)
    }

    override fun setDateIso(iso: String?) {
        val date = LocalDate(iso).getOrNull() ?: return
        val out = state.value.output?.copy(date = date) ?: LocalDateTimePresenter(
            date = date,
            time = Midnight(),
            zone = TimeZones.System,
            pattern = pattern
        )
        set(out)
    }

    override fun setTimeIso(iso: String?) {
        val time = LocalTime(iso).getOrNull() ?: return
        val out = state.value.output?.copy(time = time) ?: LocalDateTimePresenter(
            date = LocalDateEpoch(),
            time = time,
            zone = TimeZones.System,
            pattern = pattern
        )
        set(out)
    }
}