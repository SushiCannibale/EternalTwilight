package fr.sushicannibale.eternaltwilight.world.dimensions;

import fr.sushicannibale.eternaltwilight.EternalTwilightMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraftforge.registries.ForgeRegistries;

public class ModDimensions {
    public static final ResourceKey<Level> ETERNAL_TWILIGHT_DIMENSION = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(EternalTwilightMod.MODID, "et_dim"));

//    public static final ResourceKey<DimensionType> ETERNAL_TWILIGHT_DIMTYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY,
//            new ResourceLocation(EternalTwilightMod.MODID, "et_dimtype"));

    public static void register() {
        System.out.println("Biome + BiomeType registered !");
    }
}
