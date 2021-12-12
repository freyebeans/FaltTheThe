package com.freyebeans2506.faltthethe.utility;

import com.freyebeans2506.faltthethe.FaltTheThe;
import com.freyebeans2506.faltthethe.contentfeatures.blocks.Stand;
import com.freyebeans2506.faltthethe.contentfeatures.items.Book;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FaltTheThe.MOD_ID);
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FaltTheThe.MOD_ID);

    public static void init() {

        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    //items
    public static final RegistryObject<Item> QUARTZLIME_SHARD = ITEMS.register("quartzlime_shard", ()-> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> FALT = ITEMS.register("falt_fibers", ()-> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> PAPERSCRIPT_TOME = ITEMS.register("faltscript_tome", ()-> new Book(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> PAPERSCRIPT0 = ITEMS.register("faltscript_dual_lines", ()-> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> PAPERSCRIPT1 = ITEMS.register("faltscript_dot_doubles", ()-> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> PAPERSCRIPT2 = ITEMS.register("faltscript_circle_rune", ()-> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> PAPERSCRIPT3 = ITEMS.register("faltscript_symmetrical", ()-> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> PAPERSCRIPT_BLANK = ITEMS.register("faltscript", ()-> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));


    //blocks+block items
    public static final RegistryObject<Block> PAPERSCRIPT_BLOCK = BLOCKS.register("faltscript_stand", () -> new Stand(AbstractBlock.Properties.of(Material.WOOD)
            .strength(2.0f, 3.0f)
            .harvestTool(ToolType.AXE)
            .harvestLevel(0)
            .sound(SoundType.WOOD)
            .noOcclusion()
    ));
    public static final RegistryObject<Item> PAPERSCRIPT_ITEM = ITEMS.register("faltscript_stand", () -> new BlockItem(PAPERSCRIPT_BLOCK.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> QUARTZLIME_GLASS = BLOCKS.register("quartzlime_glass", () -> new GlassBlock(AbstractBlock.Properties.of(Material.GLASS)
            .strength(0.3f, 0.8f)
            .harvestLevel(0)
            .sound(SoundType.GLASS)
            .noOcclusion()
    ));
    public static final RegistryObject<Item> QUARTZLIME_GLASS_ITEM = ITEMS.register("quartzlime_glass", () -> new BlockItem(QUARTZLIME_GLASS.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Block> QUARTZLIME_GLASSPANE = BLOCKS.register("quartzlime_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.of(Material.GLASS)
            .strength(0.3f, 0.8f)
            .harvestLevel(0)
            .sound(SoundType.GLASS)
            .noOcclusion()
    ));
    public static final RegistryObject<Item> QUARTZLIME_GLASSPANE_ITEM = ITEMS.register("quartzlime_glass_pane", () -> new BlockItem(QUARTZLIME_GLASSPANE.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));
    public static final RegistryObject<Block> QUARTZ_GLASS = BLOCKS.register("quartz_glass", () -> new GlassBlock(AbstractBlock.Properties.of(Material.GLASS)
            .strength(0.3f, 0.8f)
            .harvestLevel(0)
            .sound(SoundType.GLASS)
            .noOcclusion()
    ));
    public static final RegistryObject<Item> QUARTZ_GLASS_ITEM = ITEMS.register("quartz_glass", () -> new BlockItem(QUARTZ_GLASS.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Block> QUARTZ_GLASSPANE = BLOCKS.register("quartz_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.of(Material.GLASS)
            .strength(0.3f, 0.8f)
            .harvestLevel(0)
            .sound(SoundType.GLASS)
            .noOcclusion()
    ));
    public static final RegistryObject<Item> QUARTZ_GLASSPANE_ITEM = ITEMS.register("quartz_glass_pane", () -> new BlockItem(QUARTZ_GLASSPANE.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));

//quartzlime

    public static final RegistryObject<Block> QUARTZLIME_BLOCK = BLOCKS.register("quartzlime_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE)
            .strength(0.8f, 0.8f)
            .harvestTool(ToolType.PICKAXE)
            .harvestLevel(0)
            .sound(SoundType.STONE)
            .requiresCorrectToolForDrops()
    ));
    public static final RegistryObject<Item> QUARTZLIME_ITEM = ITEMS.register("quartzlime_block", () -> new BlockItem(QUARTZLIME_BLOCK.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Block> SMOOTH_QUARTZLIME_BLOCK = BLOCKS.register("smooth_quartzlime", () -> new Block(AbstractBlock.Properties.of(Material.STONE)
            .strength(2.0f, 6.0f)
            .harvestTool(ToolType.PICKAXE)
            .harvestLevel(0)
            .sound(SoundType.STONE)
            .requiresCorrectToolForDrops()
    ));
    public static final RegistryObject<Item> SMOOTH_QUARTZLIME_ITEM = ITEMS.register("smooth_quartzlime", () -> new BlockItem(SMOOTH_QUARTZLIME_BLOCK.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Block> CHISELED_QUARTZLIME_BLOCK = BLOCKS.register("chiseled_quartzlime_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE)
            .strength(0.8f, 0.8f)
            .harvestTool(ToolType.PICKAXE)
            .harvestLevel(0)
            .sound(SoundType.STONE)
            .requiresCorrectToolForDrops()
    ));
    public static final RegistryObject<Item> CHISELED_QUARTZLIME_ITEM = ITEMS.register("chiseled_quartzlime_block", () -> new BlockItem(CHISELED_QUARTZLIME_BLOCK.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Block> QUARTZLIME_BRICKS_BLOCK = BLOCKS.register("quartzlime_bricks", () -> new Block(AbstractBlock.Properties.of(Material.STONE)
            .strength(0.8f, 0.8f)
            .harvestTool(ToolType.PICKAXE)
            .harvestLevel(0)
            .sound(SoundType.STONE)
            .requiresCorrectToolForDrops()
    ));
    public static final RegistryObject<Item> QUARTZLIME_BRICKS_ITEM = ITEMS.register("quartzlime_bricks", () -> new BlockItem(QUARTZLIME_BRICKS_BLOCK.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Block> QUARTZLIME_PILLAR_BLOCK = BLOCKS.register("quartzlime_pillar", () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.STONE)
            .strength(0.8f, 0.8f)
            .harvestTool(ToolType.PICKAXE)
            .harvestLevel(0)
            .sound(SoundType.STONE)
            .requiresCorrectToolForDrops()
    ));
    public static final RegistryObject<Item> QUARTZLIME_PILLAR_ITEM = ITEMS.register("quartzlime_pillar", () -> new BlockItem(QUARTZLIME_PILLAR_BLOCK.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    //stabs

    public static final RegistryObject<Block> QUARTZLIME_STAIRS = BLOCKS.register("quartzlime_stairs", ()-> new StairsBlock(QUARTZLIME_BLOCK.get().defaultBlockState(),
            AbstractBlock.Properties.of(Material.STONE)
                    .strength(0.8f,0.8f)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(0)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()
    ));
    public static final RegistryObject<Item> QUARTZLIME_STAIRSITEM = ITEMS.register("quartzlime_stairs", () -> new BlockItem(QUARTZLIME_STAIRS.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> QUARTZLIME_SLAB = BLOCKS.register("quartzlime_slab", ()-> new SlabBlock(
            AbstractBlock.Properties.of(Material.STONE)
                    .strength(0.8f,0.8f)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(0)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()
    ));
    public static final RegistryObject<Item> QUARTZLIME_SLABITEM = ITEMS.register("quartzlime_slab", () -> new BlockItem(QUARTZLIME_SLAB.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Block> SMOOTH_QUARTZLIME_STAIRS = BLOCKS.register("smooth_quartzlime_stairs", ()-> new StairsBlock(SMOOTH_QUARTZLIME_BLOCK.get().defaultBlockState(),
            AbstractBlock.Properties.of(Material.STONE)
                    .strength(2.0f,0.8f)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(0)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()
    ));
    public static final RegistryObject<Item> SMOOTH_QUARTZLIME_STAIRSITEM = ITEMS.register("smooth_quartzlime_stairs", () -> new BlockItem(SMOOTH_QUARTZLIME_STAIRS.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> SMOOTH_QUARTZLIME_SLAB = BLOCKS.register("smooth_quartzlime_slab", ()-> new SlabBlock(
            AbstractBlock.Properties.of(Material.STONE)
                    .strength(2.0f,0.8f)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(0)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()
    ));
    public static final RegistryObject<Item> SMOOTH_QUARTZLIME_SLABITEM = ITEMS.register("smooth_quartzlime_slab", () -> new BlockItem(SMOOTH_QUARTZLIME_SLAB.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Block> QUARTZLIME_BRICK_STAIRS = BLOCKS.register("quartzlime_brick_stairs", ()-> new StairsBlock(QUARTZLIME_BRICKS_BLOCK.get().defaultBlockState(),
            AbstractBlock.Properties.of(Material.STONE)
                    .strength(0.8f,0.8f)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(0)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()
    ));
    public static final RegistryObject<Item> QUARTZLIME_BRICK_STAIRSITEM = ITEMS.register("quartzlime_brick_stairs", () -> new BlockItem(QUARTZLIME_BRICK_STAIRS.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> QUARTZLIME_BRICK_SLAB = BLOCKS.register("quartzlime_brick_slab", ()-> new SlabBlock(
            AbstractBlock.Properties.of(Material.STONE)
                    .strength(0.8f,0.8f)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(0)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()
    ));
    public static final RegistryObject<Item> QUARTZLIME_BRICK_SLABITEM = ITEMS.register("quartzlime_brick_slab", () -> new BlockItem(QUARTZLIME_BRICK_SLAB.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Block> QUARTZ_BRICK_STAIRS = BLOCKS.register("quartz_brick_stairs", ()-> new StairsBlock(Blocks.QUARTZ_BRICKS.defaultBlockState(),
            AbstractBlock.Properties.of(Material.STONE)
                    .strength(0.8f,0.8f)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(0)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()
    ));
    public static final RegistryObject<Item> QUARTZ_BRICK_STAIRSITEM = ITEMS.register("quartz_brick_stairs", () -> new BlockItem(QUARTZ_BRICK_STAIRS.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> QUARTZ_BRICK_SLAB = BLOCKS.register("quartz_brick_slab", ()-> new SlabBlock(
            AbstractBlock.Properties.of(Material.STONE)
                    .strength(0.8f,0.8f)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(0)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()
    ));
    public static final RegistryObject<Item> QUARTZ_BRICK_SLABITEM = ITEMS.register("quartz_brick_slab", () -> new BlockItem(QUARTZ_BRICK_SLAB.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    //porous

    public static final RegistryObject<Block> QUARTZLIME_POROUS_BLOCK = BLOCKS.register("porous_quartzlime_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE)
            .strength(0.8f, 0.8f)
            .harvestTool(ToolType.PICKAXE)
            .harvestLevel(0)
            .sound(SoundType.METAL)
            .requiresCorrectToolForDrops()
    ));
    public static final RegistryObject<Item> QUARTZLIME_POROUS_ITEM = ITEMS.register("porous_quartzlime_block", () -> new BlockItem(QUARTZLIME_POROUS_BLOCK.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Block> QUARTZ_POROUS_BLOCK = BLOCKS.register("porous_quartz_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE)
            .strength(0.8f, 0.8f)
            .harvestTool(ToolType.PICKAXE)
            .harvestLevel(0)
            .sound(SoundType.METAL)
            .requiresCorrectToolForDrops()
    ));
    public static final RegistryObject<Item> QUARTZ_POROUS_ITEM = ITEMS.register("porous_quartz_block", () -> new BlockItem(QUARTZ_POROUS_BLOCK.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Block> QUARTZLIME_POWDER_BLOCK = BLOCKS.register("powder_quartzlime", () -> new FallingBlock(AbstractBlock.Properties.of(Material.STONE)
            .strength(0.8f, 0.8f)
            .harvestTool(ToolType.SHOVEL)
            .harvestLevel(0)
            .sound(SoundType.SAND)
    ));
    public static final RegistryObject<Item> QUARTZLIME_POWDER_ITEM = ITEMS.register("powder_quartzlime", () -> new BlockItem(QUARTZLIME_POWDER_BLOCK.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Block> QUARTZ_POWDER_BLOCK = BLOCKS.register("powder_quartz", () -> new FallingBlock(AbstractBlock.Properties.of(Material.STONE)
            .strength(0.8f, 0.8f)
            .harvestTool(ToolType.SHOVEL)
            .harvestLevel(0)
            .sound(SoundType.SAND)
    ));
    public static final RegistryObject<Item> QUARTZ_POWDER_ITEM = ITEMS.register("powder_quartz", () -> new BlockItem(QUARTZ_POWDER_BLOCK.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

}
