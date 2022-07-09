package fr.sushicannibale.eternaltwilight.events;

import fr.sushicannibale.eternaltwilight.EternalTwilightMod;
import fr.sushicannibale.eternaltwilight.init.ModBlocks;
import fr.sushicannibale.eternaltwilight.init.ModItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = EternalTwilightMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void registerColor(final ColorHandlerEvent.Item event) {
        event.getItemColors().register((itemstack, tintIndex) -> {
            return tintIndex > 0 ? -1 : ((DyeableLeatherItem)itemstack.getItem()).getColor(itemstack);
        }, ModItems.WOOL_BOOTS.get());
    }

    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.VACUUM_LANTERN.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ET_PORTAL_BLOCK.get(), RenderType.translucent());
    }
}
