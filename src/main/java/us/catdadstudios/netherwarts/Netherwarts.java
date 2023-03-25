package us.catdadstudios.netherwarts;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;


public class Netherwarts implements ModInitializer {

    //
    //Wand Base
    //
    public static final Item WAND_BASE =
            Registry.register(Registries.ITEM, new Identifier("netherwarts", "wand_base"),
                    new WandBase(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON)));
    //
    //Wand Tips
    //
    public static final Item STONE_WAND_TIP =
            Registry.register(Registries.ITEM, new Identifier("netherwarts", "stone_wand_tip"),
                    new WandTip(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON)));
    public static final Item COPPER_WAND_TIP =
            Registry.register(Registries.ITEM, new Identifier("netherwarts", "copper_wand_tip"),
                    new WandTip(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON)));
    public static final Item IRON_WAND_TIP =
            Registry.register(Registries.ITEM, new Identifier("netherwarts", "iron_wand_tip"),
                    new WandTip(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item LAPIS_WAND_TIP =
            Registry.register(Registries.ITEM, new Identifier("netherwarts", "lapis_wand_tip"),
                    new WandTip(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item GOLD_WAND_TIP =
            Registry.register(Registries.ITEM, new Identifier("netherwarts", "gold_wand_tip"),
                    new WandTip(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item EMERALD_WAND_TIP =
            Registry.register(Registries.ITEM, new Identifier("netherwarts", "emerald_wand_tip"),
                    new WandTip(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item NETHERITE_WAND_TIP =
            Registry.register(Registries.ITEM, new Identifier("netherwarts", "netherite_wand_tip"),
                    new WandTip(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC)));
    public static final Item DIAMOND_WAND_TIP =
            Registry.register(Registries.ITEM, new Identifier("netherwarts", "diamond_wand_tip"),
                    new WandTip(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC)));
    //
    //Wands
    //
    public static final Item WITHERSKELETON_WAND_CORE =
            Registry.register(Registries.ITEM, new Identifier("netherwarts", "witherskeleton_wand_core"),
                    new WandCoreWither(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item BLAZE_WAND_CORE =
            Registry.register(Registries.ITEM, new Identifier("netherwarts", "blaze_wand_core"),
                    new WandCoreBlaze(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item PIGLIN_WAND_CORE =
            Registry.register(Registries.ITEM, new Identifier("netherwarts", "piglin_wand_core"),
                    new WandCorePiglin(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    //
    //Wands
    //
    public static final Item STONE_WAND =
            Registry.register(Registries.ITEM, new Identifier("netherwarts", "stone_wand"),
                    new Wand(new FabricItemSettings().maxCount(1).maxDamage(1000).rarity(Rarity.COMMON)));
    public static final Item COPPER_WAND =
            Registry.register(Registries.ITEM, new Identifier("netherwarts", "copper_wand"),
                    new Wand(new FabricItemSettings().maxCount(1).maxDamage(1000).rarity(Rarity.COMMON)));
    public static final Item IRON_WAND =
            Registry.register(Registries.ITEM, new Identifier("netherwarts", "iron_wand"),
                    new Wand(new FabricItemSettings().maxCount(1).maxDamage(1000).rarity(Rarity.UNCOMMON)));
    public static final Item LAPIS_WAND =
            Registry.register(Registries.ITEM, new Identifier("netherwarts", "lapis_wand"),
                    new Wand(new FabricItemSettings().maxCount(1).maxDamage(1000).rarity(Rarity.UNCOMMON)));
    public static final Item GOLD_WAND =
            Registry.register(Registries.ITEM, new Identifier("netherwarts", "gold_wand"),
                    new Wand(new FabricItemSettings().maxCount(1).maxDamage(1000).rarity(Rarity.RARE)));
    public static final Item EMERALD_WAND =
            Registry.register(Registries.ITEM, new Identifier("netherwarts", "emerald_wand"),
                    new Wand(new FabricItemSettings().maxCount(1).maxDamage(1000).rarity(Rarity.RARE)));
    public static final Item NETHERITE_WAND =
            Registry.register(Registries.ITEM, new Identifier("netherwarts", "netherite_wand"),
                    new Wand(new FabricItemSettings().maxCount(1).maxDamage(1000).rarity(Rarity.EPIC)));
    public static final Item DIAMOND_WAND =
            Registry.register(Registries.ITEM, new Identifier("netherwarts", "diamond_wand"),
                    new Wand(new FabricItemSettings().maxCount(1).maxDamage(1000).rarity(Rarity.EPIC)));
    //
    //Forge
    //
    public static final Block WAND_FORGE =
            Registry.register(Registries.BLOCK, new Identifier("netherwarts", "wand_forge"),
                    new WandForge(FabricBlockSettings.of(Material.STONE).collidable(true).strength(4.0f)));
    public static final BlockEntityType<WandForgeEntity> WAND_FORGE_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier("netherwarts", "wand_forge_entity"),
            FabricBlockEntityTypeBuilder.create(WandForgeEntity::new, WAND_FORGE).build()
    );

    //
    //Groups
    //
    private static final ItemGroup NETHERWARTS_GROUP = FabricItemGroup.builder(new Identifier("netherwarts", "netherwarts_group"))
            .icon(() -> new ItemStack(STONE_WAND)).displayName(Text.of("Netherwarts Items"))
            .build();

    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {

        ItemGroupEvents.modifyEntriesEvent(NETHERWARTS_GROUP).register(content -> {
            content.add(WAND_FORGE);
            content.add(WAND_BASE);
            content.add(STONE_WAND_TIP);
            content.add(COPPER_WAND_TIP);
            content.add(IRON_WAND_TIP);
            content.add(LAPIS_WAND_TIP);
            content.add(GOLD_WAND_TIP);
            content.add(EMERALD_WAND_TIP);
            content.add(NETHERITE_WAND_TIP);
            content.add(DIAMOND_WAND_TIP);
            content.add(PIGLIN_WAND_CORE);
            content.add(BLAZE_WAND_CORE);
            content.add(WITHERSKELETON_WAND_CORE);
            content.add(STONE_WAND);
            content.add(COPPER_WAND);
            content.add(IRON_WAND);
            content.add(LAPIS_WAND);
            content.add(GOLD_WAND);
            content.add(EMERALD_WAND);
            content.add(NETHERITE_WAND);
            content.add(DIAMOND_WAND);
        });

        Registry.register(Registries.ITEM, new Identifier("netherwarts", "wand_forge"), new BlockItem(WAND_FORGE, new FabricItemSettings()));
    }
}
