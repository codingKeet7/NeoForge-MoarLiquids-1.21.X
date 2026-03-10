package net.assortedpoultry.moarliquids.fluid;

import net.assortedpoultry.moarliquids.MoarLiquids;
import net.assortedpoultry.moarliquids.block.ModBlocks;
import net.assortedpoultry.moarliquids.fluid.custom.GoldFluid;
import net.assortedpoultry.moarliquids.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;



public class ModFluids {
    public static DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(BuiltInRegistries.FLUID, MoarLiquids.MOD_ID);

    public static final DeferredHolder<Fluid,BaseFlowingFluid.Source> GOLD_FLUID_SOURCE = FLUIDS.register("gold_fluid_source",
            () -> new GoldFluid.Source(createFluidProperties()));

    public static final DeferredHolder<Fluid,BaseFlowingFluid.Flowing> GOLD_FLUID_FLOWING = FLUIDS.register("gold_fluid_flowing",
            () -> new GoldFluid.Flowing(createFluidProperties()));

    private static BaseFlowingFluid.Properties createFluidProperties() {
        return new BaseFlowingFluid.Properties(
                ModFluidTypes.GOLD_FLUID_TYPE,
                GOLD_FLUID_SOURCE,
                GOLD_FLUID_FLOWING
        )
                .slopeFindDistance(2)
                .levelDecreasePerBlock(1)
                .block(()-> (LiquidBlock) ModBlocks.LIQUID_GOLD.get())
                .bucket(()->ModItems.BUCKET_OF_GOLD.get());
    }



    public static void register(IEventBus eventBus){
        ModFluids.FLUIDS.register(eventBus);
    }

}
