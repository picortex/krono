package krono.serializers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import krono.LocalDate

@Serializer(forClass = LocalDate::class)
object LocalDateIsoSerializer : KSerializer<LocalDate> {
    override val descriptor = PrimitiveSerialDescriptor(
        serialName = "krono.LocalDate",
        kind = PrimitiveKind.STRING
    )

    override fun deserialize(decoder: Decoder): LocalDate = LocalDate(decoder.decodeString()).getOrThrow()

    override fun serialize(encoder: Encoder, value: LocalDate) = encoder.encodeString(value.toIsoString())
}