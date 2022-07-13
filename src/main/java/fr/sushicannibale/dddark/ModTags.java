package fr.sushicannibale.dddark;

import net.minecraft.client.Game;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.GameEventTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.gameevent.GameEvent;

public class ModTags {
    public static class Items {
        private static TagKey<Item> create(String name) {
            return ItemTags.create(new ResourceLocation(DeepDeepDarkMod.MODID, name));
        }

        private static TagKey<Item> createForge(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Blocks {

        private static TagKey<Block> create(String name) {
            return BlockTags.create(new ResourceLocation(DeepDeepDarkMod.MODID, name));
        }

        private static TagKey<Block> createForge(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class GameEvent {
        public static final TagKey<net.minecraft.world.level.gameevent.GameEvent> MUFFLED_VIBRATIONS = create("muffled_vibrations");

        private static TagKey<net.minecraft.world.level.gameevent.GameEvent> create(String name) {
            return TagKey.create(Registry.GAME_EVENT_REGISTRY, new ResourceLocation(DeepDeepDarkMod.MODID, name));
        }

    }

}
