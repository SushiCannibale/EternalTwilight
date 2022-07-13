package fr.sushicannibale.dddark;

import net.minecraft.data.worldgen.placement.NetherPlacements;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCK_REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, DeepDeepDarkMod.MODID);


    public static final RegistryObject<Block> VACUUM_LANTERN = register("vacuum_lantern", () -> new LanternBlock(BlockBehaviour.Properties.of(Material.METAL)
            .requiresCorrectToolForDrops()
            .strength(3.5F)
            .sound(SoundType.LANTERN)
            .lightLevel((level) -> {
        return 7;
    }).noOcclusion()));



    public static <T extends Block> RegistryObject<T> registerBlockOnly(final String name, final Supplier<? extends T> block) {
        return BLOCK_REGISTRY.register(name, block);
    }

    public static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block) {
        final RegistryObject<T> object = registerBlockOnly(name, block);
        ModItems.register(name, () -> new BlockItem(object.get(), new Item.Properties().tab(DeepDeepDarkMod.DDDARK_TAB)));
        return object;
    }
}
