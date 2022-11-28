//import datetime.Date
//import krono.Month
//import datetime.serializers.DateSerializer
//import expect.expect
//import kotlinx.serialization.Serializable
//import kotlinx.serialization.decodeFromString
//import kotlinx.serialization.encodeToString
//import kotlinx.serialization.json.Json
//import kotlin.test.Test
//
//class DateSerializationTest {
//
//    @Test
//    fun should_encode_dates_to_valid_json() {
//        val date = Date(2022, 4, 8)
//        expect(Json.encodeToString(DateSerializer, date)).toBe(""""2022-04-08"""")
//    }
//
//    @Serializable
//    data class Person(val bday: Date)
//
//    @Test
//    fun should_encode_dates_when_used_as_member_fields() {
//        expect(Json.encodeToString(Person(Date(1994, 6, 1)))).toBe("""{"bday":"1994-06-01"}""")
//    }
//
//    @Test
//    fun should_decode_dates_when_used_as_member_fields() {
//        expect(Json.decodeFromString<Person>("""{"bday":"1994-06-01"}""")).toBe(Person(Date(1994, 6, 1)))
//    }
//
//    @Test
//    fun should_deserialize_dates_from_valid_json() {
//        val json = """"2022-04-08""""
//        val date = Json.decodeFromString(DateSerializer, json)
//        expect(date.dayOfMonth).toBe(8)
//        expect(date.month).toBe(Month.APRIL)
//        expect(date.year).toBe(2022)
//    }
//}