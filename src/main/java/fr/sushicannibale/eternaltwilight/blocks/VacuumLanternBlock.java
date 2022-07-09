package fr.sushicannibale.eternaltwilight.blocks;

import fr.sushicannibale.eternaltwilight.utils.PlayerUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;

import java.util.function.ToIntFunction;

public class VacuumLanternBlock extends LanternBlock {

    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final ToIntFunction<BlockState> BRIGHTNESS = (blockstate) -> blockstate.getValue(LIT) ? 15 : 4;

    private static final int EFFECT_RADIUS = 2;
    public VacuumLanternBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(LIT, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(LIT);
    }

    @Override
    public InteractionResult use(BlockState blockstate, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        ItemStack itemstack = player.getItemInHand(hand);

        if(level.isClientSide) {
            if(itemstack.isEmpty() && this.isLit(blockstate)) {
                level.playLocalSound(pos.getX() + 0.5D, pos.getY() + 0.35D, pos.getZ() + 0.5D, SoundEvents.CANDLE_EXTINGUISH, SoundSource.BLOCKS, 1.0F, 1.0F, false);
                return InteractionResult.SUCCESS;
            } else if(itemstack.is(Items.FLINT_AND_STEEL) && !this.isLit(blockstate)) {
                level.playLocalSound(pos.getX() + 0.5D, pos.getY() + 0.35D, pos.getZ() + 0.5D, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
                return InteractionResult.SUCCESS;
            }
        } else {
            if(itemstack.isEmpty() && this.isLit(blockstate)) {
                level.setBlock(pos, blockstate.setValue(LIT, false), 3);

            } else if(itemstack.is(Items.FLINT_AND_STEEL) && !this.isLit(blockstate)) {
                level.setBlock(pos, blockstate.setValue(LIT, true), 3);
            }
        }
        return super.use(blockstate, level, pos, player, hand, result);
    }

    @Override
    public void animateTick(BlockState blockstate, Level level, BlockPos pos, RandomSource random) { // random btw 0 & 1
        if(!this.isLit(blockstate)) {
            return;
        }

        final float f = random.nextFloat();
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();

        if(f < 0.17F) {
            level.playLocalSound(x + 0.5D, y + 0.35D, z + 0.5D, SoundEvents.CANDLE_AMBIENT, SoundSource.BLOCKS, 1.0F + random.nextFloat(), random.nextFloat() * 0.7F + 0.3F, false);
        }

        level.addParticle(ParticleTypes.SMALL_FLAME, x + 0.5D, y + 0.37D, z + 0.5D, 0.0D, 0.0D, 0.0D);

    }

    private boolean isLit(BlockState blockstate) {
        return blockstate.hasProperty(LIT) && blockstate.getValue(LIT);
    }

//    public static void applyDarkness(Level level, BlockPos pos) {
//        AABB aabb = new AABB(pos.getX() - EFFECT_RADIUS, pos.getY() - EFFECT_RADIUS, pos.getZ() - EFFECT_RADIUS,
//                pos.getX() + EFFECT_RADIUS, pos.getY() + EFFECT_RADIUS, pos.getZ() + EFFECT_RADIUS);
//
//        PlayerUtils.getPlayersInAABB(aabb, level).forEach((player) -> {
//            player.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 20 * 4, 0));
//        });
//    }
}
