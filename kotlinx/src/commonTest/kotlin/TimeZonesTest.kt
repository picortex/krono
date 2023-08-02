import kommander.expect
import krono.TimeZones
import kotlin.test.Test

class TimeZonesTest {
    @Test
    fun should_get_utc_timezone_id() {
        val utc = TimeZones.UTC
        expect(utc.id).toBe("Z")
    }
}