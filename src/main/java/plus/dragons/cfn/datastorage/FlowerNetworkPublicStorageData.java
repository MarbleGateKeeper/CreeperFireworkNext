package plus.dragons.cfn.datastorage;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.world.level.saveddata.SavedData;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class FlowerNetworkPublicStorageData extends SavedData {

    Map<ColoredNamedChannel, ItemStackQueue> data;

    public static final Codec<FlowerNetworkPublicStorageData> CODEC = RecordCodecBuilder.create(instance->
            instance.group(
                    Codec.unboundedMap(ColoredNamedChannel.CODEC,ItemStackQueue.CODEC)
                            .fieldOf("data").forGetter(FlowerNetworkPublicStorageData::data)
            ).apply(instance,FlowerNetworkPublicStorageData::new)
    );

    public FlowerNetworkPublicStorageData(Map<ColoredNamedChannel, ItemStackQueue> data) {
        this.data = data;
    }

    public FlowerNetworkPublicStorageData() {
        this.data = new HashMap<>();
    }

    public Map<ColoredNamedChannel, ItemStackQueue> data(){
        return this.data;
    }

    @Override
    public @NotNull CompoundTag save(@NotNull CompoundTag compoundTag, @NotNull HolderLookup.Provider provider) {
        return (CompoundTag) CODEC.encodeStart(NbtOps.INSTANCE, this).getOrThrow();
    }

    public FlowerNetworkPublicStorageData create() {
        return new FlowerNetworkPublicStorageData();
    }

    public FlowerNetworkPublicStorageData load(@NotNull CompoundTag compoundTag, @NotNull HolderLookup.Provider provider) {
        return CODEC.parse(NbtOps.INSTANCE, compoundTag).getOrThrow();
    }
}
