package net.azagwen.atbyw.blocks.stairs;

import net.azagwen.atbyw.blocks.AtbywBlocks;
import net.azagwen.atbyw.blocks.slabs.SpreadableSlabBlock;
import net.azagwen.atbyw.misc.AtbywTags;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;

import java.util.Random;

public class SpreadableStairsBlock extends StairsBlockSubClass {
    private Block fullBlockEquivalent;

    public SpreadableStairsBlock(Block copiedBlock, Block fullBlockEquivalent, Settings settings) {
        super(copiedBlock, settings);
        this.fullBlockEquivalent = fullBlockEquivalent;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (state.isOf(AtbywBlocks.GRASS_BLOCK_STAIRS)) {
            if (player.getMainHandStack().getItem().isIn(FabricToolTags.SHOVELS)) {
                BlockState oldState = world.getBlockState(pos);

                world.setBlockState(pos, copyStates(AtbywBlocks.GRASS_PATH_STAIRS.getDefaultState(), oldState));
                world.playSound(player, pos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }

    private static boolean canSurvive(BlockState state, WorldView worldView, BlockPos pos) {
        BlockPos blockPos = pos.up();
        BlockState blockState = worldView.getBlockState(blockPos);

        return !blockState.isSideSolidFullSquare(worldView, blockPos, Direction.UP);
    }

    private static boolean canSpread(BlockState state, WorldView worldView, BlockPos pos) {
        BlockPos blockPos = pos.up();

        return canSurvive(state, worldView, pos) && !worldView.getFluidState(blockPos).isIn(FluidTags.WATER);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!canSurvive(state, world, pos)) {
            BlockState oldState = world.getBlockState(pos);

            world.setBlockState(pos, copyStates(AtbywBlocks.DIRT_STAIRS.getDefaultState(), oldState));
        }
        else {
            BlockState blockState = this.getDefaultState();

            if (world.getLightLevel(pos.up()) >= 9) {
                for(int i = 0; i < 4; ++i) {
                    BlockPos blockPos = pos.add(random.nextInt(3) - 1, random.nextInt(3) - 1, random.nextInt(3) - 1);
                    BlockState newState = world.getBlockState(blockPos);
                    BlockPos downPos = new BlockPos(pos.getX(), (pos.getY() - 1), pos.getZ());
                    BlockPos upPos = new BlockPos(pos.getX(), (pos.getY() + 1), pos.getZ());

                    if (!blockPos.equals(downPos)) {
                        if (!blockPos.equals(upPos)) {
                            if (world.getBlockState(blockPos).isOf(AtbywBlocks.DIRT_STAIRS) && canSpread(blockState, world, blockPos)) {
                                world.setBlockState(blockPos, copyStates(blockState, newState));
                            } else if (world.getBlockState(blockPos).isOf(AtbywBlocks.DIRT_SLAB) && canSpread(blockState, world, blockPos)) {
                                Block self = world.getBlockState(pos).getBlock();

                                if (self == AtbywBlocks.GRASS_BLOCK_STAIRS)
                                    world.setBlockState(blockPos, AtbywBlocks.GRASS_BLOCK_SLAB.getDefaultState()
                                            .with(SpreadableSlabBlock.TYPE, newState.get(SpreadableSlabBlock.TYPE)));
                                else if (self == AtbywBlocks.MYCELIUM_STAIRS)
                                    world.setBlockState(blockPos, AtbywBlocks.MYCELIUM_SLAB.getDefaultState()
                                            .with(SpreadableSlabBlock.TYPE, newState.get(SpreadableSlabBlock.TYPE)));
                            } else if (world.getBlockState(blockPos).isOf(Blocks.DIRT) && canSpread(blockState, world, blockPos)) {
                                world.setBlockState(blockPos, this.fullBlockEquivalent.getDefaultState());
                            }
                        }
                    }
                }
            }
        }
    }
}
