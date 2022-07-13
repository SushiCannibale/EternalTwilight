package fr.sushicannibale.eternaltwilight.jei;

import fr.sushicannibale.eternaltwilight.EternalTwilightMod;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import net.minecraft.resources.ResourceLocation;

@JeiPlugin
public class JeiModPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(EternalTwilightMod.MODID, "jei_plugin");
    }

//    @Override
//    public void registerCategories(IRecipeCategoryRegistration registration) {
//        IModPlugin.super.registerCategories(registration);
//    }
}
