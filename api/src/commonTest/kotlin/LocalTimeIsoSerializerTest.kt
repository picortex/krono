import kommander.expect
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import krono.LocalTime
import krono.serializers.LocalTimeIsoSerializer
import kotlin.test.Test

class LocalTimeIsoSerializerTest {

    @Test
    fun should_encode_23_20_12_to_valid_json() {
        val time = LocalTime(23, 20, 12).getOrThrow()
        expect(Json.encodeToString(LocalTimeIsoSerializer, time)).toBe(""""23:20:12"""")
    }

    @Serializable
    data class Person(val alarm: LocalTime)

    @Test
    fun should_encode_dates_when_used_as_member_fields() {
        expect(Json.encodeToString(Person(LocalTime(1, 6, 1).getOrThrow()))).toBe("""{"alarm":"01:06:01"}""")
    }

    @Test
    fun should_decode_dates_when_used_as_member_fields() {
        expect(Json.decodeFromString<Person>("""{"alarm":"01:06:01"}""")).toBe(Person(LocalTime(1, 6, 1).getOrThrow()))
    }

    @Test
    fun should_deserialize_dates_from_valid_json() {
        val json = """"23:20:12""""
        val time = Json.decodeFromString(LocalTimeIsoSerializer, json)
        expect(time.hour).toBe(23)
        expect(time.minute).toBe(20)
        expect(time.second).toBe(12)
        expect(time.nanosecond).toBe(0)
    }

    @Test
    fun should_not_encode_seconds_if_seconds_are_zero() {
        val time = LocalTime(3, 30).getOrThrow()
        expect(Json.encodeToString(LocalTimeIsoSerializer, time)).toBe(""""03:30"""")
    }

    @Test
    fun should_deserialize_shortened_json() {
        val json = """"23:20""""
        val time = Json.decodeFromString(LocalTimeIsoSerializer, json)
        expect(time.hour).toBe(23)
        expect(time.minute).toBe(20)
        expect(time.second).toBe(0)
        expect(time.nanosecond).toBe(0)
    }
}