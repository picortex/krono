import kommander.expect
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import krono.Instant
import krono.serializers.InstantSerializer
import kotlin.test.Test

class InstantIsoSerializerTest {

    @Test
    fun should_encode_an_instant_moment_to_valid_json() {
        val time = Instant(0)
        expect(Json.encodeToString(InstantSerializer, time)).toBe("0")
    }

    @Serializable
    data class Person(val alarm: Instant)

    @Test
    fun should_encode_instants_when_used_as_member_fields() {
        expect(Json.encodeToString(Person(Instant(1669852465558)))).toBe("""{"alarm":1669852465558}""")
    }

    @Test
    fun should_decode_dates_when_used_as_member_fields() {
        expect(Json.decodeFromString<Person>("""{"alarm":1669852465558}""")).toBe(Person(Instant(1669852465558)))
    }

    @Test
    fun should_deserialize_dates_from_valid_json() {
        val json = "1669852465558"
        val instant = Json.decodeFromString(InstantSerializer, json)
        expect(instant).toBe(Instant(1669852465558))
    }
}