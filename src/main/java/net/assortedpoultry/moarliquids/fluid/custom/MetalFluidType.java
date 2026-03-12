package net.assortedpoultry.moarliquids.fluid.custom;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import net.assortedpoultry.moarliquids.MoarLiquids;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidType;
import org.joml.Vector3f;

import java.util.function.Consumer;

public class MetalFluidType extends FluidType {
    /**
     * Default constructor.
     *
     * @param properties the general properties of the fluid type
     */
    private final ResourceLocation STILL;
    private final ResourceLocation FLOW;
    private final Vector3f COLOR;
    private final Float FOG_START;
    private final Float FOG_END;
    public MetalFluidType(Properties properties, String name, Vector3f color,  float fogStart, float fogEnd) {
        super(properties);
        this.STILL = ResourceLocation.fromNamespaceAndPath(MoarLiquids.MOD_ID, "block/"+ name +"_still");
        this.FLOW = ResourceLocation.fromNamespaceAndPath(MoarLiquids.MOD_ID, "block/"+ name +"_flow");
        this.COLOR = color;
        this.FOG_START = fogStart;
        this.FOG_END = fogEnd;
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {

            @Override
            public ResourceLocation getStillTexture() {
                return STILL;
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return FLOW;
            }

            @Override
            public Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
                return COLOR;
            }

            @Override
            public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, FogShape shape) {
                RenderSystem.setShaderFogStart(FOG_START);
                RenderSystem.setShaderFogEnd(FOG_END);

            }
        });
    }
}
