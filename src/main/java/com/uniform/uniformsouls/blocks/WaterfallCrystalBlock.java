package com.uniform.uniformsouls.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.WallMountedBlock;
import net.minecraft.block.enums.WallMountLocation;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class WaterfallCrystalBlock extends WallMountedBlock {
    public static final VoxelShape CEILING_X_SHAPE;
    public static final VoxelShape CEILING_Z_SHAPE;
    public static final VoxelShape FLOOR_X_SHAPE;
    public static final VoxelShape FLOOR_Z_SHAPE;
    public static final VoxelShape NORTH_SHAPE;
    public static final VoxelShape SOUTH_SHAPE;
    public static final VoxelShape WEST_SHAPE;
    public static final VoxelShape EAST_SHAPE;

    public WaterfallCrystalBlock(Settings settings) {
        super(settings);

    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = (Direction)state.get(FACING);
        switch((WallMountLocation)state.get(FACE)) {
            case FLOOR:
                if (direction.getAxis() == Direction.Axis.X) {
                    return FLOOR_X_SHAPE;
                }

                return FLOOR_Z_SHAPE;
            case WALL:
                switch(direction) {
                    case EAST:
                        return EAST_SHAPE;
                    case WEST:
                        return WEST_SHAPE;
                    case SOUTH:
                        return SOUTH_SHAPE;
                    case NORTH:
                    default:
                        return NORTH_SHAPE;
                }
            case CEILING:
            default:
                if (direction.getAxis() == Direction.Axis.X) {
                    return CEILING_X_SHAPE;
                } else {
                    return CEILING_Z_SHAPE;
                }
        }
    }


    private void updateNeighbors(BlockState state, World world, BlockPos pos) {
        world.updateNeighborsAlways(pos, this);
        world.updateNeighborsAlways(pos.offset(getDirection(state).getOpposite()), this);
    }

    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, FACE});
    }

    static {
        CEILING_X_SHAPE = Block.createCuboidShape(6.0D, 14.0D, 5.0D, 10.0D, 16.0D, 11.0D);
        CEILING_Z_SHAPE = Block.createCuboidShape(5.0D, 14.0D, 6.0D, 11.0D, 16.0D, 10.0D);
        FLOOR_X_SHAPE = Block.createCuboidShape(6.0D, 0.0D, 5.0D, 10.0D, 2.0D, 11.0D);
        FLOOR_Z_SHAPE = Block.createCuboidShape(5.0D, 0.0D, 6.0D, 11.0D, 2.0D, 10.0D);
        NORTH_SHAPE = Block.createCuboidShape(5.0D, 6.0D, 14.0D, 11.0D, 10.0D, 16.0D);
        SOUTH_SHAPE = Block.createCuboidShape(5.0D, 6.0D, 0.0D, 11.0D, 10.0D, 2.0D);
        WEST_SHAPE = Block.createCuboidShape(14.0D, 6.0D, 5.0D, 16.0D, 10.0D, 11.0D);
        EAST_SHAPE = Block.createCuboidShape(0.0D, 6.0D, 5.0D, 2.0D, 10.0D, 11.0D);
    }
}
