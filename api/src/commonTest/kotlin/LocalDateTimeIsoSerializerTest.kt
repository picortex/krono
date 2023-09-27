import kommander.expect
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import krono.LocalDateTime
import krono.Month
import krono.serializers.LocalDateTimeIsoSerializer
import kotlin.test.Test

class LocalDateTimeIsoSerializerTest {

    @Test
    fun should_encode_2022_4_8_properly() {
        val dt = LocalDateTime(2022, 4, 8).getOrThrow()
        expect(Json.encodeToString(LocalDateTimeIsoSerializer, dt)).toBe(""""2022-04-08T00:00"""")
    }

    @Serializable
    data class Person(val bday: LocalDateTime)

    @Test
    fun should_encode_dates_when_used_as_member_fields() {
        expect(Json.encodeToString(Person(LocalDateTime(1994, 6, 1).getOrThrow()))).toBe("""{"bday":"1994-06-01T00:00"}""")
    }

    @Test
    fun should_decode_dates_when_used_as_member_fields() {
        expect(Json.decodeFromString<Person>("""{"bday":"1994-06-01T00:00"}""")).toBe(Person(LocalDateTime(1994, 6, 1).getOrThrow()))
    }

    @Test
    fun should_deserialize_dates_from_valid_json() {
        val json = """"2022-04-08""""
        val dt = Json.decodeFromString(LocalDateTimeIsoSerializer, json)
        expect(dt.dayOfMonth).toBe(8)
        expect(dt.month).toBe(Month.APRIL)
        expect(dt.year).toBe(2022)
        expect(dt.hour).toBe(0)
        expect(dt.minute).toBe(0)
        expect(dt.second).toBe(0)
        expect(dt.nanosecond).toBe(0)
    }

    @Test
    fun should_deserialize_date_times_from_valid_json() {
        val json = """"2022-04-08T23:45""""
        val dt = Json.decodeFromString(LocalDateTimeIsoSerializer, json)
        expect(dt.dayOfMonth).toBe(8)
        expect(dt.month).toBe(Month.APRIL)
        expect(dt.year).toBe(2022)
        expect(dt.hour).toBe(23)
        expect(dt.minute).toBe(45)
        expect(dt.second).toBe(0)
        expect(dt.nanosecond).toBe(0)
    }
}