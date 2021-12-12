package com.freyebeans2506.faltthethe.contentfeatures.blocks;

import com.freyebeans2506.faltthethe.utility.RegistryHandler;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class Stand extends Block implements IWaterLoggable {

    private static final DirectionProperty FACING = HorizontalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public static final IntegerProperty RUNE = IntegerProperty.create("rune", 0, 5);
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(1, 16, 12, 15, 18, 16),
            Block.box(4, 3, 4, 12, 13, 12),
            Block.box(3, 13, 8, 13, 16, 13),
            Block.box(3, 2, 3, 13, 3, 13),
            Block.box(1, 0, 1, 15, 2, 15),
            Block.box(1, 10, 0, 15, 12, 4),
            Block.box(1, 12, 4, 15, 14, 8),
            Block.box(1, 14, 8, 15, 16, 12)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
    private static final VoxelShape SHAPE_E = Stream.of(
            Block.box(0, 16, 1, 4, 18, 15),
            Block.box(4, 3, 4, 12, 13, 12),
            Block.box(3, 13, 3, 8, 16, 13),
            Block.box(3, 2, 3, 13, 3, 13),
            Block.box(1, 0, 1, 15, 2, 15),
            Block.box(12, 10, 1, 16, 12, 15),
            Block.box(8, 12, 1, 12, 14, 15),
            Block.box(4, 14, 1, 8, 16, 15)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
    private static final VoxelShape SHAPE_S = Stream.of(
            Block.box(1, 16, 0, 15, 18, 4),
            Block.box(4, 3, 4, 12, 13, 12),
            Block.box(3, 13, 3, 13, 16, 8),
            Block.box(3, 2, 3, 13, 3, 13),
            Block.box(1, 0, 1, 15, 2, 15),
            Block.box(1, 10, 12, 15, 12, 16),
            Block.box(1, 12, 8, 15, 14, 12),
            Block.box(1, 14, 4, 15, 16, 8)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
    private static final VoxelShape SHAPE_W = Stream.of(
            Block.box(12, 16, 1, 16, 18, 15),
            Block.box(4, 3, 4, 12, 13, 12),
            Block.box(8, 13, 3, 13, 16, 13),
            Block.box(3, 2, 3, 13, 3, 13),
            Block.box(1, 0, 1, 15, 2, 15),
            Block.box(0, 10, 1, 4, 12, 15),
            Block.box(4, 12, 1, 8, 14, 15),
            Block.box(8, 14, 1, 12, 16, 15)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    public Stand(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(RUNE, Integer.valueOf(0)).setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.getValue(FACING)) {
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack itemstack = player.getItemInHand(handIn);
            int i = state.getValue(RUNE);
            Item item = itemstack.getItem();
            if (i == 1 && !worldIn.isClientSide) {
                if (!player.abilities.instabuild) {
                    if (itemstack.isEmpty()) {
                        player.setItemInHand(handIn, new ItemStack(RegistryHandler.PAPERSCRIPT_BLANK.get()));
                    } else if (!player.inventory.add(new ItemStack(RegistryHandler.PAPERSCRIPT_BLANK.get()))) {
                        player.drop(new ItemStack(RegistryHandler.PAPERSCRIPT_BLANK.get()), false);
                    }
                }

                this.setRuneType(worldIn, pos, state, 0);
                worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BOOK_PAGE_TURN, SoundCategory.BLOCKS, 1.0F, 1.0F);

                return ActionResultType.sidedSuccess(worldIn.isClientSide);
            } else if (i == 2 && !worldIn.isClientSide) {
                if (!player.abilities.instabuild) {
                    if (itemstack.isEmpty()) {
                        player.setItemInHand(handIn, new ItemStack(RegistryHandler.PAPERSCRIPT0.get()));
                    } else if (!player.inventory.add(new ItemStack(RegistryHandler.PAPERSCRIPT0.get()))) {
                        player.drop(new ItemStack(RegistryHandler.PAPERSCRIPT0.get()), false);
                    }
                }

                this.setRuneType(worldIn, pos, state, 0);
                worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BOOK_PAGE_TURN, SoundCategory.BLOCKS, 1.0F, 1.0F);

                return ActionResultType.sidedSuccess(worldIn.isClientSide);
            } else if (i == 3 && !worldIn.isClientSide) {
                if (!player.abilities.instabuild) {
                    if (itemstack.isEmpty()) {
                        player.setItemInHand(handIn, new ItemStack(RegistryHandler.PAPERSCRIPT1.get()));
                    } else if (!player.inventory.add(new ItemStack(RegistryHandler.PAPERSCRIPT1.get()))) {
                        player.drop(new ItemStack(RegistryHandler.PAPERSCRIPT1.get()), false);
                    }
                }

                this.setRuneType(worldIn, pos, state, 0);
                worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BOOK_PAGE_TURN, SoundCategory.BLOCKS, 1.0F, 1.0F);

                return ActionResultType.sidedSuccess(worldIn.isClientSide);
            } else if (i == 4 && !worldIn.isClientSide) {
                if (!player.abilities.instabuild) {
                    if (itemstack.isEmpty()) {
                        player.setItemInHand(handIn, new ItemStack(RegistryHandler.PAPERSCRIPT2.get()));
                    } else if (!player.inventory.add(new ItemStack(RegistryHandler.PAPERSCRIPT2.get()))) {
                        player.drop(new ItemStack(RegistryHandler.PAPERSCRIPT2.get()), false);
                    }
                }

                this.setRuneType(worldIn, pos, state, 0);
                worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BOOK_PAGE_TURN, SoundCategory.BLOCKS, 1.0F, 1.0F);

                return ActionResultType.sidedSuccess(worldIn.isClientSide);
            } else if (i == 5 && !worldIn.isClientSide) {
                if (!player.abilities.instabuild) {
                    if (itemstack.isEmpty()) {
                        player.setItemInHand(handIn, new ItemStack(RegistryHandler.PAPERSCRIPT3.get()));
                    } else if (!player.inventory.add(new ItemStack(RegistryHandler.PAPERSCRIPT3.get()))) {
                        player.drop(new ItemStack(RegistryHandler.PAPERSCRIPT3.get()), false);
                    }
                }

                this.setRuneType(worldIn, pos, state, 0);
                worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BOOK_PAGE_TURN, SoundCategory.BLOCKS, 1.0F, 1.0F);

                return ActionResultType.sidedSuccess(worldIn.isClientSide);
            } else if (item == RegistryHandler.PAPERSCRIPT_BLANK.get()) {
                if (i == 0 && !worldIn.isClientSide) {
                    if (!player.abilities.instabuild) {
                        itemstack.shrink(1);
                    }

                    this.setRuneType(worldIn, pos, state, 1);
                    worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BOOK_PAGE_TURN, SoundCategory.BLOCKS, 1.0F, 1.0F);
                }

                return ActionResultType.sidedSuccess(worldIn.isClientSide);
            } else if (item == RegistryHandler.PAPERSCRIPT0.get()) {
                if (i == 0 && !worldIn.isClientSide) {
                    if (!player.abilities.instabuild) {
                        itemstack.shrink(1);
                    }

                    this.setRuneType(worldIn, pos, state, 2);
                    worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BOOK_PAGE_TURN, SoundCategory.BLOCKS, 1.0F, 1.0F);
                }

                return ActionResultType.sidedSuccess(worldIn.isClientSide);
            } else if (item == RegistryHandler.PAPERSCRIPT1.get()) {
                if (i == 0 && !worldIn.isClientSide) {
                    if (!player.abilities.instabuild) {
                        itemstack.shrink(1);
                    }

                    this.setRuneType(worldIn, pos, state, 3);
                    worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BOOK_PAGE_TURN, SoundCategory.BLOCKS, 1.0F, 1.0F);
                }

                return ActionResultType.sidedSuccess(worldIn.isClientSide);
            } else if (item == RegistryHandler.PAPERSCRIPT2.get()) {
                if (i == 0 && !worldIn.isClientSide) {
                    if (!player.abilities.instabuild) {
                        itemstack.shrink(1);
                    }

                    this.setRuneType(worldIn, pos, state, 4);
                    worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BOOK_PAGE_TURN, SoundCategory.BLOCKS, 1.0F, 1.0F);
                }

                return ActionResultType.sidedSuccess(worldIn.isClientSide);
            } else if (item == RegistryHandler.PAPERSCRIPT3.get()) {
                if (i == 0 && !worldIn.isClientSide) {
                    if (!player.abilities.instabuild) {
                        itemstack.shrink(1);
                    }

                    this.setRuneType(worldIn, pos, state, 5);
                    worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BOOK_PAGE_TURN, SoundCategory.BLOCKS, 1.0F, 1.0F);
                }

                return ActionResultType.sidedSuccess(worldIn.isClientSide);
            } else {
                return ActionResultType.PASS;
            }
    }


    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.getValue(WATERLOGGED)) {
            worldIn.getLiquidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
        }

        return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, RUNE, WATERLOGGED);
    }

    public void setRuneType(World worldIn, BlockPos pos, BlockState state, int level) {
        worldIn.setBlock(pos, state.setValue(RUNE, Integer.valueOf(MathHelper.clamp(level, 0, 5))), 2);
        worldIn.updateNeighbourForOutputSignal(pos, this);
    }

    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

}
