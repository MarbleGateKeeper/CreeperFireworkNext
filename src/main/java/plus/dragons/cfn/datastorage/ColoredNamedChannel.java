package plus.dragons.cfn.datastorage;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record ColoredNamedChannel(int rgb, String name) {
    public static final Codec<ColoredNamedChannel> CODEC = RecordCodecBuilder.create(instance->
            instance.group(
                    Codec.INT.fieldOf("rgb").forGetter(ColoredNamedChannel::rgb),
                    Codec.STRING.fieldOf("name").forGetter(ColoredNamedChannel::name)
            ).apply(instance,ColoredNamedChannel::new)
    );
}
