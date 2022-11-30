package krono.serializers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import krono.LocalDate
import krono.LocalTime

@Serializer(forClass = LocalTime::class)
object LocalTimeIsoSerializer : KSerializer<LocalTime> {
    override val descriptor = PrimitiveSerialDescriptor(
        serialName = "krono.LocalTime",
        kind = PrimitiveKind.STRING
    )

    override fun deserialize(decoder: Decoder): LocalTime = LocalTime(decoder.decodeString())

    override fun serialize(encoder: Encoder, value: LocalTime) = encoder.encodeString(value.toIsoString())
}