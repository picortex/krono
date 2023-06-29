import expect.expect
import kommander.expect
import kotlinx.datetime.DatePeriod
import krono.TimeZones
import kotlin.test.Test

class TimeZonesTest {
    @Test
    fun should_get_utc_timezone_id() {
        val utc = TimeZones.UTC
        expect<String>(utc.id).toBe("Z")

        DatePeriod
    }
}