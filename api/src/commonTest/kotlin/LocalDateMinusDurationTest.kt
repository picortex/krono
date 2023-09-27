import kommander.expect
import krono.LocalDate
import krono.days
import krono.hours
import krono.months
import krono.years
import kotlin.test.Test

class LocalDateMinusDurationTest {
    @Test
    fun should_be_able_to_subtract_days_in_december() {
        val dec25 = LocalDate(2020, 12, 25).getOrThrow()
        val dec21 = LocalDate(2020, 12, 21).getOrThrow()
        expect(dec25 - 4.days).toBe(dec21)
    }

    @Test
    fun should_be_able_to_subtract_days_that_would_result_into_different_years() {
        val dec25_2017 = LocalDate(2017, 12, 25).getOrThrow()
        val dec25_2018 = LocalDate(2018, 12, 25).getOrThrow()
        expect(dec25_2018 - 365.days).toBe(dec25_2017)

        val jan25_2019 = LocalDate(2019, 12, 25).getOrThrow()
        val jan25_2020 = LocalDate(2020, 12, 25).getOrThrow()
        expect(jan25_2020 - 366.days).toBe(jan25_2019)
    }

    @Test
    fun should_be_able_to_subtract_days_in_january() {
        val jan8 = LocalDate(2023, 1, 8).getOrThrow()
        val jan6 = LocalDate(2023, 1, 6).getOrThrow()
        expect(jan8 - 2.days).toBe(jan6)
    }

    @Test
    fun should_be_able_to_subtract_days_that_would_result_into_other_months() {
        val nov8 = LocalDate(2023, 11, 8).getOrThrow()
        val oct30 = LocalDate(2023, 10, 30).getOrThrow()
        expect(nov8 - 9.days).toBe(oct30)
    }

    @Test
    fun should_be_able_to_subtract_months() {
        val march1 = LocalDate(2020, 3, 1).getOrThrow()
        val jan1 = LocalDate(2020, 1, 1).getOrThrow()
        expect(march1 - 2.months).toBe(jan1)
    }

    @Test
    fun should_be_able_to_subtract_months_that_would_result_into_other_years() {
        val feb5 = LocalDate(2020, 2, 5).getOrThrow()
        val nov5 = LocalDate(2019, 11, 5).getOrThrow()
        expect(feb5 - 3.months).toBe(nov5)
    }

    @Test
    fun should_be_able_to_subtract_months_that_would_go_backwards_more_than_one_year() {
        val feb5 = LocalDate(2020, 2, 5).getOrThrow()
        val nov5 = LocalDate(2018, 11, 5).getOrThrow()
        expect(feb5 - 15.months).toBe(nov5)
    }

    @Test
    fun should_be_able_to_subtract_fractional_months() {
        val march30 = LocalDate(2020, 3, 30).getOrThrow()
        val march15 = LocalDate(2020, 3, 15).getOrThrow()
        expect(march30 - 0.5.months).toBe(march15)
    }

    @Test
    fun should_be_able_to_subtract_in_hours() {
        val jan2 = LocalDate(2020, 1, 2).getOrThrow()
        val jan1 = LocalDate(2020, 1, 1).getOrThrow()
        expect(jan2 - 24.hours).toBe(jan1)
    }

    @Test
    fun ensure_no_infinite_loops_when_provided_very_low_values() {
        val jan2 = LocalDate(2020, 1, 2).getOrThrow()
        expect(jan2 - 0.5.hours).toBe(jan2)
    }

    @Test
    fun should_be_able_to_subtract_fractional_years() {
        val dec1 = LocalDate(2020, 12, 1).getOrThrow()
        val jun1 = LocalDate(2020, 6, 1).getOrThrow()
        expect(dec1 - 0.5.years).toBe(jun1)
    }

    @Test
    fun should_be_able_to_subtract_full_years() {
        val dec2020 = LocalDate(2020, 12, 25).getOrThrow()
        val dec2015 = LocalDate(2015, 12, 25).getOrThrow()
        expect(dec2020 - 5.years).toBe(dec2015)
    }
}