package misterhyacinth.pumpkinseason.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FacingBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.Direction;

public class PillarCapBlock extends FacingBlock {
    public PillarCapBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.UP));
    }

    @Override
    protected MapCodec<? extends FacingBlock> getCodec() {
        return null;
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.with(FACING, mirror.apply(state.get(FACING)));
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction direction = ctx.getSide();
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos().offset(direction.getOpposite()));
        return blockState.isOf(this) && blockState.get(FACING) == direction ?
                this.getDefaultState().with(FACING, direction.getOpposite()) :
                this.getDefaultState().with(FACING, direction);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }


}
