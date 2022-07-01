package fr.sushicannibale.dddark.items;

import com.mojang.math.Vector3d;
import fr.sushicannibale.dddark.sounds.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEventListener;
import net.minecraft.world.level.gameevent.vibrations.VibrationListener;
import org.jetbrains.annotations.Nullable;


public class EchoWand extends Item implements VibrationListener.VibrationListenerConfig {

    public EchoWand(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext ctx) {
        final Player player = ctx.getPlayer();
        final BlockPos pos = ctx.getClickedPos();
        final Level level = ctx.getLevel();
        ItemStack itemstack = ctx.getItemInHand();

        if(player instanceof ServerPlayer) {
            if(level.getBlockState(pos).is(Blocks.REINFORCED_DEEPSLATE)) {
                itemstack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(ctx.getHand()));
                level.playSound(player, pos, SoundEvents.END_PORTAL_SPAWN, SoundSource.BLOCKS, 1.0f, 0.5f);
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public void inventoryTick(ItemStack itemstack, Level level, Entity entity, int slot, boolean flag) {
        if(entity instanceof Player player) {
            if(this.isHandlingItem(player, itemstack)) {
                System.out.println("Handling !");
                System.out.println("slot : " + slot);
                System.out.println("flag : " + flag);

            }
        }
    }

    private boolean isHandlingItem(final Player player, ItemStack itemstack) {
        return player.getMainHandItem() == itemstack || player.getOffhandItem() == itemstack;
    }

    @Override
    public boolean shouldListen(ServerLevel level, GameEventListener eventlistener, BlockPos pos, GameEvent gameevent, GameEvent.Context eventctx) {
        return true;
    }

    @Override
    public void onSignalReceive(ServerLevel level, GameEventListener eventlistener, BlockPos pos, GameEvent gameevent, @Nullable Entity entity1, @Nullable Entity entity2, float f) {

    }
}
