package net.assortedpoultry.moarliquids.datagen;

import net.assortedpoultry.moarliquids.block.ModBlocks;
import net.assortedpoultry.moarliquids.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.PALLADIUM.get(),9)
//                .requires(ModBlocks.PALLADIUM_BLOCK)
//                .unlockedBy("has_palladium_block",has(ModBlocks.PALLADIUM_BLOCK));
        reversibleBlock(ModBlocks.PALLADIUM_BLOCK.get(),ModItems.PALLADIUM.get(),9,recipeOutput);
    }

    private void reversibleBlock(Block block, Item item, int count,RecipeOutput output){

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS,item,count)
                .requires(block)
                .unlockedBy("has_"+block.toString(),has(block))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,block)
                .pattern("aaa")
                .pattern("aaa")
                .pattern("aaa")
                .define('a',item)
                .unlockedBy("has_"+item.toString(),has(item))
                .save(output);
    }
}
