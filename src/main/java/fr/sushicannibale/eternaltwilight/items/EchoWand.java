package fr.sushicannibale.eternaltwilight.items;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;


/*** /!\ STAND-BY /!\ ***/


public class EchoWand extends Item {

    // TODO
    // Pouvoir stocker une quantité de vibrations dans l'itemstack
    // Pourquoi pas utiliser un même map que dans le SculkSensorBlock$VIBRATION_FREQUENCY_FOR_EVENT pour déterminer
    // la valeur de l'intensité de son a ajouter

    // TODO
    // Pouvoir renvoyer ce son avec un click droit plus ou moins chargé (voir le setup de l'arc)

    // TODO
    // Ajouter un système de cooldown d'utilisation du renvoi / capter le son

    // TODO
    // Ajouter le hover text de la qtt de vibrations enregistrées dans l'itemstack

    public static final String COMPOUND_NAME = "eternaltwilight.vibrations_count";
    private int vibrationsAmount;
    private final int maxVibrations;
    public EchoWand(Properties properties) {
        super(properties);
        this.vibrationsAmount = 0;
        this.maxVibrations = 10;
    }

    @Override
    public int getUseDuration(ItemStack itemstack) {
        return 6200;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if(!level.isClientSide) {
            this.loadData(itemstack);
            player.sendSystemMessage(Component.translatable("Quantité de vibrations : " + this.vibrationsAmount).withStyle(ChatFormatting.GRAY));

//            level.playSound(null, player.position().x, player.position().y, player.position().z, SoundEvents.SCULK_SHRIEKER_SHRIEK, SoundSource.AMBIENT, 1.0f, 1.0f);
//            level.addParticle(new ShriekParticleOption(10),
//                    player.position().x, player.position().y + 4, player.position().z, 0.0D, 0.0D, 0.0D);

        }

        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide);
    }

    @Override
    public void appendHoverText(ItemStack itemstack, @Nullable Level level, List<Component> components, TooltipFlag tooltipflag) {
        this.loadData(itemstack);
        components.add(Component.translatable("eternaltwilight.echo_wand.vibration_amount",
                this.colorMessageByAmount(this.vibrationsAmount),
                Component.translatable(Integer.toString(this.maxVibrations))).withStyle(ChatFormatting.GRAY));
    }

    /* Set la qtt de vibrations + set le listener */
    private void saveData(ItemStack itemstack) {
        CompoundTag tag = itemstack.hasTag() ? itemstack.getTag() : new CompoundTag();
        tag.putInt(COMPOUND_NAME, this.vibrationsAmount);
        itemstack.setTag(tag);
    }

    /* Récupère la qtt de vibrations + update le listener */
    private void loadData(ItemStack itemstack) {
        CompoundTag tag = itemstack.getTag();
        if (tag != null) {
            this.vibrationsAmount = tag.getInt(COMPOUND_NAME);
        }
    }

    private MutableComponent colorMessageByAmount(int amount) {
        final String str = Integer.toString(amount);
        if(amount <= this.maxVibrations / 4) {
            return Component.literal(str).withStyle(ChatFormatting.RED);
        } else if (amount <= this.maxVibrations / 2) {
            return Component.literal(str).withStyle(ChatFormatting.YELLOW);
        } else if (amount < this.maxVibrations) {
            return Component.literal(str).withStyle(ChatFormatting.DARK_GREEN);
        }
        return Component.literal(str).withStyle(ChatFormatting.GREEN);
    }
}
