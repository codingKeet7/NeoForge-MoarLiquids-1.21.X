package net.assortedpoultry.moarliquids.fluid;

import net.assortedpoultry.moarliquids.MoarLiquids;
import net.assortedpoultry.moarliquids.block.ModBlocks;
import net.assortedpoultry.moarliquids.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(BuiltInRegistries.FLUID, MoarLiquids.MOD_ID);

    public static final FluidSet GOLD = new FluidSet("gold_fluid", ModFluidTypes.GOLD_FLUID_TYPE, () -> (LiquidBlock) ModBlocks.LIQUID_GOLD.get(), ModItems.BUCKET_OF_GOLD);
    public static final FluidSet IRON = new FluidSet("iron_fluid", ModFluidTypes.IRON_FLUID_TYPE, () -> (LiquidBlock) ModBlocks.LIQUID_IRON.get(), ModItems.BUCKET_OF_IRON);
    public static final FluidSet COPPER = new FluidSet("copper_fluid", ModFluidTypes.COPPER_FLUID_TYPE, () -> (LiquidBlock) ModBlocks.LIQUID_COPPER.get(), ModItems.BUCKET_OF_COPPER);
    public static final FluidSet DESPAIR = new FluidSet("despair_fluid", ModFluidTypes.DESPAIR_FLUID_TYPE, () -> (LiquidBlock) ModBlocks.LIQUID_DESPAIR.get(), ModItems.BUCKET_OF_DESPAIR);
    public static final FluidSet SLUDGE = new FluidSet("sludge_fluid", ModFluidTypes.SLUDGE_FLUID_TYPE, () -> (LiquidBlock) ModBlocks.LIQUID_SLUDGE.get(), ModItems.BUCKET_OF_SLUDGE);


    public static class FluidSet {
        public final DeferredHolder<Fluid, BaseFlowingFluid.Source> source;
        public final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> flowing;

        public FluidSet(String baseName, Supplier<? extends FluidType> type, Supplier<? extends LiquidBlock> block, Supplier<? extends Item> bucket) {
            // Register the source and flowing, passing lambdas that call OUR properties builder
            this.source = FLUIDS.register(baseName + "_source", () -> new BaseFlowingFluid.Source(makeProperties(type, block, bucket)));
            this.flowing = FLUIDS.register(baseName + "_flowing", () -> new BaseFlowingFluid.Flowing(makeProperties(type, block, bucket)));
        }

        // This method is called LATER when NeoForge actually builds the fluids
        private BaseFlowingFluid.Properties makeProperties(Supplier<? extends FluidType> type, Supplier<? extends LiquidBlock> block, Supplier<? extends Item> bucket) {
            // "this.source" and "this.flowing" will be fully initialized by the time this runs!
            return new BaseFlowingFluid.Properties(type, this.source, this.flowing)
                    .slopeFindDistance(2)
                    .levelDecreasePerBlock(1)
                    .block(block)
                    .bucket(bucket);
        }
    }

    public static void register(IEventBus eventBus){
        FLUIDS.register(eventBus);
    }
}