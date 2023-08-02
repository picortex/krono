import kommander.expect
import krono.utils.DaysOfMonth
import kotlin.test.Test

class DayOfMonthTest {
    @Test
    fun feb_of_leap_year_has_29_days() {
        expect(DaysOfMonth(2020, 2)).toBe(29)
    }

    @Test
    fun feb_of_non_leap_year_has_28_days() {
        expect(DaysOfMonth(2022, 2)).toBe(28)
    }

    @Test
    fun jan_of_any_year_has_31_days() {
        expect(DaysOfMonth(2021, 1)).toBe(31)
        expect(DaysOfMonth(2022, 1)).toBe(31)
    }
}