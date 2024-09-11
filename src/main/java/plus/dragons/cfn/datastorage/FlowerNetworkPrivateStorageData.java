package plus.dragons.cfn.datastorage;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.HashMap;
import java.util.Map;

public record FlowerNetworkPrivateStorageData(Map<Integer, ItemStackQueue> data) {

    public static final Codec<FlowerNetworkPrivateStorageData> CODEC = RecordCodecBuilder.create(instance->
        instance.group(
                Codec.unboundedMap(Codec.INT,ItemStackQueue.CODEC)
                        .fieldOf("data").forGetter(FlowerNetworkPrivateStorageData::data)
        ).apply(instance,FlowerNetworkPrivateStorageData::new)
    );

    public static FlowerNetworkPrivateStorageData create() {
        return new FlowerNetworkPrivateStorageData(new HashMap<>());
    }
}
