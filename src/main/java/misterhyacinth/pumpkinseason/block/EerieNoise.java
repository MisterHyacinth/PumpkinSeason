package misterhyacinth.pumpkinseason.block;

import misterhyacinth.pumpkinseason.PumpkinSeason;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class EerieNoise {

    public static void play(World world, BlockPos pos, Random random) {
        if (random.nextInt(10) == 0) {
            world.playSound((double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5,
                    PumpkinSeason.EERIE_AMBIENT_SOUND, SoundCategory.BLOCKS,
                    0.5F + random.nextFloat(), random.nextFloat() * 0.7F + 0.6F, false);
        }
    }


}
