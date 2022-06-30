package fr.sushicannibale.dddark.items;

import fr.sushicannibale.dddark.sounds.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

public class EchoWand extends Item {

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
                itemstack.hurtAndBreak(1, player, (p) -> {
                    p.broadcastBreakEvent(ctx.getHand());
                });
                level.playSound(player, pos, ModSounds.DEEP_PORTAL_OPEN.get(), SoundSource.BLOCKS, 1.0f, 0.5f);
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
