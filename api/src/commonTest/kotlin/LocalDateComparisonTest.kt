import kommander.expect
import krono.LocalDate
import kotlin.test.Test

class LocalDateComparisonTest {
    @Test
    fun date_before_should_appear_as_lesser_in_equality_check() {
        val jan = LocalDate("2022-01-01").getOrThrow()
        val feb = LocalDate("2022-2-1").getOrThrow()
        expect(jan.isBefore(feb)).toBe(true, "Jan appears to be greater than feb")
    }

    @Test
    fun date_after_should_appear_as_bigger_in_equality_check() {
        val jan = LocalDate("2022-01-01").getOrThrow()
        val feb = LocalDate("2022-2-1").getOrThrow()
        expect(feb.isAfter(jan)).toBe(true, "Feb appears to be less than january")
    }
}