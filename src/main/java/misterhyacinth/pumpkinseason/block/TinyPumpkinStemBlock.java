package misterhyacinth.pumpkinseason.block;

import misterhyacinth.pumpkinseason.PumpkinRegistry;
import misterhyacinth.pumpkinseason.item.PumpkinItemKeys;
import net.minecraft.block.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;

public class TinyPumpkinStemBlock extends StemBlock {



    public TinyPumpkinStemBlock(Settings settings) {
        super(PumpkinBlockKeys.TINY_PUMPKIN, PumpkinBlockKeys.ATTACHED_TINY_PUMPKIN_STEM,
                PumpkinItemKeys.TINY_PUMPKIN_SEEDS, settings);
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getBaseLightLevel(pos, 0) >= 9) {
            float f = getAvailableMoisture(this, world, pos);
            if (random.nextInt((int)(25.0F / f) + 1) == 0) {
                int i = state.get(AGE);
                if (i < 7) {
                    state = state.with(AGE, i + 1);
                    world.setBlockState(pos, state, 2);
                } else {
                    Direction direction = Direction.Type.HORIZONTAL.random(random);
                    BlockPos blockPos = pos.offset(direction);
                    BlockState blockState = world.getBlockState(blockPos.down());
                    if (world.getBlockState(blockPos).isAir() && (blockState.isOf(Blocks.FARMLAND) ||
                            blockState.isIn(BlockTags.DIRT))) {
                        Block pumpkinBlock = PumpkinRegistry.TINY_PUMPKIN;
                        Block attachedStemBlock = PumpkinRegistry.ATTACHED_TINY_PUMPKIN_STEM;
                        //int count = random.nextInt(4) + 1;
                        int count = 4;
                        world.setBlockState(blockPos, pumpkinBlock.getDefaultState()
                                .with(TinyPumpkinBlock.COUNT, count));
                        world.setBlockState(pos, attachedStemBlock.getDefaultState()
                                .with(HorizontalFacingBlock.FACING, direction));

                    }
                }
            }

        }
    }

    protected static float getAvailableMoisture(Block block, BlockView world, BlockPos pos) {
        float f = 1.0F;
        BlockPos blockPos = pos.down();

        for(int i = -1; i <= 1; ++i) {
            for(int j = -1; j <= 1; ++j) {
                float g = 0.0F;
                BlockState blockState = world.getBlockState(blockPos.add(i, 0, j));
                if (blockState.isOf(Blocks.FARMLAND)) {
                    g = 1.0F;
                    if ((Integer)blockState.get(FarmlandBlock.MOISTURE) > 0) {
                        g = 3.0F;
                    }
                }

                if (i != 0 || j != 0) {
                    g /= 4.0F;
                }

                f += g;
            }
        }

        BlockPos blockPos2 = pos.north();
        BlockPos blockPos3 = pos.south();
        BlockPos blockPos4 = pos.west();
        BlockPos blockPos5 = pos.east();
        boolean bl = world.getBlockState(blockPos4).isOf(block) || world.getBlockState(blockPos5).isOf(block);
        boolean bl2 = world.getBlockState(blockPos2).isOf(block) || world.getBlockState(blockPos3).isOf(block);
        if (bl && bl2) {
            f /= 2.0F;
        } else {
            boolean bl3 = world.getBlockState(blockPos4.north()).isOf(block) || world.getBlockState(blockPos5.north()).isOf(block) || world.getBlockState(blockPos5.south()).isOf(block) || world.getBlockState(blockPos4.south()).isOf(block);
            if (bl3) {
                f /= 2.0F;
            }
        }

        return f;
    }



}
