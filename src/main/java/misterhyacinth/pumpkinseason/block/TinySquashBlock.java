package misterhyacinth.pumpkinseason.block;

import misterhyacinth.pumpkinseason.PumpkinItemRegistry;
import misterhyacinth.pumpkinseason.PumpkinRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.function.ToIntFunction;

public class TinySquashBlock extends Block {


    public static final IntProperty COUNT = IntProperty.of("count", 1, 4);
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public static final ToIntFunction<BlockState> JACK_O_LANTERN_LUMINANCE = (state) -> {
        return (4 * state.get(COUNT)) - 1;
    };
    public static final ToIntFunction<BlockState> JACK_O_SOUL_LANTERN_LUMINANCE = (state) -> {
        return (3 * state.get(COUNT)) - 1;
    };
    public static final ToIntFunction<BlockState> EERIE_JACK_O_LANTERN_LUMINANCE = (state) -> {
        return (2 * state.get(COUNT)) - 1;
    };


    public TinySquashBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(COUNT, 1));
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        return !context.shouldCancelInteraction() && context.getStack().isOf(this.asItem()) &&
                state.get(COUNT) < 4 ? true : super.canReplace(state, context);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos());
        return blockState.isOf(this) ? blockState.with(COUNT, Math.min(4, (Integer)blockState.get(COUNT) + 1)) :
                this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, COUNT);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction dir =  state.get(FACING);
        if (state.get(COUNT) == 1) {
            return SquashShapes.ONE_TINY_PUMPKIN_SHAPE;
        } else if (state.get(COUNT) == 2) {
            return switch(dir) {
                case EAST -> SquashShapes.TWO_TINY_PUMPKINS_EAST_SHAPE;
                case SOUTH -> SquashShapes.TWO_TINY_PUMPKINS_SOUTH_SHAPE;
                case WEST -> SquashShapes.TWO_TINY_PUMPKINS_WEST_SHAPE;
                default -> SquashShapes.TWO_TINY_PUMPKINS_NORTH_SHAPE;
            };
        } else if (state.get(COUNT) == 3) {
            return switch(dir) {
                case EAST -> SquashShapes.THREE_TINY_PUMPKINS_EAST_SHAPE;
                case SOUTH -> SquashShapes.THREE_TINY_PUMPKINS_SOUTH_SHAPE;
                case WEST -> SquashShapes.THREE_TINY_PUMPKINS_WEST_SHAPE;
                default -> SquashShapes.THREE_TINY_PUMPKINS_NORTH_SHAPE;
            };
        } else {
            return switch(dir) {
                case EAST -> SquashShapes.FOUR_TINY_PUMPKINS_EAST_SHAPE;
                case SOUTH -> SquashShapes.FOUR_TINY_PUMPKINS_SOUTH_SHAPE;
                case WEST -> SquashShapes.FOUR_TINY_PUMPKINS_WEST_SHAPE;
                default -> SquashShapes.FOUR_TINY_PUMPKINS_NORTH_SHAPE;
            };
        }
    }




}
