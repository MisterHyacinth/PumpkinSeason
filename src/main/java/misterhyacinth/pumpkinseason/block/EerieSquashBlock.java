package misterhyacinth.pumpkinseason.block;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class EerieSquashBlock extends CarvedSquashBlock {
    public EerieSquashBlock(String squashType, Settings settings) {
        super(squashType, settings);
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        EerieNoise.play(world, pos, random);
    }
}
