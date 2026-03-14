package net.goldengoose.moarliquidsmod.util;

import net.goldengoose.moarliquidsmod.MoarLiquidsMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class ModTags {
    public static class Blocks{



        private static TagKey<Block> createTag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(MoarLiquidsMod.MOD_ID,name));
        }
    }

    public static class Items{



        private static TagKey<Item> createTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(MoarLiquidsMod.MOD_ID,name));
        }
    }

    public static class Fluids{



        private static TagKey<Fluid> createTag(String name){
            return FluidTags.create(ResourceLocation.fromNamespaceAndPath(MoarLiquidsMod.MOD_ID,name));
        }
    }
}
