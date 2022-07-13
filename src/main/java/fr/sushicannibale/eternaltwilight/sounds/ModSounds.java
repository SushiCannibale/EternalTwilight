package fr.sushicannibale.eternaltwilight.sounds;

import fr.sushicannibale.eternaltwilight.EternalTwilightMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, EternalTwilightMod.MODID);

    public static final RegistryObject<SoundEvent> DEEP_PORTAL_OPEN = register("portal_open");

    public static RegistryObject<SoundEvent> register(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(EternalTwilightMod.MODID, name)));
    }
}
