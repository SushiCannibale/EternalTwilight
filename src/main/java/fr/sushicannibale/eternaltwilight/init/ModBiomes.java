package fr.sushicannibale.eternaltwilight.init;

import fr.sushicannibale.eternaltwilight.EternalTwilightMod;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, EternalTwilightMod.MODID);

//    public static final RegistryObject<Biome> VOID_BIOME = register("void_biome", ());

    public static RegistryObject<Biome> register(String name, Supplier<? extends Biome> sup) {
        return BIOMES.register(name, sup);
    }
}
