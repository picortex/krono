import kommander.expect
import krono.utils.DayOfWeek
import krono.DayOfWeek
import kotlin.test.Test

class DayOfWeekTest {

    @Test
    fun day_2022_01_01_should_be_Saturday() {
        expect(DayOfWeek(2022, 1, 1), DayOfWeek.SATURDAY)
    }

    @Test
    fun day_2022_02_01_should_be_Tuesday() {
        expect(DayOfWeek(2022, 2, 1), DayOfWeek.TUESDAY)
    }

    @Test
    fun day_2022_11_28_should_be_Monday() {
        expect<DayOfWeek>(DayOfWeek(2022, 11, 28)).toBe(DayOfWeek.MONDAY)
    }

    @Test
    fun day_2022_11_29_should_be_Tuesday() {
        expect(DayOfWeek(2022, 11, 29)).toBe(DayOfWeek.TUESDAY)
    }

    @Test
    fun day_2022_11_30_should_be_Wednesday() {
        expect(DayOfWeek(2022, 11, 30)).toBe(DayOfWeek.WEDNESDAY)
    }
}