package net.assortedpoultry.moarliquids.datagen;

import net.assortedpoultry.moarliquids.MoarLiquids;
import net.assortedpoultry.moarliquids.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output,  ExistingFileHelper existingFileHelper) {
        super(output, MoarLiquids.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.BUCKET_OF_GOLD.get());
        basicItem(ModItems.BUCKET_OF_IRON.get());
        basicItem(ModItems.BUCKET_OF_COPPER.get());
        basicItem(ModItems.BUCKET_OF_DESPAIR.get());
        basicItem(ModItems.BUCKET_OF_SLUDGE.get());
        basicItem(ModItems.PALLADIUM.get());
    }
}
