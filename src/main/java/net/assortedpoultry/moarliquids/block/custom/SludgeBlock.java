package net.assortedpoultry.moarliquids.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;

import java.util.List;


public class SludgeBlock extends LiquidBlock {
    private final List<Holder<MobEffect>> EFFECTS;
    public SludgeBlock(FlowingFluid fluid, List<Holder<MobEffect>> effects, Properties properties) {
        super(fluid, properties);
        this.EFFECTS = effects;
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if(entity instanceof LivingEntity livingEntity){
            for (int i = 0; i < EFFECTS.size() - 1; i++) {
                livingEntity.addEffect(new MobEffectInstance( EFFECTS.get(i),1000), livingEntity);
            }

        }
    }
}
