package net.goldengoose.moarliquidsmod.item;

import net.goldengoose.moarliquidsmod.MoarLiquidsMod;
import net.goldengoose.moarliquidsmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModTab {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MoarLiquidsMod.MOD_ID);

    public static final Supplier<CreativeModeTab> FLUIDS_TAB = TABS.register("fluids_tab",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.BUCKET_OF_GOLD.get()))
                    .title(Component.translatable("creativetab.moarliquids.fluids_tab"))
                    .displayItems((itemDisplayParameters,output) -> {
                        output.accept(ModItems.BUCKET_OF_GOLD.get());
                        output.accept(ModItems.BUCKET_OF_IRON.get());
                        output.accept(ModItems.BUCKET_OF_COPPER.get());
                        output.accept(ModItems.BUCKET_OF_DESPAIR.get());
                        output.accept(ModItems.BUCKET_OF_SLUDGE.get());

                    }).build());

    public static final Supplier<CreativeModeTab> NOT_FLUIDS_TAB = TABS.register("not_fluids_tab",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ModBlocks.PALLADIUM_BLOCK.get()))
                    .title(Component.translatable("creativetab.moarliquids.not_fluids_tab"))
                    .displayItems((itemDisplayParameters,output) -> {
                        output.accept(ModBlocks.PALLADIUM_BLOCK.get());
                    }).build());

    public static void register(IEventBus eventBus){
        TABS.register(eventBus);
    }
}