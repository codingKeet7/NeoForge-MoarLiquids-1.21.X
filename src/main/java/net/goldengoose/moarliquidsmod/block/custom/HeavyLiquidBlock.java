package net.goldengoose.moarliquidsmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.phys.Vec3;

public class HeavyLiquidBlock extends LiquidBlock {
    private final float WEIGHT;
    public HeavyLiquidBlock(FlowingFluid fluid, float weight, Properties properties) {
        super(fluid, properties);
        this.WEIGHT = weight;
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity livingEntity) {

            // 2. Pull the entity down (simulate weight/sinker)
            // Adjust -0.05 to change how "heavy" the liquid feels
            Vec3 currentMovement = livingEntity.getDeltaMovement();
            livingEntity.setDeltaMovement(currentMovement.x, currentMovement.y - WEIGHT, currentMovement.z);

            // 3. Optional: Slow down horizontal movement (viscosity)
            // Multiply X and Z by a value less than 1.0
            livingEntity.setDeltaMovement(entity.getDeltaMovement().multiply(0.9D, 1.0D, 0.9D));
        }
    }


}
