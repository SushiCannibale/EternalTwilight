package fr.sushicannibale.dddark;

import fr.sushicannibale.dddark.dimensions.ModDimensions;
import fr.sushicannibale.dddark.events.ModCommonEvents;
import fr.sushicannibale.dddark.sounds.ModSounds;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(DeepDeepDarkMod.MODID)
public class DeepDeepDarkMod
{
    public static final String MODID = "dddark";

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

        ModDimensions.printRegister();

        MinecraftForge.EVENT_BUS.register(ModCommonEvents.class);
    }
}
