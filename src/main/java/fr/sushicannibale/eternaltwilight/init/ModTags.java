package fr.sushicannibale.eternaltwilight.init;

import fr.sushicannibale.eternaltwilight.EternalTwilightMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Items {

        public static final TagKey<Item> VIBRATIONS_MUFFLERS = create("vibrations_mufflers");

        private static TagKey<Item> create(String name) {
            return ItemTags.create(new ResourceLocation(EternalTwilightMod.MODID, name));
        }

        private static TagKey<Item> createForge(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Blocks {

        private static TagKey<Block> create(String name) {
            return BlockTags.create(new ResourceLocation(EternalTwilightMod.MODID, name));
        }

        private static TagKey<Block> createForge(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class GameEvent {
        public static final TagKey<net.minecraft.world.level.gameevent.GameEvent> MUFFLABLE = create("mufflable");

        private static TagKey<net.minecraft.world.level.gameevent.GameEvent> create(String name) {
            return TagKey.create(Registry.GAME_EVENT_REGISTRY, new ResourceLocation(EternalTwilightMod.MODID, name));
        }
    }
}
