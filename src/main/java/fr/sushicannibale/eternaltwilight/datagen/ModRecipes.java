package fr.sushicannibale.eternaltwilight.datagen;

import fr.sushicannibale.eternaltwilight.init.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class ModRecipes extends RecipeProvider {

    public ModRecipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> finishedRecipe) {
        ShapedRecipeBuilder.shaped(ModItems.WOOL_BOOTS.get())
                .define('W', Items.WHITE_WOOL)
                .pattern("W W")
                .pattern("W W")
                .unlockedBy("has_white_wool", inventoryTrigger(ItemPredicate.Builder.item().of(Items.WHITE_WOOL).build()))
                .save(finishedRecipe);

        ShapedRecipeBuilder.shaped(ModItems.ECHO_WAND.get())
                .define('A', Items.AMETHYST_SHARD)
                .define('E', Items.ECHO_SHARD)
                .define('N', Items.NETHERITE_INGOT)
                .pattern(" EN")
                .pattern(" AE")
                .pattern("A  ")
                .unlockedBy("has_shards_and_netherite", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.AMETHYST_SHARD, Items.ECHO_SHARD, Items.NETHERITE_INGOT).build()))
                .save(finishedRecipe);
    }

    @Override
    public String getName() {
        return "EternalTwilight Recipe Provider";
    }
}
