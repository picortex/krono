package krono.serializers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import krono.LocalTime

@Serializer(forClass = LocalTime::class)
object LocalTimeIsoSerializer : KSerializer<LocalTime> {
    override val descriptor = PrimitiveSerialDescriptor(
        serialName = "krono.LocalTime",
        kind = PrimitiveKind.STRING
    )

    override fun deserialize(decoder: Decoder): LocalTime = LocalTime(decoder.decodeString()).getOrThrow()

    override fun serialize(encoder: Encoder, value: LocalTime) {
        var str = value.toIsoString()
        while (str.endsWith(":00") && str.split(":").size > 2) {
            str = str.split(":").dropLast(1).joinToString(":")
        }
        encoder.encodeString(str)
    }
}