package fr.sushicannibale.dddark.items;

import com.mojang.math.Vector3d;
import fr.sushicannibale.dddark.sounds.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.warden.SonicBoom;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.monster.warden.WardenAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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
                itemstack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(ctx.getHand()));
                level.playSound(player, pos, ModSounds.DEEP_PORTAL_OPEN.get(), SoundSource.BLOCKS, 1.0f, 0.5f);
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        Vec3 eye_pos = player.getEyePosition();
        Vec3 view_vec = player.getViewVector(1.0F);
        List<AABB> positions = new ArrayList<>();

//        System.out.println(view_vec);
        for(int i = 2; i < 10; i++) {
            final Vec3 delta_vec = view_vec.scale(i);
            positions.add(new AABB(eye_pos.x + delta_vec.x, eye_pos.y + delta_vec.y, eye_pos.z + delta_vec.z, 1.0D, 1.0D, 1.0D));
            level.addParticle(ParticleTypes.SONIC_BOOM, eye_pos.x + delta_vec.x, eye_pos.y + delta_vec.y, eye_pos.z + delta_vec.z, 1.0D, 0.0D, 0.0D);
        }

        level.playSound(player, player.getOnPos().above(), SoundEvents.WARDEN_SONIC_BOOM, SoundSource.PLAYERS, 2.0F, 1.0F);
        itemstack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));
        player.getCooldowns().addCooldown(this, player.isCreative() ? 0 : 200);

        for(AABB aabb : positions) {
            for(Entity entity : level.getEntities(null, aabb)) {
                if(!entity.is(player)) {
                    entity.push(view_vec.x * 2.5D, view_vec.y * 0.5D, view_vec.z * 2.5D);
                }
            }
        }

        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide);

    }
}
