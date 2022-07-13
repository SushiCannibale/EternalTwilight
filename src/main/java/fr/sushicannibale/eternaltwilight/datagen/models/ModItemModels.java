package fr.sushicannibale.eternaltwilight.datagen.models;

import fr.sushicannibale.eternaltwilight.EternalTwilightMod;
import fr.sushicannibale.eternaltwilight.init.ModBlocks;
import fr.sushicannibale.eternaltwilight.init.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class ModItemModels extends ItemModelProvider {

    public ModItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, EternalTwilightMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.WOOL_BOOTS.get());
        basicHandheldItem(ModItems.ECHO_WAND.get());

        basicItemBlock("vacuum_lantern");
        // les logs / wood / planks pointent tj vers leur parent
//        withExistingParent("vaporized_log", new ResourceLocation(EternalTwilightMod.MODID, "models/block/vaporized_log"));


    }

    public ItemModelBuilder basicHandheldItem(Item item)
    {
        ResourceLocation resLoc = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item));
        return getBuilder(resLoc.toString())
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", new ResourceLocation(resLoc.getNamespace(), "item/" + resLoc.getPath()));
    }

    /* Cherche la texture dans <modid>/textures/item/... */
    /* Uniquement pour des blocks dont les textures ne sont pas leur propre model ! */
    public ItemModelBuilder basicItemBlock(String blockName) {
        return basicItem(new ResourceLocation(EternalTwilightMod.MODID, blockName));
    }
}
