package fr.sushicannibale.dddark.items;

import net.minecraft.client.color.item.ItemColors;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.sensing.WardenEntitySensor;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

public class WoolBoots extends DyeableArmorItem {

//    final int DEFAULT_WHITE_WOOL_COLOR = 16383998; // Decimal value of #F9FFFE
    private final int START_COLOR;

    // TODO
    // Make the item repairable using wool

    // TODO
    // Add the muffling behaviour to the player movements only :
    // Walk, run, and jump (Maybe add a wool stepping sound effect on landing)

    // -> VibrationListener > receivingEvent > gameEvent
    // -> VibrationListener.Config(?) > isValidVibration(...)

    public WoolBoots(ArmorMaterial material, EquipmentSlot slot, int start_color, Properties properties) {
        super(material, slot, properties);
        START_COLOR = start_color;
        CauldronInteraction.WATER.put(this, CauldronInteraction.DYED_ITEM);
    }

    @Override
    public int getColor(ItemStack itemstack) {
        CompoundTag compoundtag = itemstack.getTagElement("display");
        return compoundtag != null && compoundtag.contains("color", 99) ? compoundtag.getInt("color") : START_COLOR; // MaterialColor.WOOL.col
    }
}
