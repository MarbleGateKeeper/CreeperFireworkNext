package plus.dragons.cfn.datastorage;

import com.mojang.serialization.Codec;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ItemStackQueue extends LinkedList<ItemStack> {
    public ItemStackQueue(@NotNull Collection<? extends ItemStack> c) {
        super(c);
    }

    public List<ItemStack> toList(){
        return this;
    }

    public static ItemStackQueue toThis(List<ItemStack> list){
        return new ItemStackQueue(list);
    }

    public static final Codec<ItemStackQueue> CODEC = ItemStack.CODEC.listOf().xmap(ItemStackQueue::toThis,ItemStackQueue::toList);
}
