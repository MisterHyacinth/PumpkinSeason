package misterhyacinth.pumpkinseason.block;

import com.google.common.collect.Maps;
import misterhyacinth.pumpkinseason.PumpkinRegistry;
import misterhyacinth.pumpkinseason.util.PumpkinBlockTags;
import net.minecraft.block.*;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.Map;

public class PumpkinCandleCakeBlock extends CandleCakeBlock {

    protected static final VoxelShape CANDLE_SHAPE =
            Block.createCuboidShape(5.0, 8.0, 5.0, 11.0, 14.0, 11.0);
    protected static final VoxelShape BAT_CANDLE_SHAPE =
            Block.createCuboidShape(6.0, 8.0, 6.0, 10, 14.0, 10);
    protected static final VoxelShape CAKE_SHAPE =
            Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 8.0, 15.0);
    private static final Map<String, PumpkinCandleCakeBlock> CANDLE_CAKES_HASH = Maps.newHashMap();
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    private final Block cake;
    private final Block candle;


    public PumpkinCandleCakeBlock(Block candle, Block cake, Settings settings) {
        super(Blocks.CANDLE, settings);
        this.cake = cake;
        this.candle = candle;
        CANDLE_CAKES_HASH.put(candle.getName().toString() + "_" + cake.getName().toString(), this);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(LIT, false)
                .with(FACING, Direction.NORTH));
    }


    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (this.candle == PumpkinRegistry.BAT_CANDLE) {
            return VoxelShapes.union(CAKE_SHAPE, BAT_CANDLE_SHAPE);
        }else{
            return VoxelShapes.union(CAKE_SHAPE, CANDLE_SHAPE);
        }
    }

    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        ActionResult actionResult = PumpkinCakeBlock.tryEat(world, pos, this.cake.getDefaultState(), player);
        if (actionResult.isAccepted()) {
            //dropStacks(state, world, pos);
            ItemEntity itemEntity =
                    new ItemEntity(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(),
                            new ItemStack(this.candle, 1));
            world.spawnEntity(itemEntity);
        }

        return actionResult;
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState()
                .with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING,rotation.rotate(state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT, FACING);
    }


    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        return new ItemStack(this.cake);
    }



    public static BlockState getCandleCake(Block candle, Block cake) {
        return CANDLE_CAKES_HASH.get(candle.getName().toString() + "_" + cake.getName().toString()).getDefaultState();
    }

    public static boolean canBeLit(BlockState state) {
        return state.isIn(PumpkinBlockTags.PUMPKIN_CANDLE_CAKES, (statex) -> {
            return statex.contains(LIT) && !(Boolean)state.get(LIT);
        });
    }



}
