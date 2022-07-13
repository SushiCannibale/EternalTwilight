package fr.sushicannibale.eternaltwilight.datagen;

import fr.sushicannibale.eternaltwilight.EternalTwilightMod;
import fr.sushicannibale.eternaltwilight.datagen.loot.ModBlockLootTables;
import fr.sushicannibale.eternaltwilight.datagen.models.ModBlockStateModels;
import fr.sushicannibale.eternaltwilight.datagen.models.ModItemModels;
import fr.sushicannibale.eternaltwilight.datagen.tags.ModBlockTags;
import fr.sushicannibale.eternaltwilight.datagen.tags.ModGameEventTags;
import fr.sushicannibale.eternaltwilight.datagen.tags.ModItemTags;
import fr.sushicannibale.eternaltwilight.init.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = EternalTwilightMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        ModBlockTags blockTagsInstance = new ModBlockTags(generator, fileHelper);

        generator.addProvider(true, new ModRecipes(generator));
        generator.addProvider(true, new ModLootTables(generator));
        generator.addProvider(true, new ModItemModels(generator, fileHelper));
//        generator.addProvider(true, blockTagsInstance);
        generator.addProvider(true, new ModBlockStateModels(generator, fileHelper)); // doit être généré avant les items

        generator.addProvider(true, new ModItemTags(generator, blockTagsInstance, fileHelper));
        generator.addProvider(true, new ModGameEventTags(generator, fileHelper));
    }
}
