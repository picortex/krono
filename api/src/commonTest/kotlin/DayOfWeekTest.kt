import expect.expect
import krono.utils.DayOfWeek
import krono.DayOfWeek
import kotlin.test.Test

class DayOfWeekTest {
    @Test
    fun should_calculate_a_proper_day_of_week() {
        val dow1 = DayOfWeek(2022, 11, 28)
        expect(dow1).toBe(DayOfWeek.MONDAY)

        val dow2 = DayOfWeek(2022, 11, 29)
        expect(dow2).toBe(DayOfWeek.TUESDAY)

        val dow3 = DayOfWeek(2022, 11, 30)
        expect(dow3).toBe(DayOfWeek.WEDNESDAY)
    }
}