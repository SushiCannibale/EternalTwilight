package fr.sushicannibale.eternaltwilight.datagen.tags;

import fr.sushicannibale.eternaltwilight.EternalTwilightMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ModBlockTags extends BlockTagsProvider {

    public ModBlockTags(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, EternalTwilightMod.MODID, existingFileHelper);
    }
}
