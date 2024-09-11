package plus.dragons.cfn.datastorage;

import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import plus.dragons.cfn.CreeperFireworkNext;

import java.util.function.Supplier;

public class CFNDataAttachments {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, CreeperFireworkNext.MODID);

    public static final Supplier<AttachmentType<FlowerNetworkPrivateStorageData>> FLOWER_NETWORK = ATTACHMENT_TYPES.register(
            "flower_network", () -> AttachmentType.builder(FlowerNetworkPrivateStorageData::create).serialize(FlowerNetworkPrivateStorageData.CODEC).build()
    );

    public static void keepPlayerData(final PlayerEvent.Clone event)
    {
        if (event.isWasDeath() && event.getOriginal().hasData(FLOWER_NETWORK)) {
            event.getEntity().setData(FLOWER_NETWORK, event.getOriginal().getData(FLOWER_NETWORK));
        }
    }
}
