import kommander.expect
import krono.LocalDate
import krono.days
import krono.hours
import krono.months
import krono.years
import kotlin.test.Test

class LocalDatePlusDurationTest {
    @Test
    fun should_be_able_to_add_days_in_december() {
        val dec25 = LocalDate(2020, 12, 25).getOrThrow()
        val dec21 = LocalDate(2020, 12, 21).getOrThrow()
        expect(dec21 + 4.days).toBe(dec25)
    }

    @Test
    fun should_be_able_to_add_days_that_would_result_into_different_years() {
        val dec25_2017 = LocalDate(2017, 12, 25).getOrThrow()
        val dec25_2018 = LocalDate(2018, 12, 25).getOrThrow()
        expect(dec25_2017 + 365.days).toBe(dec25_2018)

        val jan25_2019 = LocalDate(2019, 12, 25).getOrThrow()
        val jan25_2020 = LocalDate(2020, 12, 25).getOrThrow()
        expect(jan25_2019 + 366.days).toBe(jan25_2020)
    }

    @Test
    fun should_be_able_to_add_days_in_january() {
        val jan8 = LocalDate(2023, 1, 8).getOrThrow()
        val jan6 = LocalDate(2023, 1, 6).getOrThrow()
        expect(jan6 + 2.days).toBe(jan8)
    }

    @Test
    fun should_be_able_to_add_days_that_would_result_into_other_months() {
        val nov8 = LocalDate(2023, 11, 8).getOrThrow()
        val oct30 = LocalDate(2023, 10, 30).getOrThrow()
        expect(oct30 + 9.days).toBe(nov8)
    }

    @Test
    fun should_be_able_to_add_months() {
        val march1 = LocalDate(2020, 3, 1).getOrThrow()
        val jan1 = LocalDate(2020, 1, 1).getOrThrow()
        expect(jan1 + 2.months).toBe(march1)
    }

    @Test
    fun should_be_able_to_add_months_that_would_result_into_other_years() {
        val feb5 = LocalDate(2020, 2, 5).getOrThrow()
        val nov5 = LocalDate(2019, 11, 5).getOrThrow()
        expect(nov5 + 3.months).toBe(feb5)
    }

    @Test
    fun should_be_able_to_add_months_that_would_go_forward_more_than_one_year() {
        val feb5 = LocalDate(2020, 2, 5).getOrThrow()
        val nov5 = LocalDate(2018, 11, 5).getOrThrow()
        expect(nov5 + 15.months).toBe(feb5)
    }

    @Test
    fun should_be_able_to_add_fractional_months() {
        val march30 = LocalDate(2020, 3, 30).getOrThrow()
        val march15 = LocalDate(2020, 3, 15).getOrThrow()
        expect(march15 + 0.5.months).toBe(march30)
    }

    @Test
    fun should_be_able_to_add_in_hours() {
        val jan2 = LocalDate(2020, 1, 2).getOrThrow()
        val jan1 = LocalDate(2020, 1, 1).getOrThrow()
        expect(jan1 + 24.hours).toBe(jan2)
    }

    @Test
    fun ensure_no_infinite_loops_when_provided_very_low_values() {
        val jan2 = LocalDate(2020, 1, 2).getOrThrow()
        expect(jan2 + 0.5.hours).toBe(jan2)
    }

    @Test
    fun should_be_able_to_add_fractional_years() {
        val dec1 = LocalDate(2020, 12, 1).getOrThrow()
        val jun1 = LocalDate(2020, 6, 1).getOrThrow()
        expect(jun1 + 0.5.years).toBe(dec1)
    }

    @Test
    fun should_be_able_to_add_full_years() {
        val dec2020 = LocalDate(2020, 12, 25).getOrThrow()
        val dec2015 = LocalDate(2015, 12, 25).getOrThrow()
        expect(dec2015 + 5.years).toBe(dec2020)
    }
}