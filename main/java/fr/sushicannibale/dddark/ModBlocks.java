package fr.sushicannibale.dddark;

import net.minecraft.data.worldgen.placement.NetherPlacements;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.NetherPortalBlock;
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

    public static <T extends Block> RegistryObject<T> registerBlockOnly(final String name, final Supplier<? extends T> block) {
        return BLOCK_REGISTRY.register(name, block);
    }

    public static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block, Function<RegistryObject<T>, Supplier<? extends Item>> item) {
        final RegistryObject<T> object = registerBlockOnly(name, block);
        ModItems.register(name, item.apply(object));
        return object;
    }
}
