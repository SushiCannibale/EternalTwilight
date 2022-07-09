package fr.sushicannibale.eternaltwilight.init;

import fr.sushicannibale.eternaltwilight.EternalTwilightMod;
import fr.sushicannibale.eternaltwilight.blocks.EternalTwilightPortalBlock;
import fr.sushicannibale.eternaltwilight.blocks.VacuumLanternBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCK_REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, EternalTwilightMod.MODID);


    public static final RegistryObject<Block> VACUUM_LANTERN = register("vacuum_lantern", () -> new VacuumLanternBlock(BlockBehaviour.Properties.of(Material.METAL)
            .requiresCorrectToolForDrops()
            .randomTicks()
            .strength(3.5F)
            .sound(SoundType.LANTERN)
            .lightLevel(VacuumLanternBlock.BRIGHTNESS)
            .noOcclusion()));

    public static final RegistryObject<Block> ET_PORTAL_BLOCK = registerBlockOnly("eternaltwilight_portal", () -> new EternalTwilightPortalBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_PORTAL)));

    public static <T extends Block> RegistryObject<T> registerBlockOnly(final String name, final Supplier<? extends T> block) {
        return BLOCK_REGISTRY.register(name, block);
    }

    public static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block) {
        final RegistryObject<T> object = registerBlockOnly(name, block);
        ModItems.register(name, () -> new BlockItem(object.get(), new Item.Properties().tab(EternalTwilightMod.DDDARK_TAB)));
        return object;
    }
}
