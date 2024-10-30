package misterhyacinth.pumpkinseason.block;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class EerieTinySquashBlock extends TinySquashBlock {
    public EerieTinySquashBlock(Settings settings) {
        super(settings);
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        EerieNoise.play(world, pos, random);
    }
}
