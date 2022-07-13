package fr.sushicannibale.eternaltwilight.datagen.loot;

import fr.sushicannibale.eternaltwilight.init.ModBlocks;
import fr.sushicannibale.eternaltwilight.init.ModItems;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLoot {

    @Override
    protected void addTables() {
        this.add(ModBlocks.VACUUM_LANTERN.get(), BlockLoot::createSingleItemTable);
        this.add(ModBlocks.ET_PORTAL_BLOCK.get(), noDrop());
        this.dropSelf(ModBlocks.VAPORIZED_LOG.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCK_REGISTRY.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
