package fr.sushicannibale.eternaltwilight.datagen.tags;

import fr.sushicannibale.eternaltwilight.EternalTwilightMod;
import fr.sushicannibale.eternaltwilight.init.ModItems;
import fr.sushicannibale.eternaltwilight.init.ModTags;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ModItemTags extends ItemTagsProvider {

    public ModItemTags(DataGenerator generator, BlockTagsProvider p_126531_, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, p_126531_, EternalTwilightMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(ModTags.Items.VIBRATIONS_MUFFLERS).add(ModItems.WOOL_BOOTS.get());
    }
}
