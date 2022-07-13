package fr.sushicannibale.eternaltwilight;

import fr.sushicannibale.eternaltwilight.events.ModCommonEvents;
import fr.sushicannibale.eternaltwilight.init.ModBlocks;
import fr.sushicannibale.eternaltwilight.init.ModItems;
import fr.sushicannibale.eternaltwilight.sounds.ModSounds;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(EternalTwilightMod.MODID)
public class EternalTwilightMod
{

/* Behaviour */

// net.minecraft.world.item.Items
// net.minecraft.world.level.block.Blocks
// net.minecraft.world.level.material.MaterialColor
// net.minecraft.tags.BlockTags
// net.minecraft.tags.ItemTags
// net.minecraft.world.item.enchantment.Enchantments
//
// net.minecraftforge.common.Tags

/* Datagen */

// net.minecraft.data.loot.BlockLoot
// net.minecraft.data.recipes.RecipeProvider
// net.minecraftforge.client.model.generators.ItemModelProvider
// net.minecraftforge.client.model.generators.BlockStateProvider

/* WorldGen */

// net.minecraft.world.level.levelgen

// net.minecraft.world.level.dimension.DimensionDefaults
//
//

    public static final String MODID = "eternaltwilight";

    // TODO <Advanced>
    // Create the : "Eternal Shade" dimension

    // TODO <Advanced>
    // Add the "Corrupted" biome (WARDENS SHALLN'T BE INVOKED IN THEM) (No shriekers tho ;))

    // TODO <Advanced>
    // Add the "Deeply Corrupted" biome

    // TODO <Advanced>
    // Create entities that behaves like the warden (blinds, glittering blue, listening to vibrations, etc...)

    public static final CreativeModeTab DDDARK_TAB = new CreativeModeTab(MODID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ECHO_WAND.get());
        }
    };

    public EternalTwilightMod()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.BLOCK_REGISTRY.register(bus);
        ModItems.ITEM_REGISTRY.register(bus);
        ModSounds.SOUND_EVENTS.register(bus);

//        ModDimensions.printRegister();

        MinecraftForge.EVENT_BUS.register(ModCommonEvents.class);
//        FMLJavaModLoadingContext.get().getModEventBus().register(ModCommonEvents.class);
    }
}


