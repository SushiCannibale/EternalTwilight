package fr.sushicannibale.dddark.dimensions;

import fr.sushicannibale.dddark.DeepDeepDarkMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class ModDimensions {
    public static final ResourceKey<Level> DEEP_DARK_DIM_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(DeepDeepDarkMod.MODID, "dddark_dim"));

    public static final ResourceKey<DimensionType> DEEP_DARK_DIM_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY,
            new ResourceLocation(DeepDeepDarkMod.MODID, "dddark_dimtype"));

    public static void printRegister() {
        System.out.println("ModDimensions registered");
    }
}
