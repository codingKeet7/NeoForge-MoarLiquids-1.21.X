package net.assortedpoultry.moarliquids.datagen;

import net.assortedpoultry.moarliquids.MoarLiquids;
import net.assortedpoultry.moarliquids.fluid.ModFluids;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.FluidTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModFluidTagProvider extends FluidTagsProvider {
    public ModFluidTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, MoarLiquids.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(FluidTags.LAVA)
                .add(ModFluids.GOLD.source.get())
                .add(ModFluids.GOLD.flowing.get())
                .add(ModFluids.IRON.source.get())
                .add(ModFluids.IRON.flowing.get())
                .add(ModFluids.COPPER.source.get())
                .add(ModFluids.COPPER.flowing.get());
    }
}
