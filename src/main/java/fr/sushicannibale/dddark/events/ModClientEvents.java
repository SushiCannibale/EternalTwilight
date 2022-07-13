package fr.sushicannibale.dddark.events;

import fr.sushicannibale.dddark.DeepDeepDarkMod;
import fr.sushicannibale.dddark.ModBlocks;
import fr.sushicannibale.dddark.ModItems;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = DeepDeepDarkMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
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
    }
}
