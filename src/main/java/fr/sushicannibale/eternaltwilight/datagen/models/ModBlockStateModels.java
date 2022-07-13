package fr.sushicannibale.eternaltwilight.datagen.models;

import fr.sushicannibale.eternaltwilight.EternalTwilightMod;
import fr.sushicannibale.eternaltwilight.init.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateModels extends BlockStateProvider {

    public ModBlockStateModels(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, EternalTwilightMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        logBlock(ModBlocks.VAPORIZED_LOG.get());
    }
}
