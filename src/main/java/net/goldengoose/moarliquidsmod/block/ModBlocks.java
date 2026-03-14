package net.goldengoose.moarliquidsmod.block;

import net.goldengoose.moarliquidsmod.MoarLiquidsMod;
import net.goldengoose.moarliquidsmod.block.custom.HeavyLiquidBlock;
import net.goldengoose.moarliquidsmod.block.custom.MoltenLiquidBlock;
import net.goldengoose.moarliquidsmod.block.custom.SludgeBlock;
import net.goldengoose.moarliquidsmod.fluid.ModFluids;
import net.goldengoose.moarliquidsmod.item.ModItems;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MoarLiquidsMod.MOD_ID);


    public static final DeferredBlock<Block> PALLADIUM_BLOCK = registerBlock("palladium_block",
            ()-> new Block(BlockBehaviour.Properties.of()));

    public static final DeferredBlock<Block> LIQUID_GOLD = registerBlock("liquid_gold",
            ()-> new MoltenLiquidBlock(ModFluids.GOLD.source.get(),BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA)));
    public static final DeferredBlock<Block> LIQUID_IRON = registerBlock("liquid_iron",
            ()-> new MoltenLiquidBlock(ModFluids.IRON.source.get(),BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA)));
    public static final DeferredBlock<Block> LIQUID_COPPER = registerBlock("liquid_copper",
            ()-> new MoltenLiquidBlock(ModFluids.COPPER.source.get(),BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA)));

    public static final DeferredBlock<Block> LIQUID_DESPAIR = registerBlock("liquid_despair",
            ()-> new HeavyLiquidBlock(ModFluids.DESPAIR.source.get(),1,BlockBehaviour.Properties.ofFullCopy(Blocks.SOUL_SAND).liquid().speedFactor(0.00001f).noLootTable()));

    public static final DeferredBlock<Block> LIQUID_SLUDGE = registerBlock("liquid_sludge",
            ()-> new SludgeBlock(ModFluids.SLUDGE.source.get(), List.of(MobEffects.CONFUSION,MobEffects.POISON,MobEffects.MOVEMENT_SLOWDOWN), BlockBehaviour.Properties.of().liquid().noLootTable()));



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
