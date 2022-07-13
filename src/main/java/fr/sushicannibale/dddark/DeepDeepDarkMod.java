package fr.sushicannibale.dddark;

import fr.sushicannibale.dddark.events.ModCommonEvents;
import fr.sushicannibale.dddark.sounds.ModSounds;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.SculkSensorBlockEntity;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(DeepDeepDarkMod.MODID)
public class DeepDeepDarkMod
{

// net.minecraft.world.item.Items
// net.minecraft.world.level.block.Blocks
// net.minecraft.world.level.material.MaterialColor
// net.minecraft.tags.BlockTags
// net.minecraft.tags.ItemTags
// net.minecraft.world.item.enchantment.Enchantments
//
// net.minecraftforge.common.Tags

    public static final String MODID = "dddark";

    // TODO <Advanced>
    // Create the : "Eternal Shade" dimension

    // TODO <Advanced>
    // Add the "Corrupted" biome (WARDENS SHALLN'T BE INVOKED IN THEM) (No shriekers tho ;))

    // TODO <Advanced>
    // Add the "Deeply Corrupted" biome

    public static final CreativeModeTab DDDARK_TAB = new CreativeModeTab(MODID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ECHO_WAND.get());
        }
    };

    public DeepDeepDarkMod()
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


