package net.assortedpoultry.moarliquids.fluid;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import net.assortedpoultry.moarliquids.MoarLiquids;
import net.assortedpoultry.moarliquids.fluid.custom.MetalFluidType;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
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
import org.joml.Vector3f;

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
            () -> new MetalFluidType(FluidType.Properties.create()
                    .canSwim(false)
                    .canDrown(false)
                    .pathType(PathType.LAVA)
                    .adjacentPathType(null)
                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                    .lightLevel(1)
                    .density(5000)
                    .viscosity(8000)
                    .temperature(1500),
                    "gold_fluid",
                    new Vector3f(0.961f,0.8f,0.153f),
                    0.5f,
                    1.5f

            )
    );


    public static final DeferredHolder<FluidType,FluidType> IRON_FLUID_TYPE = FlUID_TYPES.register("iron_fluid",
            () -> new MetalFluidType(FluidType.Properties.create()
                    .canSwim(false)
                    .canDrown(false)
                    .pathType(PathType.LAVA)
                    .adjacentPathType(null)
                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                    .lightLevel(1)
                    .density(5000)
                    .viscosity(8000)
                    .temperature(1500),
                    "iron_fluid",
                    new Vector3f(0.812f,0.812f,0.812f),
                    0.5f,
                    1.5f

            )
    );

    public static final DeferredHolder<FluidType,FluidType> COPPER_FLUID_TYPE = FlUID_TYPES.register("copper_fluid",
            () -> new MetalFluidType(FluidType.Properties.create()
                    .canSwim(false)
                    .canDrown(false)
                    .pathType(PathType.LAVA)
                    .adjacentPathType(null)
                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                    .lightLevel(1)
                    .density(5000)
                    .viscosity(8000)
                    .temperature(1500),
                    "copper_fluid",
                    new Vector3f(0.698f,0.384f,0.278f),
                    0.5f,
                    1.5f

            )
    );

    public static final DeferredHolder<FluidType,FluidType> DESPAIR_FLUID_TYPE = FlUID_TYPES.register("despair_fluid",
            () -> new MetalFluidType(FluidType.Properties.create()
                    .canSwim(false)
                    .canDrown(false)
                    .pathType(PathType.LAVA)
                    .adjacentPathType(null)
                    .sound(SoundActions.BUCKET_FILL, SoundEvents.SOUL_SAND_BREAK)
                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.SOUL_SAND_BREAK)
                    .lightLevel(0)
                    .density(500000)
                    .viscosity(800000),
                    "despair_fluid",
                    new Vector3f(0,0,0),
                    0,
                    0f
            )
    );


    public static void register(IEventBus eventBus){
        FlUID_TYPES.register(eventBus);
    }

}


