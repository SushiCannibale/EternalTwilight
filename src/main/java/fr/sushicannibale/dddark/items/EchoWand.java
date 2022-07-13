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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.sensing.WardenEntitySensor;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SculkSensorBlock;
import net.minecraft.world.level.block.entity.SculkSensorBlockEntity;
import net.minecraft.world.level.gameevent.EntityPositionSource;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEventListener;
import net.minecraft.world.level.gameevent.PositionSource;
import net.minecraft.world.level.gameevent.vibrations.VibrationListener;
import org.jetbrains.annotations.Nullable;


public class EchoWand extends Item implements VibrationListener.VibrationListenerConfig {

    private VibrationListener listener = new VibrationListener(new EntityPositionSource((Player)null, 0), this.listenerRange, this, (VibrationListener.ReceivingEvent)null, 0.0F, 0);

    private boolean isListening;
    public static final int ACTIVE_TICKS = 40;
    public static final int COOLDOWN_TICKS = 1;
    private final int listenerRange = 10;

    // TODO
    // Add the custom dimension that ca be opened by the wand


    public EchoWand(Properties properties) {
        super(properties);
        // Le listener n'est pas encore lié à une position

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
        if(entity instanceof ServerPlayer player) {
            if(isHandlingItem(player, itemstack)) {
                this.listener.listenerSource = new EntityPositionSource(player, 0.0f);
            }
        }
    }

    private static boolean isHandlingItem(final Player player, ItemStack itemstack) {
        return player.getMainHandItem() == itemstack || player.getOffhandItem() == itemstack;
    }

    @Override
    public boolean shouldListen(ServerLevel level, GameEventListener eventlistener, BlockPos pos, GameEvent gameevent, GameEvent.Context eventctx) {
        return true;
    }

    @Override
    public void onSignalReceive(ServerLevel level, GameEventListener eventlistener, BlockPos pos, GameEvent gameevent, @Nullable Entity entity1, @Nullable Entity entity2, float f) {
        System.out.println("Signal reçu !");
    }
}
