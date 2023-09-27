import kommander.expect
import krono.LocalDate
import kotlin.test.Test

class LocalDateFormatTest {
    @Test
    fun should_parse_string_to_local_date() {
        val date = LocalDate("2022-04-01").getOrThrow()
        expect(date.format("{DD}/{MM}/{YYYY}")).toBe("01/04/2022")
    }

    @Test
    fun should_parse_full_iso_string_to_local_date() {
        val date = LocalDate("2022-04-01T14:00").getOrThrow()
        expect(date.format("{DD}/{MM}/{YYYY}")).toBe("01/04/2022")
    }
}