import krono.milliseconds
import kotlin.test.Test
import kommander.expect
import krono.days
import krono.hours
import krono.microseconds
import krono.minutes
import krono.months
import krono.seconds
import krono.weeks
import krono.years

class DurationTest {
    @Test
    fun should_convert_milliseconds_easily() {
        expect(3.milliseconds).toBe(3000.microseconds)
        expect(3000.microseconds).toBe(3.milliseconds)
    }

    @Test
    fun should_convert_minutes_into_seconds() {
        expect(2.minutes).toBe(120.seconds)
        expect(120.seconds).toBe(2.minutes)
    }

    @Test
    fun should_convert_minutes_into_hours() {
        expect(120.minutes).toBe(2.hours)
        expect(2.hours).toBe(120.minutes)
    }

    @Test
    fun should_convert_hours_into_days() {
        expect(2.hours).toBe(7_200_000.milliseconds)
        expect(2.hours).toBe(7200.seconds)
        expect(7_200_000.milliseconds).toBe(2.hours)
        expect(48.hours).toBe(2.days)
        expect(2.days).toBe(48.hours)
    }

    @Test
    fun should_convert_days_into_weeks() {
        expect(14.days).toBe(2.weeks)
        expect(3.weeks).toBe(21.days)
    }

    @Test
    fun should_be_able_to_convert_weeks() {
        expect(8.weeks).toBe(2.months)
        expect(2.months).toBe(8.weeks)
    }

    @Test
    fun should_be_able_to_convert_months() {
        expect(2.months).toBe(8.weeks)
        expect(12.weeks).toBe(3.months)
        expect(2.months).toBe(60.days)
        expect(90.days).toBe(3.months)
        expect(24.months).toBe(2.years)
        expect(3.years).toBe(36.months)
    }

    @Test
    fun should_return_relative_string() {
        expect(1.days.toRelativeString()).toBe("a day")
        expect(2.days.toRelativeString()).toBe("2 days")
        expect(32.minutes.toRelativeString()).toBe("32 minutes")
        expect(14.days.toRelativeString()).toBe("2 weeks")
        expect(59.seconds.toRelativeString()).toBe("59 seconds")
        expect(60.seconds.toRelativeString()).toBe("a minute")
    }
}