import kommander.expect
import krono.utils.DayOfYear
import kotlin.test.Test

class DayOfYearTest {
    @Test
    fun should_calculate_a_proper_day_of_year() {
        val doy1 = DayOfYear(2022, 1, 1)
        expect(doy1).toBe(1)

        val doy2 = DayOfYear(2022, 1, 2)
        expect(doy2).toBe(2)
    }
}