package fr.sushicannibale.dddark.events;

import fr.sushicannibale.dddark.DeepDeepDarkMod;
import fr.sushicannibale.dddark.ModItems;
import net.minecraft.world.Container;
import net.minecraft.world.item.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = DeepDeepDarkMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.DEDICATED_SERVER)
public class ModCommonEvents {



//    @SubscribeEvent
//    public static void onBlockClicked(final PlayerInteractEvent.RightClickBlock event) {
//        if(!event.getWorld().isClientSide && event.getPlayer() != null) {
//            final Level level = event.getWorld();
//            final BlockPos pos = event.getPos();
//            final Player player = event.getPlayer();
//            final ItemStack lighter = event.getItemStack();
//
//            BlockState blockstate = level.getBlockState(pos);
//            if(blockstate.is(Blocks.REINFORCED_DEEPSLATE)) {
//                if(lighter.is(Items.STICK)) {
//                    System.out.println("Portail allumé");
//                }
//            }
//        }
//    }
//    @SubscribeEvent
//    public static void onSculkDetect() {
//
//    }
}
