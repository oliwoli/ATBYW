package net.azagwen.atbyw.blocks;

import net.azagwen.atbyw.blocks.slabs.*;
import net.azagwen.atbyw.blocks.stairs.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import java.util.function.ToIntFunction;

import static net.azagwen.atbyw.blocks.AtbywBlockUtils.*;
import static net.azagwen.atbyw.init.AtbywMain.*;

public class AtbywBlocks {

    public static Boolean always(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) { return true; }
    public static Boolean never(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) { return false; }
    public static boolean always(BlockState state, BlockView world, BlockPos pos) { return true; }
    public static boolean never(BlockState state, BlockView world, BlockPos pos) { return false; }

    private static ToIntFunction<BlockState> createLightLevelFromBlockState(int litLevel, BooleanProperty state) {
        return (blockState) -> blockState.get(state) ? litLevel : 0;
    }

    private static FabricBlockSettings MakeBasalt() {
        return FabricBlockSettings.of(Material.STONE, MaterialColor.BLACK).requiresTool().breakByTool(FabricToolTags.PICKAXES).strength(1.25F, 4.2F).sounds(BlockSoundGroup.BASALT);
    }

    private static FabricBlockSettings MakeWoodenFenceDoor(Block copiedMatColor) {
        return FabricBlockSettings.of(Material.WOOD, copiedMatColor.getDefaultMaterialColor()).breakByTool(FabricToolTags.AXES).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD);
    }

    public static final Block[] TESTBLOCK = AtbywBlockUtils.<SlabBlockSubClass>DeclareMultipleBlocks(3, Material.BAMBOO, MaterialColor.BROWN);

    //Dummy Blocks
    public static final Block TICKING_DIRT = new Block(FabricBlockSettings.of(Material.SOIL, MaterialColor.DIRT).ticksRandomly().breakByTool(FabricToolTags.SHOVELS).strength(0.5F).sounds(BlockSoundGroup.GRAVEL));
    public static final Block DUMMY_GRASS_BLOCK = new GrassBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC).ticksRandomly().breakByTool(FabricToolTags.SHOVELS).strength(0.6F).sounds(BlockSoundGroup.GRASS));
    public static final Block DUMMY_MYCELIUM = new MyceliumBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC, MaterialColor.PURPLE).ticksRandomly().breakByTool(FabricToolTags.SHOVELS).strength(0.6F).sounds(BlockSoundGroup.GRASS));

    //Full Blocks
    public static final Block DIRT_STAIRS = new DirtStairsBlock(FabricBlockSettings.copyOf(TICKING_DIRT));
    public static final Block GRASS_BLOCK_STAIRS = new SpreadableStairsBlock(DUMMY_GRASS_BLOCK, Blocks.GRASS_BLOCK, FabricBlockSettings.copyOf(DUMMY_GRASS_BLOCK));
    public static final Block MYCELIUM_STAIRS = new SpreadableStairsBlock(DUMMY_MYCELIUM, Blocks.MYCELIUM, FabricBlockSettings.copyOf(DUMMY_MYCELIUM));
    public static final Block COARSE_DIRT_STAIRS = new StairsBlockSubClass(Blocks.COARSE_DIRT, FabricBlockSettings.of(Material.SOIL, MaterialColor.DIRT).breakByTool(FabricToolTags.SHOVELS).strength(0.5F).sounds(BlockSoundGroup.GRAVEL).ticksRandomly());
    public static final Block PODZOL_STAIRS = new StairsBlockSubClass(Blocks.PODZOL, FabricBlockSettings.of(Material.SOIL, MaterialColor.SPRUCE).breakByTool(FabricToolTags.SHOVELS).strength(0.5F).sounds(BlockSoundGroup.GRAVEL));
    public static final Block GRASS_PATH_STAIRS = new GrassPathStairsBlock(Blocks.GRASS_PATH, FabricBlockSettings.copyOf(Blocks.GRASS_PATH).breakByTool(FabricToolTags.SHOVELS));
    public static final Block NETHERRACK_STAIRS = new NetherrackStairsBlock(Blocks.NETHERRACK, FabricBlockSettings.copyOf(Blocks.NETHERRACK).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block CRIMSON_NYLIUM_STAIRS = new NyliumStairsBlock(Blocks.CRIMSON_NYLIUM, FabricBlockSettings.copyOf(Blocks.CRIMSON_NYLIUM).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block WARPED_NYLIUM_STAIRS = new NyliumStairsBlock(Blocks.WARPED_NYLIUM, FabricBlockSettings.copyOf(Blocks.WARPED_NYLIUM).requiresTool().breakByTool(FabricToolTags.PICKAXES));

    public static final Block DIRT_SLAB = new DirtSlabBlock(FabricBlockSettings.copyOf(TICKING_DIRT));
    public static final Block GRASS_BLOCK_SLAB = new SpreadableSlabBlock(Blocks.GRASS_BLOCK, FabricBlockSettings.copyOf(DUMMY_GRASS_BLOCK));
    public static final Block MYCELIUM_SLAB = new SpreadableSlabBlock(Blocks.MYCELIUM, FabricBlockSettings.copyOf(DUMMY_MYCELIUM));
    public static final Block COARSE_DIRT_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.COARSE_DIRT).breakByTool(FabricToolTags.SHOVELS));
    public static final Block PODZOL_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.PODZOL).breakByTool(FabricToolTags.SHOVELS));
    public static final Block GRASS_PATH_SLAB = new GrassPathSlabBlock(FabricBlockSettings.copyOf(Blocks.GRASS_PATH).breakByTool(FabricToolTags.SHOVELS));
    public static final Block NETHERRACK_SLAB = new NetherrackSlabBlock(FabricBlockSettings.copyOf(Blocks.NETHERRACK).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block CRIMSON_NYLIUM_SLAB = new NyliumSlabBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_NYLIUM).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block WARPED_NYLIUM_SLAB = new NyliumSlabBlock(FabricBlockSettings.copyOf(Blocks.WARPED_NYLIUM).requiresTool().breakByTool(FabricToolTags.PICKAXES));

    public static final Block SPRUCE_BOOKSHELF = new Block(FabricBlockSettings.copyOf(Blocks.BOOKSHELF));
    public static final Block BIRCH_BOOKSHELF = new Block(FabricBlockSettings.copyOf(Blocks.BOOKSHELF));
    public static final Block JUNGLE_BOOKSHELF = new Block(FabricBlockSettings.copyOf(Blocks.BOOKSHELF));
    public static final Block ACACIA_BOOKSHELF = new Block(FabricBlockSettings.copyOf(Blocks.BOOKSHELF));
    public static final Block DARK_OAK_BOOKSHELF = new Block(FabricBlockSettings.copyOf(Blocks.BOOKSHELF));
    public static final Block CRIMSON_BOOKSHELF = new Block(FabricBlockSettings.copyOf(Blocks.BOOKSHELF));
    public static final Block WARPED_BOOKSHELF = new Block(FabricBlockSettings.copyOf(Blocks.BOOKSHELF));

    public static final Block OAK_BOOKSHELF_TOGGLE = new BookshelfToggleBlock();
    public static final Block SPRUCE_BOOKSHELF_TOGGLE = new BookshelfToggleBlock();
    public static final Block BIRCH_BOOKSHELF_TOGGLE = new BookshelfToggleBlock();
    public static final Block JUNGLE_BOOKSHELF_TOGGLE = new BookshelfToggleBlock();
    public static final Block ACACIA_BOOKSHELF_TOGGLE = new BookshelfToggleBlock();
    public static final Block DARK_OAK_BOOKSHELF_TOGGLE = new BookshelfToggleBlock();
    public static final Block CRIMSON_BOOKSHELF_TOGGLE = new BookshelfToggleBlock();
    public static final Block WARPED_BOOKSHELF_TOGGLE = new BookshelfToggleBlock();

    public static final Block BASALT_BRICKS = new Block(MakeBasalt());
    public static final Block BASALT_PILLAR = new PillarBlock(MakeBasalt());

    public static final Block TERRACOTTA_STAIRS = new StairsBlockSubClass(Blocks.TERRACOTTA, FabricBlockSettings.copy(Blocks.TERRACOTTA));
    public static final Block WHITE_TERRACOTTA_STAIRS = new StairsBlockSubClass(Blocks.WHITE_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block ORANGE_TERRACOTTA_STAIRS = new StairsBlockSubClass(Blocks.ORANGE_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.ORANGE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block MAGENTA_TERRACOTTA_STAIRS = new StairsBlockSubClass(Blocks.MAGENTA_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.MAGENTA_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block LIGHT_BLUE_TERRACOTTA_STAIRS = new StairsBlockSubClass(Blocks.LIGHT_BLUE_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.LIGHT_BLUE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block YELLOW_TERRACOTTA_STAIRS = new StairsBlockSubClass(Blocks.YELLOW_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.YELLOW_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block LIME_TERRACOTTA_STAIRS = new StairsBlockSubClass(Blocks.LIME_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.LIME_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block PINK_TERRACOTTA_STAIRS = new StairsBlockSubClass(Blocks.PINK_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.PINK_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block GRAY_TERRACOTTA_STAIRS = new StairsBlockSubClass(Blocks.GRAY_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.GRAY_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block LIGHT_GRAY_TERRACOTTA_STAIRS = new StairsBlockSubClass(Blocks.LIGHT_GRAY_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.LIGHT_GRAY_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block CYAN_TERRACOTTA_STAIRS = new StairsBlockSubClass(Blocks.CYAN_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.CYAN_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block PURPLE_TERRACOTTA_STAIRS = new StairsBlockSubClass(Blocks.PURPLE_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.PURPLE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block BLUE_TERRACOTTA_STAIRS = new StairsBlockSubClass(Blocks.BLUE_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.BLUE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block BROWN_TERRACOTTA_STAIRS = new StairsBlockSubClass(Blocks.BROWN_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.BROWN_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block GREEN_TERRACOTTA_STAIRS = new StairsBlockSubClass(Blocks.GREEN_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.GREEN_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block RED_TERRACOTTA_STAIRS = new StairsBlockSubClass(Blocks.RED_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.RED_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block BLACK_TERRACOTTA_STAIRS = new StairsBlockSubClass(Blocks.BLACK_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.BLACK_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));

    public static final Block TERRACOTTA_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block WHITE_TERRACOTTA_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block ORANGE_TERRACOTTA_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.ORANGE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block MAGENTA_TERRACOTTA_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.MAGENTA_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block LIGHT_BLUE_TERRACOTTA_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.LIGHT_BLUE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block YELLOW_TERRACOTTA_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.YELLOW_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block LIME_TERRACOTTA_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.LIME_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block PINK_TERRACOTTA_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.PINK_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block GRAY_TERRACOTTA_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.GRAY_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block LIGHT_GRAY_TERRACOTTA_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.LIGHT_GRAY_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block CYAN_TERRACOTTA_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.CYAN_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block PURPLE_TERRACOTTA_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.PURPLE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block BLUE_TERRACOTTA_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.BLUE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block BROWN_TERRACOTTA_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.BROWN_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block GREEN_TERRACOTTA_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.GREEN_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block RED_TERRACOTTA_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.RED_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block BLACK_TERRACOTTA_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.BLACK_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));

    public static final Block TERRACOTTA_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block WHITE_TERRACOTTA_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block ORANGE_TERRACOTTA_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.ORANGE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block MAGENTA_TERRACOTTA_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.MAGENTA_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block LIGHT_BLUE_TERRACOTTA_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.LIGHT_BLUE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block YELLOW_TERRACOTTA_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.YELLOW_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block LIME_TERRACOTTA_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.LIME_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block PINK_TERRACOTTA_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.PINK_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block GRAY_TERRACOTTA_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.GRAY_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block LIGHT_GRAY_TERRACOTTA_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.LIGHT_GRAY_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block CYAN_TERRACOTTA_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.CYAN_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block PURPLE_TERRACOTTA_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.PURPLE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block BLUE_TERRACOTTA_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.BLUE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block BROWN_TERRACOTTA_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.BROWN_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block GREEN_TERRACOTTA_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.GREEN_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block RED_TERRACOTTA_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.RED_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block BLACK_TERRACOTTA_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.BLACK_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));

    public static final Block TERRACOTTA_BRICKS_STAIRS = new StairsBlockSubClass(Blocks.TERRACOTTA, FabricBlockSettings.copy(Blocks.TERRACOTTA));
    public static final Block WHITE_TERRACOTTA_BRICKS_STAIRS = new StairsBlockSubClass(Blocks.WHITE_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block ORANGE_TERRACOTTA_BRICKS_STAIRS = new StairsBlockSubClass(Blocks.ORANGE_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.ORANGE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block MAGENTA_TERRACOTTA_BRICKS_STAIRS = new StairsBlockSubClass(Blocks.MAGENTA_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.MAGENTA_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block LIGHT_BLUE_TERRACOTTA_BRICKS_STAIRS = new StairsBlockSubClass(Blocks.LIGHT_BLUE_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.LIGHT_BLUE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block YELLOW_TERRACOTTA_BRICKS_STAIRS = new StairsBlockSubClass(Blocks.YELLOW_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.YELLOW_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block LIME_TERRACOTTA_BRICKS_STAIRS = new StairsBlockSubClass(Blocks.LIME_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.LIME_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block PINK_TERRACOTTA_BRICKS_STAIRS = new StairsBlockSubClass(Blocks.PINK_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.PINK_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block GRAY_TERRACOTTA_BRICKS_STAIRS = new StairsBlockSubClass(Blocks.GRAY_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.GRAY_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block LIGHT_GRAY_TERRACOTTA_BRICKS_STAIRS = new StairsBlockSubClass(Blocks.LIGHT_GRAY_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.LIGHT_GRAY_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block CYAN_TERRACOTTA_BRICKS_STAIRS = new StairsBlockSubClass(Blocks.CYAN_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.CYAN_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block PURPLE_TERRACOTTA_BRICKS_STAIRS = new StairsBlockSubClass(Blocks.PURPLE_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.PURPLE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block BLUE_TERRACOTTA_BRICKS_STAIRS = new StairsBlockSubClass(Blocks.BLUE_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.BLUE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block BROWN_TERRACOTTA_BRICKS_STAIRS = new StairsBlockSubClass(Blocks.BROWN_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.BROWN_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block GREEN_TERRACOTTA_BRICKS_STAIRS = new StairsBlockSubClass(Blocks.GREEN_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.GREEN_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block RED_TERRACOTTA_BRICKS_STAIRS = new StairsBlockSubClass(Blocks.RED_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.RED_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block BLACK_TERRACOTTA_BRICKS_STAIRS = new StairsBlockSubClass(Blocks.BLACK_TERRACOTTA, FabricBlockSettings.copyOf(Blocks.BLACK_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));

    public static final Block TERRACOTTA_BRICKS_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block WHITE_TERRACOTTA_BRICKS_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block ORANGE_TERRACOTTA_BRICKS_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.ORANGE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block MAGENTA_TERRACOTTA_BRICKS_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.MAGENTA_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block LIGHT_BLUE_TERRACOTTA_BRICKS_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.LIGHT_BLUE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block YELLOW_TERRACOTTA_BRICKS_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.YELLOW_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block LIME_TERRACOTTA_BRICKS_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.LIME_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block PINK_TERRACOTTA_BRICKS_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.PINK_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block GRAY_TERRACOTTA_BRICKS_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.GRAY_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block LIGHT_GRAY_TERRACOTTA_BRICKS_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.LIGHT_GRAY_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block CYAN_TERRACOTTA_BRICKS_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.CYAN_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block PURPLE_TERRACOTTA_BRICKS_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.PURPLE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block BLUE_TERRACOTTA_BRICKS_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.BLUE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block BROWN_TERRACOTTA_BRICKS_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.BROWN_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block GREEN_TERRACOTTA_BRICKS_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.GREEN_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block RED_TERRACOTTA_BRICKS_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.RED_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block BLACK_TERRACOTTA_BRICKS_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.BLACK_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));

    public static final Block TERRACOTTA_BRICKS_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block WHITE_TERRACOTTA_BRICKS_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block ORANGE_TERRACOTTA_BRICKS_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.ORANGE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block MAGENTA_TERRACOTTA_BRICKS_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.MAGENTA_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block LIGHT_BLUE_TERRACOTTA_BRICKS_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.LIGHT_BLUE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block YELLOW_TERRACOTTA_BRICKS_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.YELLOW_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block LIME_TERRACOTTA_BRICKS_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.LIME_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block PINK_TERRACOTTA_BRICKS_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.PINK_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block GRAY_TERRACOTTA_BRICKS_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.GRAY_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block LIGHT_GRAY_TERRACOTTA_BRICKS_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.LIGHT_GRAY_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block CYAN_TERRACOTTA_BRICKS_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.CYAN_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block PURPLE_TERRACOTTA_BRICKS_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.PURPLE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block BLUE_TERRACOTTA_BRICKS_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.BLUE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block BROWN_TERRACOTTA_BRICKS_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.BROWN_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block GREEN_TERRACOTTA_BRICKS_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.GREEN_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block RED_TERRACOTTA_BRICKS_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.RED_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block BLACK_TERRACOTTA_BRICKS_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.BLACK_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));

    public static final Block WHITE_CONCRETE_STAIRS = new StairsBlockSubClass(Blocks.WHITE_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block ORANGE_CONCRETE_STAIRS = new StairsBlockSubClass(Blocks.ORANGE_CONCRETE, FabricBlockSettings.copyOf(Blocks.ORANGE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block MAGENTA_CONCRETE_STAIRS = new StairsBlockSubClass(Blocks.MAGENTA_CONCRETE, FabricBlockSettings.copyOf(Blocks.MAGENTA_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block LIGHT_BLUE_CONCRETE_STAIRS = new StairsBlockSubClass(Blocks.LIGHT_BLUE_CONCRETE, FabricBlockSettings.copyOf(Blocks.LIGHT_BLUE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block YELLOW_CONCRETE_STAIRS = new StairsBlockSubClass(Blocks.YELLOW_CONCRETE, FabricBlockSettings.copyOf(Blocks.YELLOW_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block LIME_CONCRETE_STAIRS = new StairsBlockSubClass(Blocks.LIME_CONCRETE, FabricBlockSettings.copyOf(Blocks.LIME_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block PINK_CONCRETE_STAIRS = new StairsBlockSubClass(Blocks.PINK_CONCRETE, FabricBlockSettings.copyOf(Blocks.PINK_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block GRAY_CONCRETE_STAIRS = new StairsBlockSubClass(Blocks.GRAY_CONCRETE, FabricBlockSettings.copyOf(Blocks.GRAY_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block LIGHT_GRAY_CONCRETE_STAIRS = new StairsBlockSubClass(Blocks.LIGHT_GRAY_CONCRETE, FabricBlockSettings.copyOf(Blocks.LIGHT_GRAY_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block CYAN_CONCRETE_STAIRS = new StairsBlockSubClass(Blocks.CYAN_CONCRETE, FabricBlockSettings.copyOf(Blocks.CYAN_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block PURPLE_CONCRETE_STAIRS = new StairsBlockSubClass(Blocks.PURPLE_CONCRETE, FabricBlockSettings.copyOf(Blocks.PURPLE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block BLUE_CONCRETE_STAIRS = new StairsBlockSubClass(Blocks.BLUE_CONCRETE, FabricBlockSettings.copyOf(Blocks.BLUE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block BROWN_CONCRETE_STAIRS = new StairsBlockSubClass(Blocks.BROWN_CONCRETE, FabricBlockSettings.copyOf(Blocks.BROWN_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block GREEN_CONCRETE_STAIRS = new StairsBlockSubClass(Blocks.GREEN_CONCRETE, FabricBlockSettings.copyOf(Blocks.GREEN_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block RED_CONCRETE_STAIRS = new StairsBlockSubClass(Blocks.RED_CONCRETE, FabricBlockSettings.copyOf(Blocks.RED_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block BLACK_CONCRETE_STAIRS = new StairsBlockSubClass(Blocks.BLACK_CONCRETE, FabricBlockSettings.copyOf(Blocks.BLACK_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES));

    public static final Block WHITE_CONCRETE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block ORANGE_CONCRETE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.ORANGE_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block MAGENTA_CONCRETE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.MAGENTA_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block LIGHT_BLUE_CONCRETE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.LIGHT_BLUE_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block YELLOW_CONCRETE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.YELLOW_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block LIME_CONCRETE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.LIME_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block PINK_CONCRETE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.PINK_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block GRAY_CONCRETE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.GRAY_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block LIGHT_GRAY_CONCRETE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.LIGHT_GRAY_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block CYAN_CONCRETE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.CYAN_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block PURPLE_CONCRETE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.PURPLE_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block BLUE_CONCRETE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.BLUE_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block BROWN_CONCRETE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.BROWN_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block GREEN_CONCRETE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.GREEN_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block RED_CONCRETE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.RED_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block BLACK_CONCRETE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));

    public static final Block WHITE_CINDER_BRICKS = new PillarBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block ORANGE_CINDER_BRICKS = new PillarBlock(FabricBlockSettings.copyOf(Blocks.ORANGE_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block MAGENTA_CINDER_BRICKS = new PillarBlock(FabricBlockSettings.copyOf(Blocks.MAGENTA_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block LIGHT_BLUE_CINDER_BRICKS = new PillarBlock(FabricBlockSettings.copyOf(Blocks.LIGHT_BLUE_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block YELLOW_CINDER_BRICKS = new PillarBlock(FabricBlockSettings.copyOf(Blocks.YELLOW_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block LIME_CINDER_BRICKS = new PillarBlock(FabricBlockSettings.copyOf(Blocks.LIME_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block PINK_CINDER_BRICKS = new PillarBlock(FabricBlockSettings.copyOf(Blocks.PINK_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block GRAY_CINDER_BRICKS = new PillarBlock(FabricBlockSettings.copyOf(Blocks.GRAY_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block LIGHT_GRAY_CINDER_BRICKS = new PillarBlock(FabricBlockSettings.copyOf(Blocks.LIGHT_GRAY_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block CYAN_CINDER_BRICKS = new PillarBlock(FabricBlockSettings.copyOf(Blocks.CYAN_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block PURPLE_CINDER_BRICKS = new PillarBlock(FabricBlockSettings.copyOf(Blocks.PURPLE_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block BLUE_CINDER_BRICKS = new PillarBlock(FabricBlockSettings.copyOf(Blocks.BLUE_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block BROWN_CINDER_BRICKS = new PillarBlock(FabricBlockSettings.copyOf(Blocks.BROWN_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block GREEN_CINDER_BRICKS = new PillarBlock(FabricBlockSettings.copyOf(Blocks.GREEN_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block RED_CINDER_BRICKS = new PillarBlock(FabricBlockSettings.copyOf(Blocks.RED_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block BLACK_CINDER_BRICKS = new PillarBlock(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));

    public static final Block WHITE_CINDER_BRICKS_WALL = new CinderBlocksWallBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block ORANGE_CINDER_BRICKS_WALL = new CinderBlocksWallBlock(FabricBlockSettings.copyOf(Blocks.ORANGE_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block MAGENTA_CINDER_BRICKS_WALL = new CinderBlocksWallBlock(FabricBlockSettings.copyOf(Blocks.MAGENTA_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block LIGHT_BLUE_CINDER_BRICKS_WALL = new CinderBlocksWallBlock(FabricBlockSettings.copyOf(Blocks.LIGHT_BLUE_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block YELLOW_CINDER_BRICKS_WALL = new CinderBlocksWallBlock(FabricBlockSettings.copyOf(Blocks.YELLOW_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block LIME_CINDER_BRICKS_WALL = new CinderBlocksWallBlock(FabricBlockSettings.copyOf(Blocks.LIME_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block PINK_CINDER_BRICKS_WALL = new CinderBlocksWallBlock(FabricBlockSettings.copyOf(Blocks.PINK_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block GRAY_CINDER_BRICKS_WALL = new CinderBlocksWallBlock(FabricBlockSettings.copyOf(Blocks.GRAY_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block LIGHT_GRAY_CINDER_BRICKS_WALL = new CinderBlocksWallBlock(FabricBlockSettings.copyOf(Blocks.LIGHT_GRAY_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block CYAN_CINDER_BRICKS_WALL = new CinderBlocksWallBlock(FabricBlockSettings.copyOf(Blocks.CYAN_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block PURPLE_CINDER_BRICKS_WALL = new CinderBlocksWallBlock(FabricBlockSettings.copyOf(Blocks.PURPLE_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block BLUE_CINDER_BRICKS_WALL = new CinderBlocksWallBlock(FabricBlockSettings.copyOf(Blocks.BLUE_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block BROWN_CINDER_BRICKS_WALL = new CinderBlocksWallBlock(FabricBlockSettings.copyOf(Blocks.BROWN_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block GREEN_CINDER_BRICKS_WALL = new CinderBlocksWallBlock(FabricBlockSettings.copyOf(Blocks.GREEN_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block RED_CINDER_BRICKS_WALL = new CinderBlocksWallBlock(FabricBlockSettings.copyOf(Blocks.RED_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));
    public static final Block BLACK_CINDER_BRICKS_WALL = new CinderBlocksWallBlock(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE).requiresTool().breakByTool(FabricToolTags.PICKAXES));

    //Other Blocks
    public static final Block OAK_FENCE_DOOR = new FenceDoorBlock(MakeWoodenFenceDoor(Blocks.OAK_PLANKS));
    public static final Block SPRUCE_FENCE_DOOR = new FenceDoorBlock(MakeWoodenFenceDoor(Blocks.SPRUCE_PLANKS));
    public static final Block BIRCH_FENCE_DOOR = new FenceDoorBlock(MakeWoodenFenceDoor(Blocks.BIRCH_PLANKS));
    public static final Block JUNGLE_FENCE_DOOR = new FenceDoorBlock(MakeWoodenFenceDoor(Blocks.JUNGLE_PLANKS));
    public static final Block ACACIA_FENCE_DOOR = new FenceDoorBlock(MakeWoodenFenceDoor(Blocks.ACACIA_PLANKS));
    public static final Block DARK_OAK_FENCE_DOOR = new FenceDoorBlock(MakeWoodenFenceDoor(Blocks.DARK_OAK_PLANKS));
    public static final Block CRIMSON_FENCE_DOOR = new FenceDoorBlock(MakeWoodenFenceDoor(Blocks.CRIMSON_PLANKS));
    public static final Block WARPED_FENCE_DOOR = new FenceDoorBlock(MakeWoodenFenceDoor(Blocks.WARPED_PLANKS));
    public static final Block IRON_FENCE_DOOR = new FenceDoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_DOOR).requiresTool().breakByTool(FabricToolTags.PICKAXES));

    public static final Block SPRUCE_LADDER = new LadderBlockSubClass(FabricBlockSettings.copyOf(Blocks.LADDER));
    public static final Block BIRCH_LADDER = new LadderBlockSubClass(FabricBlockSettings.copyOf(Blocks.LADDER));
    public static final Block JUNGLE_LADDER = new LadderBlockSubClass(FabricBlockSettings.copyOf(Blocks.LADDER));
    public static final Block ACACIA_LADDER = new LadderBlockSubClass(FabricBlockSettings.copyOf(Blocks.LADDER));
    public static final Block DARK_OAK_LADDER = new LadderBlockSubClass(FabricBlockSettings.copyOf(Blocks.LADDER));
    public static final Block CRIMSON_LADDER = new LadderBlockSubClass(FabricBlockSettings.copyOf(Blocks.LADDER));
    public static final Block WARPED_LADDER = new LadderBlockSubClass(FabricBlockSettings.copyOf(Blocks.LADDER));
    public static final Block BAMBOO_LADDER = new BambooLadderBlock(FabricBlockSettings.copyOf(Blocks.BAMBOO));

    public static final Block DANDELION_PULL_SWITCH = new FlowerButtonBlock(FabricBlockSettings.copyOf(Blocks.DANDELION).luminance(createLightLevelFromBlockState(8, Properties.LIT)).sounds(BlockSoundGroup.WOOD));
    public static final Block POPPY_PULL_SWITCH = new FlowerButtonBlock(FabricBlockSettings.copyOf(Blocks.POPPY).luminance(createLightLevelFromBlockState(8, Properties.LIT)).sounds(BlockSoundGroup.WOOD));
    public static final Block BLUE_ORCHID_PULL_SWITCH = new FlowerButtonBlock(FabricBlockSettings.copyOf(Blocks.BLUE_ORCHID).luminance(createLightLevelFromBlockState(8, Properties.LIT)).sounds(BlockSoundGroup.WOOD));
    public static final Block ALLIUM_PULL_SWITCH = new FlowerButtonBlock(FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(createLightLevelFromBlockState(8, Properties.LIT)).sounds(BlockSoundGroup.WOOD));
    public static final Block AZURE_BLUET_PULL_SWITCH = new FlowerButtonBlock(FabricBlockSettings.copyOf(Blocks.AZURE_BLUET).luminance(createLightLevelFromBlockState(8, Properties.LIT)).sounds(BlockSoundGroup.WOOD));
    public static final Block RED_TULIP_PULL_SWITCH = new FlowerButtonBlock(FabricBlockSettings.copyOf(Blocks.RED_TULIP).luminance(createLightLevelFromBlockState(8, Properties.LIT)).sounds(BlockSoundGroup.WOOD));
    public static final Block ORANGE_TULIP_PULL_SWITCH = new FlowerButtonBlock(FabricBlockSettings.copyOf(Blocks.ORANGE_TULIP).luminance(createLightLevelFromBlockState(8, Properties.LIT)).sounds(BlockSoundGroup.WOOD));
    public static final Block WHITE_TULIP_PULL_SWITCH = new FlowerButtonBlock(FabricBlockSettings.copyOf(Blocks.WHITE_TULIP).luminance(createLightLevelFromBlockState(8, Properties.LIT)).sounds(BlockSoundGroup.WOOD));
    public static final Block PINK_TULIP_PULL_SWITCH = new FlowerButtonBlock(FabricBlockSettings.copyOf(Blocks.PINK_TULIP).luminance(createLightLevelFromBlockState(8, Properties.LIT)).sounds(BlockSoundGroup.WOOD));
    public static final Block OXEYE_DAISY_PULL_SWITCH = new FlowerButtonBlock(FabricBlockSettings.copyOf(Blocks.OXEYE_DAISY).luminance(createLightLevelFromBlockState(8, Properties.LIT)).sounds(BlockSoundGroup.WOOD));
    public static final Block CORNFLOWER_PULL_SWITCH = new FlowerButtonBlock(FabricBlockSettings.copyOf(Blocks.CORNFLOWER).luminance(createLightLevelFromBlockState(8, Properties.LIT)).sounds(BlockSoundGroup.WOOD));
    public static final Block WITHER_ROSE_PULL_SWITCH = new FlowerButtonBlock(FabricBlockSettings.copyOf(Blocks.WITHER_ROSE).luminance(createLightLevelFromBlockState(8, Properties.LIT)).sounds(BlockSoundGroup.WOOD));
    public static final Block LILY_OF_THE_VALLEY_PULL_SWITCH = new FlowerButtonBlock(FabricBlockSettings.copyOf(Blocks.LILY_OF_THE_VALLEY).luminance(createLightLevelFromBlockState(8, Properties.LIT)).sounds(BlockSoundGroup.WOOD));

    public static final Block DEVELOPER_BLOCK = new DevBlock(FabricBlockSettings.of(Material.WOOL, MaterialColor.ORANGE).nonOpaque().breakByHand(true).strength(0.1F).sounds(BlockSoundGroup.BONE));

    public static void init() {
//        registerBlocks(false, ATBYW_BLOCKS, "test_block", new String[] {"test111", "test222", "test333"}, TESTBLOCK);

        registerBlocks(false, ATBYW_REDSTONE, "fence_door", WOOD_NAMES, new Block[] {
                OAK_FENCE_DOOR,
                SPRUCE_FENCE_DOOR,
                BIRCH_FENCE_DOOR,
                JUNGLE_FENCE_DOOR,
                ACACIA_FENCE_DOOR,
                DARK_OAK_FENCE_DOOR,
                CRIMSON_FENCE_DOOR,
                WARPED_FENCE_DOOR
        });
        registerBlock(false, ATBYW_REDSTONE, "iron_fence_door", IRON_FENCE_DOOR);

        registerBlocks(false, ATBYW_REDSTONE, "bookshelf_toggle", WOOD_NAMES, new Block[] {
                OAK_BOOKSHELF_TOGGLE,
                SPRUCE_BOOKSHELF_TOGGLE,
                BIRCH_BOOKSHELF_TOGGLE,
                JUNGLE_BOOKSHELF_TOGGLE,
                ACACIA_BOOKSHELF_TOGGLE,
                DARK_OAK_BOOKSHELF_TOGGLE,
                CRIMSON_BOOKSHELF_TOGGLE,
                WARPED_BOOKSHELF_TOGGLE
        });

        registerBlocks(false, ATBYW_REDSTONE, "pull_switch", FLOWER_NAMES, new Block[] {
                DANDELION_PULL_SWITCH,
                POPPY_PULL_SWITCH,
                BLUE_ORCHID_PULL_SWITCH,
                ALLIUM_PULL_SWITCH,
                AZURE_BLUET_PULL_SWITCH,
                RED_TULIP_PULL_SWITCH,
                ORANGE_TULIP_PULL_SWITCH,
                WHITE_TULIP_PULL_SWITCH,
                PINK_TULIP_PULL_SWITCH,
                OXEYE_DAISY_PULL_SWITCH,
                CORNFLOWER_PULL_SWITCH,
                WITHER_ROSE_PULL_SWITCH,
                LILY_OF_THE_VALLEY_PULL_SWITCH
        });

        registerBlock(false, ATBYW_BLOCKS, "grass_block_stairs", GRASS_BLOCK_STAIRS);
        registerBlock(false, ATBYW_BLOCKS, "mycelium_stairs", MYCELIUM_STAIRS);
        registerBlock(false, ATBYW_BLOCKS, "podzol_stairs", PODZOL_STAIRS);
        registerBlock(false, ATBYW_BLOCKS, "grass_path_stairs", GRASS_PATH_STAIRS);
        registerBlock(false, ATBYW_BLOCKS, "dirt_stairs", DIRT_STAIRS);
        registerBlock(false, ATBYW_BLOCKS, "coarse_dirt_stairs", COARSE_DIRT_STAIRS);
        registerBlock(false, ATBYW_BLOCKS, "crimson_nylium_stairs", CRIMSON_NYLIUM_STAIRS);
        registerBlock(false, ATBYW_BLOCKS, "warped_nylium_stairs", WARPED_NYLIUM_STAIRS);
        registerBlock(false, ATBYW_BLOCKS, "netherrack_stairs", NETHERRACK_STAIRS);

        registerBlock(false, ATBYW_BLOCKS, "grass_block_slab", GRASS_BLOCK_SLAB);
        registerBlock(false, ATBYW_BLOCKS, "mycelium_slab", MYCELIUM_SLAB);
        registerBlock(false, ATBYW_BLOCKS, "podzol_slab", PODZOL_SLAB);
        registerBlock(false, ATBYW_BLOCKS, "grass_path_slab", GRASS_PATH_SLAB);
        registerBlock(false, ATBYW_BLOCKS, "dirt_slab", DIRT_SLAB);
        registerBlock(false, ATBYW_BLOCKS, "coarse_dirt_slab", COARSE_DIRT_SLAB);
        registerBlock(false, ATBYW_BLOCKS, "crimson_nylium_slab", CRIMSON_NYLIUM_SLAB);
        registerBlock(false, ATBYW_BLOCKS, "warped_nylium_slab", WARPED_NYLIUM_SLAB);
        registerBlock(false, ATBYW_BLOCKS, "netherrack_slab", NETHERRACK_SLAB);

        registerBlocks(false, ATBYW_BLOCKS, "bookshelf", WOOD_NAMES_FROM_SPRUCE, new Block[] {
                SPRUCE_BOOKSHELF,
                BIRCH_BOOKSHELF,
                JUNGLE_BOOKSHELF,
                ACACIA_BOOKSHELF,
                DARK_OAK_BOOKSHELF,
                CRIMSON_BOOKSHELF,
                WARPED_BOOKSHELF
        });

        registerBlocks(false, ATBYW_BLOCKS, "ladder", WOOD_NAMES_FROM_SPRUCE, new Block[] {
                SPRUCE_LADDER,
                BIRCH_LADDER,
                JUNGLE_LADDER,
                ACACIA_LADDER,
                DARK_OAK_LADDER,
                CRIMSON_LADDER,
                WARPED_LADDER
        });
        registerBlock(false, ATBYW_BLOCKS, "bamboo_ladder", BAMBOO_LADDER);

        registerBlock(false, ATBYW_BLOCKS, "basalt_bricks", BASALT_BRICKS);
        registerBlock(false, ATBYW_BLOCKS, "basalt_pillar", BASALT_PILLAR);

        registerBlock(false, ATBYW_BLOCKS, "terracotta_stairs", TERRACOTTA_STAIRS);
        registerBlocks(false, ATBYW_BLOCKS, "terracotta_stairs", COLOR_NAMES, new Block[] {
                WHITE_TERRACOTTA_STAIRS,
                ORANGE_TERRACOTTA_STAIRS,
                MAGENTA_TERRACOTTA_STAIRS,
                LIGHT_BLUE_TERRACOTTA_STAIRS,
                YELLOW_TERRACOTTA_STAIRS,
                LIME_TERRACOTTA_STAIRS,
                PINK_TERRACOTTA_STAIRS,
                GRAY_TERRACOTTA_STAIRS,
                LIGHT_GRAY_TERRACOTTA_STAIRS,
                CYAN_TERRACOTTA_STAIRS,
                PURPLE_TERRACOTTA_STAIRS,
                BLUE_TERRACOTTA_STAIRS,
                BROWN_TERRACOTTA_STAIRS,
                GREEN_TERRACOTTA_STAIRS,
                RED_TERRACOTTA_STAIRS,
                BLACK_TERRACOTTA_STAIRS
        });

        registerBlock(false, ATBYW_BLOCKS, "terracotta_slab", TERRACOTTA_SLAB);
        registerBlocks(false, ATBYW_BLOCKS, "terracotta_slab", COLOR_NAMES, new Block[] {
                WHITE_TERRACOTTA_SLAB,
                ORANGE_TERRACOTTA_SLAB,
                MAGENTA_TERRACOTTA_SLAB,
                LIGHT_BLUE_TERRACOTTA_SLAB,
                YELLOW_TERRACOTTA_SLAB,
                LIME_TERRACOTTA_SLAB,
                PINK_TERRACOTTA_SLAB,
                GRAY_TERRACOTTA_SLAB,
                LIGHT_GRAY_TERRACOTTA_SLAB,
                CYAN_TERRACOTTA_SLAB,
                PURPLE_TERRACOTTA_SLAB,
                BLUE_TERRACOTTA_SLAB,
                BROWN_TERRACOTTA_SLAB,
                GREEN_TERRACOTTA_SLAB,
                RED_TERRACOTTA_SLAB,
                BLACK_TERRACOTTA_SLAB
        });

        registerBlock(false, ATBYW_BLOCKS, "terracotta_bricks", TERRACOTTA_BRICKS);
        registerBlocks(false, ATBYW_BLOCKS, "terracotta_bricks", COLOR_NAMES, new Block[] {
                WHITE_TERRACOTTA_BRICKS,
                ORANGE_TERRACOTTA_BRICKS,
                MAGENTA_TERRACOTTA_BRICKS,
                LIGHT_BLUE_TERRACOTTA_BRICKS,
                YELLOW_TERRACOTTA_BRICKS,
                LIME_TERRACOTTA_BRICKS,
                PINK_TERRACOTTA_BRICKS,
                GRAY_TERRACOTTA_BRICKS,
                LIGHT_GRAY_TERRACOTTA_BRICKS,
                CYAN_TERRACOTTA_BRICKS,
                PURPLE_TERRACOTTA_BRICKS,
                BLUE_TERRACOTTA_BRICKS,
                BROWN_TERRACOTTA_BRICKS,
                GREEN_TERRACOTTA_BRICKS,
                RED_TERRACOTTA_BRICKS,
                BLACK_TERRACOTTA_BRICKS
        });

        registerBlock(false, ATBYW_BLOCKS, "terracotta_bricks_stairs", TERRACOTTA_BRICKS_STAIRS);
        registerBlocks(false, ATBYW_BLOCKS, "terracotta_bricks_stairs", COLOR_NAMES, new Block[] {
                WHITE_TERRACOTTA_BRICKS_STAIRS,
                ORANGE_TERRACOTTA_BRICKS_STAIRS,
                MAGENTA_TERRACOTTA_BRICKS_STAIRS,
                LIGHT_BLUE_TERRACOTTA_BRICKS_STAIRS,
                YELLOW_TERRACOTTA_BRICKS_STAIRS,
                LIME_TERRACOTTA_BRICKS_STAIRS,
                PINK_TERRACOTTA_BRICKS_STAIRS,
                GRAY_TERRACOTTA_BRICKS_STAIRS,
                LIGHT_GRAY_TERRACOTTA_BRICKS_STAIRS,
                CYAN_TERRACOTTA_BRICKS_STAIRS,
                PURPLE_TERRACOTTA_BRICKS_STAIRS,
                BLUE_TERRACOTTA_BRICKS_STAIRS,
                BROWN_TERRACOTTA_BRICKS_STAIRS,
                GREEN_TERRACOTTA_BRICKS_STAIRS,
                RED_TERRACOTTA_BRICKS_STAIRS,
                BLACK_TERRACOTTA_BRICKS_STAIRS
        });

        registerBlock(false, ATBYW_BLOCKS, "terracotta_bricks_slab", TERRACOTTA_BRICKS_SLAB);
        registerBlocks(false, ATBYW_BLOCKS, "terracotta_bricks_slab", COLOR_NAMES, new Block[] {
                WHITE_TERRACOTTA_BRICKS_SLAB,
                ORANGE_TERRACOTTA_BRICKS_SLAB,
                MAGENTA_TERRACOTTA_BRICKS_SLAB,
                LIGHT_BLUE_TERRACOTTA_BRICKS_SLAB,
                YELLOW_TERRACOTTA_BRICKS_SLAB,
                LIME_TERRACOTTA_BRICKS_SLAB,
                PINK_TERRACOTTA_BRICKS_SLAB,
                GRAY_TERRACOTTA_BRICKS_SLAB,
                LIGHT_GRAY_TERRACOTTA_BRICKS_SLAB,
                CYAN_TERRACOTTA_BRICKS_SLAB,
                PURPLE_TERRACOTTA_BRICKS_SLAB,
                BLUE_TERRACOTTA_BRICKS_SLAB,
                BROWN_TERRACOTTA_BRICKS_SLAB,
                GREEN_TERRACOTTA_BRICKS_SLAB,
                RED_TERRACOTTA_BRICKS_SLAB,
                BLACK_TERRACOTTA_BRICKS_SLAB
        });

        registerBlock(false, ATBYW_BLOCKS, "terracotta_bricks_wall", TERRACOTTA_BRICKS_WALL);
        registerBlocks(false, ATBYW_BLOCKS, "terracotta_bricks_wall", COLOR_NAMES, new Block[] {
                WHITE_TERRACOTTA_BRICKS_WALL,
                ORANGE_TERRACOTTA_BRICKS_WALL,
                MAGENTA_TERRACOTTA_BRICKS_WALL,
                LIGHT_BLUE_TERRACOTTA_BRICKS_WALL,
                YELLOW_TERRACOTTA_BRICKS_WALL,
                LIME_TERRACOTTA_BRICKS_WALL,
                PINK_TERRACOTTA_BRICKS_WALL,
                GRAY_TERRACOTTA_BRICKS_WALL,
                LIGHT_GRAY_TERRACOTTA_BRICKS_WALL,
                CYAN_TERRACOTTA_BRICKS_WALL,
                PURPLE_TERRACOTTA_BRICKS_WALL,
                BLUE_TERRACOTTA_BRICKS_WALL,
                BROWN_TERRACOTTA_BRICKS_WALL,
                GREEN_TERRACOTTA_BRICKS_WALL,
                RED_TERRACOTTA_BRICKS_WALL,
                BLACK_TERRACOTTA_BRICKS_WALL
        });

        registerBlocks(false, ATBYW_BLOCKS, "concrete_stairs", COLOR_NAMES, new Block[] {
                WHITE_CONCRETE_STAIRS,
                ORANGE_CONCRETE_STAIRS,
                MAGENTA_CONCRETE_STAIRS,
                LIGHT_BLUE_CONCRETE_STAIRS,
                YELLOW_CONCRETE_STAIRS,
                LIME_CONCRETE_STAIRS,
                PINK_CONCRETE_STAIRS,
                GRAY_CONCRETE_STAIRS,
                LIGHT_GRAY_CONCRETE_STAIRS,
                CYAN_CONCRETE_STAIRS,
                PURPLE_CONCRETE_STAIRS,
                BLUE_CONCRETE_STAIRS,
                BROWN_CONCRETE_STAIRS,
                GREEN_CONCRETE_STAIRS,
                RED_CONCRETE_STAIRS,
                BLACK_CONCRETE_STAIRS
        });

        registerBlocks(false, ATBYW_BLOCKS, "concrete_slab", COLOR_NAMES, new Block[] {
                WHITE_CONCRETE_SLAB,
                ORANGE_CONCRETE_SLAB,
                MAGENTA_CONCRETE_SLAB,
                LIGHT_BLUE_CONCRETE_SLAB,
                YELLOW_CONCRETE_SLAB,
                LIME_CONCRETE_SLAB,
                PINK_CONCRETE_SLAB,
                GRAY_CONCRETE_SLAB,
                LIGHT_GRAY_CONCRETE_SLAB,
                CYAN_CONCRETE_SLAB,
                PURPLE_CONCRETE_SLAB,
                BLUE_CONCRETE_SLAB,
                BROWN_CONCRETE_SLAB,
                GREEN_CONCRETE_SLAB,
                RED_CONCRETE_SLAB,
                BLACK_CONCRETE_SLAB
        });

        registerBlocks(false, ATBYW_BLOCKS, "cinder_bricks", COLOR_NAMES, new Block[] {
                WHITE_CINDER_BRICKS,
                ORANGE_CINDER_BRICKS,
                MAGENTA_CINDER_BRICKS,
                LIGHT_BLUE_CINDER_BRICKS,
                YELLOW_CINDER_BRICKS,
                LIME_CINDER_BRICKS,
                PINK_CINDER_BRICKS,
                GRAY_CINDER_BRICKS,
                LIGHT_GRAY_CINDER_BRICKS,
                CYAN_CINDER_BRICKS,
                PURPLE_CINDER_BRICKS,
                BLUE_CINDER_BRICKS,
                BROWN_CINDER_BRICKS,
                GREEN_CINDER_BRICKS,
                RED_CINDER_BRICKS,
                BLACK_CINDER_BRICKS
        });

        registerBlocks(false, ATBYW_BLOCKS, "cinder_blocks_wall", COLOR_NAMES, new Block[] {
                WHITE_CINDER_BRICKS_WALL,
                ORANGE_CINDER_BRICKS_WALL,
                MAGENTA_CINDER_BRICKS_WALL,
                LIGHT_BLUE_CINDER_BRICKS_WALL,
                YELLOW_CINDER_BRICKS_WALL,
                LIME_CINDER_BRICKS_WALL,
                PINK_CINDER_BRICKS_WALL,
                GRAY_CINDER_BRICKS_WALL,
                LIGHT_GRAY_CINDER_BRICKS_WALL,
                CYAN_CINDER_BRICKS_WALL,
                PURPLE_CINDER_BRICKS_WALL,
                BLUE_CINDER_BRICKS_WALL,
                BROWN_CINDER_BRICKS_WALL,
                GREEN_CINDER_BRICKS_WALL,
                RED_CINDER_BRICKS_WALL,
                BLACK_CINDER_BRICKS_WALL
        });

        registerBlock(false, ATBYW_MISC, "dev_block", DEVELOPER_BLOCK);
    }
}
