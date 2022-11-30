import krono.Month
import krono.LocalDate
import expect.expect
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import krono.LocalDateIsoSerializer
import kotlin.test.Test

class LocalDateSerializationTest {

    @Test
    fun should_encode_dates_to_valid_json() {
        val date = LocalDate(2022, 4, 8)
        expect(Json.encodeToString(LocalDateIsoSerializer, date)).toBe(""""2022-04-08"""")
    }

    @Serializable
    data class Person(val bday: LocalDate)

    @Test
    fun should_encode_dates_when_used_as_member_fields() {
        expect(Json.encodeToString(Person(LocalDate(1994, 6, 1)))).toBe("""{"bday":"1994-06-01"}""")
    }

    @Test
    fun should_decode_dates_when_used_as_member_fields() {
        expect(Json.decodeFromString<Person>("""{"bday":"1994-06-01"}""")).toBe(Person(LocalDate(1994, 6, 1)))
    }

    @Test
    fun should_deserialize_dates_from_valid_json() {
        val json = """"2022-04-08""""
        val date = Json.decodeFromString(LocalDateIsoSerializer, json)
        expect(date.dayOfMonth).toBe(8)
        expect(date.month).toBe(Month.APRIL)
        expect(date.year).toBe(2022)
    }
}