package fr.sushicannibale.eternaltwilight.datagen.tags;

import fr.sushicannibale.eternaltwilight.EternalTwilightMod;
import fr.sushicannibale.eternaltwilight.init.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.GameEventTagsProvider;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ModGameEventTags extends GameEventTagsProvider {

    public ModGameEventTags(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, EternalTwilightMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(ModTags.GameEvent.MUFFLABLE).add(GameEvent.HIT_GROUND, GameEvent.STEP);
    }
}
