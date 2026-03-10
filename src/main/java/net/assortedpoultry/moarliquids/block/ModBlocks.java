package net.assortedpoultry.moarliquids.block;

import net.assortedpoultry.moarliquids.MoarLiquids;
import net.assortedpoultry.moarliquids.fluid.ModFluids;
import net.assortedpoultry.moarliquids.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MoarLiquids.MOD_ID);


    public static final DeferredBlock<Block> PALLADIUM = registerBlock("palladium",
            ()-> new Block(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> LIQUID_GOLD = registerBlock("liquid_gold",
            ()-> new LiquidBlock(ModFluids.GOLD_FLUID_SOURCE.get(),BlockBehaviour.Properties.ofFullCopy(Blocks.WATER)));




    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
