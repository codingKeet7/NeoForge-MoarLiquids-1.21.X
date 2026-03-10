package net.assortedpoultry.moarliquids.fluid;

import net.assortedpoultry.moarliquids.MoarLiquids;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.pathfinder.PathType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Consumer;

public class ModFluidTypes extends FluidType {
    /**
     * Default constructor.
     *
     * @param properties the general properties of the fluid type
     */
    public ModFluidTypes(Properties properties) {
        super(properties);
    }

    public static DeferredRegister<FluidType> FlUID_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, MoarLiquids.MOD_ID);


    public static final DeferredHolder<FluidType,FluidType> GOLD_FLUID_TYPE = FlUID_TYPES.register("gold_fluid",
            () -> new FluidType(FluidType.Properties.create()
                    .canSwim(false)
                    .canDrown(false)
                    .pathType(PathType.LAVA)
                    .adjacentPathType(null)
                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                    .lightLevel(10)
                    .density(5000)
                    .viscosity(8000)
                    .temperature(1500)
                    // Add custom sounds, pathfinding logic, etc., here
            ){
                @Override
                public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
                    consumer.accept(new IClientFluidTypeExtensions() {
                        private static final ResourceLocation STILL = ResourceLocation.fromNamespaceAndPath(MoarLiquids.MOD_ID, "block/gold_fluid_still");
                        private static final ResourceLocation FLOWING = ResourceLocation.fromNamespaceAndPath(MoarLiquids.MOD_ID, "block/gold_fluid_flow");

                        @Override
                        public ResourceLocation getStillTexture() { return STILL; }

                        @Override
                        public ResourceLocation getFlowingTexture() { return FLOWING; }
                    });
                }
            }
    );


    public static void register(IEventBus eventBus){
        FlUID_TYPES.register(eventBus);
    }

}


