package krono.serializers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import krono.Instant
import krono.internal.InstantImpl

@Serializer(forClass = Instant::class)
object InstantSerializer : KSerializer<Instant> {
    override val descriptor = PrimitiveSerialDescriptor("krono.Instant", PrimitiveKind.LONG)

    override fun deserialize(decoder: Decoder): Instant = InstantImpl(decoder.decodeLong() * 1000)

    override fun serialize(encoder: Encoder, value: Instant) = encoder.encodeLong(value.epochMilliSecondsAsLong)
}