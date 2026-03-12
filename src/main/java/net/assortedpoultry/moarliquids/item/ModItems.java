package net.assortedpoultry.moarliquids.item;

import net.assortedpoultry.moarliquids.MoarLiquids;
import net.assortedpoultry.moarliquids.fluid.ModFluids;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MoarLiquids.MOD_ID);

    public static final DeferredItem<Item> PALLADIUM = ITEMS.register("palladium",
            ()-> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BUCKET_OF_GOLD = ITEMS.register("bucket_of_gold",
            ()-> new BucketItem(ModFluids.GOLD.source.get(),new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> BUCKET_OF_IRON = ITEMS.register("bucket_of_iron",
            ()-> new BucketItem(ModFluids.IRON.source.get(),new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> BUCKET_OF_COPPER = ITEMS.register("bucket_of_copper",
            ()-> new BucketItem(ModFluids.COPPER.source.get(),new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final DeferredItem<Item> BUCKET_OF_DESPAIR = ITEMS.register("bucket_of_despair",
            ()-> new BucketItem(ModFluids.DESPAIR.source.get(),new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
