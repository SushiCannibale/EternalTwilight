package fr.sushicannibale.eternaltwilight.utils;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.ArrayList;
import java.util.List;

public class PlayerUtils {
    public static List<ItemStack> getItemInHands(Player player) {
        List<ItemStack> list = new ArrayList<>(2);
        list.add(player.getItemInHand(InteractionHand.MAIN_HAND));
        list.add(player.getItemInHand(InteractionHand.OFF_HAND));
        return list;
    }

    public static List<Player> getPlayersInAABB(AABB aabb, Level level) {
        return level.getEntitiesOfClass(Player.class, aabb);
    }
}
