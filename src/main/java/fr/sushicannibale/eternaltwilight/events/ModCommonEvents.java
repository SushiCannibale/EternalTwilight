package fr.sushicannibale.eternaltwilight.events;

import fr.sushicannibale.eternaltwilight.EternalTwilightMod;
import fr.sushicannibale.eternaltwilight.init.ModItems;
import fr.sushicannibale.eternaltwilight.init.ModTags;
import fr.sushicannibale.eternaltwilight.items.EchoWand;
import fr.sushicannibale.eternaltwilight.utils.PlayerUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.GameEventTags;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.VanillaGameEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = EternalTwilightMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.DEDICATED_SERVER)
public class ModCommonEvents {

    // TODO <EchoWand>
    // Tester si l'event est une vibration qui peut être captée
    // Si un joueur se trouve dans le rayon de recherche de l'item (appliqué à la position ça revient au même)
    // etc...


    @SubscribeEvent
    public static void onGameEvent(final VanillaGameEvent event) {
        if(event.getCause() instanceof ServerPlayer player
                && player.position().equals(event.getEventPosition()) // le hit_ground est call par les entity, pas forcément les living only
                && player.fallDistance <= player.getMaxFallDistance()) { // si le joueur prend des dégats, même avec des bottes ça détecte

            if(event.getVanillaEvent().is(ModTags.GameEvent.MUFFLABLE)) {
                for(ItemStack itemstack : player.getArmorSlots()) {
                    if(itemstack.is(ModTags.Items.VIBRATIONS_MUFFLERS)) {
                        event.setCanceled(true);
                        break;
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onVibrationOccurs(final VanillaGameEvent event) {
        if(event.getVanillaEvent().is(GameEventTags.VIBRATIONS)) {
            if(event.getCause() instanceof ItemEntity) {
                ItemEntity eitem = (ItemEntity)event.getCause();
                if(eitem.getItem().is(ModTags.Items.VIBRATIONS_MUFFLERS)) {
                    event.setCanceled(true);
                    return;
                }
            }
            final BlockPos pos = new BlockPos(event.getEventPosition());
            final int r = 8;
            final AABB bounds = new AABB(pos.getX() - r, pos.getY() - r, pos.getZ() - r,
                                         pos.getX() + r, pos.getY() + r, pos.getZ() + r);

            List<Player> players = PlayerUtils.getPlayersInAABB(bounds, event.getLevel());
            if(!players.isEmpty()) { // il y a au moins un joueur proche du lieu de la vibration

                for(Player player : players) { // check si tous les joueurs proches ont le wand en main
                    if(!player.position().equals(event.getEventPosition())) { // et que la vibration ne vient pas du joueur lui-même (sinon c'est trop facile)
                        List<ItemStack> hands = PlayerUtils.getItemInHands(player);

                        for(ItemStack itemstack : hands) {
                            if(itemstack.is(ModItems.ECHO_WAND.get())) {
                                CompoundTag tag = itemstack.hasTag() ? itemstack.getTag() : new CompoundTag();
                                tag.putInt(EchoWand.COMPOUND_NAME, tag.getInt(EchoWand.COMPOUND_NAME) + 1);
                                itemstack.setTag(tag);

//                                event.getLevel().playSound(null, player.position().x, player.position().y, player.position().z, SoundEvents.SCULK_CLICKING, SoundSource.PLAYERS, 1.0f, 1.0f);
//                                event.getLevel().addParticle(new ShriekParticleOption(10),
//                                        true, event.getEventPosition().x, event.getEventPosition().y + 4, event.getEventPosition().z, 1.0D, 0.0D, 0.0D);
                            }
                        }
                    }
                }
            }
        }
    }

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
