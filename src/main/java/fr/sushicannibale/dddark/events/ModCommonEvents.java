package fr.sushicannibale.dddark.events;

import fr.sushicannibale.dddark.DeepDeepDarkMod;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EndPortalFrameBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

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
}
