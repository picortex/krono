package krono.serializers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import krono.LocalDateTime

@Serializer(forClass = LocalDateTime::class)
object LocalDateTimeIsoSerializer : KSerializer<LocalDateTime> {
    override val descriptor = PrimitiveSerialDescriptor(
        serialName = "krono.LocalDateTime",
        kind = PrimitiveKind.STRING
    )

    override fun deserialize(decoder: Decoder): LocalDateTime = LocalDateTime(decoder.decodeString()).getOrThrow()

    override fun serialize(encoder: Encoder, value: LocalDateTime) {
        var str = value.toIsoString()
        while (str.endsWith(":00") && str.split(":").size > 2) {
            str = str.split(":").dropLast(1).joinToString(":")
        }
        encoder.encodeString(str)
    }
}