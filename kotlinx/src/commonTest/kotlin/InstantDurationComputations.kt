import kommander.expect
import krono.Instant
import krono.LocalDate
import krono.TimeZones
import krono.days
import kotlin.test.Test

class InstantDurationComputations {
    @Test
    fun should_add_a_duration() {
        val i1 = Instant(0)
        expect(i1.atZone(TimeZones.UTC).date).toBe(LocalDate(1970,1,1))
        val i2 = i1 + 1.days
        expect(i2.atZone(TimeZones.UTC).date).toBe(LocalDate(1970,1,2))
    }
}