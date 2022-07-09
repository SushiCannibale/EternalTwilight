package fr.sushicannibale.eternaltwilight.init;

import fr.sushicannibale.eternaltwilight.EternalTwilightMod;
import fr.sushicannibale.eternaltwilight.items.EchoWand;
import fr.sushicannibale.eternaltwilight.items.WoolBoots;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, EternalTwilightMod.MODID);

    public static final RegistryObject<Item> ECHO_WAND = register("echo_wand", () -> new EchoWand(new Item.Properties()
            .tab(EternalTwilightMod.DDDARK_TAB)
            .defaultDurability(6)
            .rarity(Rarity.RARE)
            .fireResistant()));

    public static final RegistryObject<Item> WOOL_BOOTS = register("wool_boots",
            () -> new WoolBoots(ModArmorMaterials.WOOL, EquipmentSlot.FEET, 16383998, new Item.Properties()
            .tab(EternalTwilightMod.DDDARK_TAB)));

    public static <T extends Item> RegistryObject<T> register(final String name, final Supplier<? extends T> supplier) {
        return ITEM_REGISTRY.register(name, supplier);
    }
}
