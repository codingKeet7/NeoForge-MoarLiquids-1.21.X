package net.goldengoose.moarliquidsmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;

public class MoltenLiquidBlock extends LiquidBlock {
    public MoltenLiquidBlock(FlowingFluid fluid, Properties properties) {
        super(fluid, properties);
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.setRemainingFireTicks(livingEntity.getRemainingFireTicks() + 1);

            livingEntity.hurt(level.damageSources().lava(), 4.0F);
        }
    }
}
