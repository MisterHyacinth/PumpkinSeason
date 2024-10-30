package misterhyacinth.pumpkinseason.block;

import misterhyacinth.pumpkinseason.PumpkinItemRegistry;
import misterhyacinth.pumpkinseason.PumpkinRegistry;
import net.minecraft.block.*;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.Objects;

public class SquashBlock extends PumpkinBlock implements Waterloggable {



    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    protected static VoxelShape SHAPE =
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 16.0);
    private final String squashType;


    public SquashBlock(String squashType, Settings settings) {
        super(settings);
        this.squashType = squashType;
        setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(WATERLOGGED);
    }


    private Block getCarvedSquash() {
        if (Objects.equals(this.squashType, "butternut")) {
            return PumpkinRegistry.CARVED_BUTTERNUT_SQUASH;
        } else if (Objects.equals(this.squashType, "ghost")){
            return PumpkinRegistry.CARVED_GHOST_PUMPKIN;
        } else if (Objects.equals(this.squashType, "kabocha")){
            return PumpkinRegistry.CARVED_KABOCHA;
        } else if (Objects.equals(this.squashType, "midnight")){
            return PumpkinRegistry.CARVED_MIDNIGHT_PUMPKIN;
        } else if (Objects.equals(this.squashType, "mini")){
            return PumpkinRegistry.CARVED_MINI_PUMPKIN;
        } else if (Objects.equals(this.squashType, "sugar")){
            return PumpkinRegistry.CARVED_SUGAR_PUMPKIN;
        } else {
            return Blocks.CARVED_PUMPKIN;
        }
    }

    private Item getSquashSeeds() {
        if (Objects.equals(this.squashType, "butternut")) {
            return PumpkinItemRegistry.BUTTERNUT_SEEDS;
        } else if (Objects.equals(this.squashType, "ghost")){
            return PumpkinItemRegistry.GHOST_PUMPKIN_SEEDS;
        } else if (Objects.equals(this.squashType, "kabocha")){
            return PumpkinItemRegistry.KABOCHA_SEEDS;
        } else if (Objects.equals(this.squashType, "midnight")){
            return PumpkinItemRegistry.MIDNIGHT_PUMPKIN_SEEDS;
        } else if (Objects.equals(this.squashType, "mini")){
            return PumpkinItemRegistry.MINI_PUMPKIN_SEEDS;
        } else if (Objects.equals(this.squashType, "sugar")){
            return PumpkinItemRegistry.SUGAR_PUMPKIN_SEEDS;
        } else {
            return Items.PUMPKIN_SEEDS;
        }
    }

    public StemBlock getStem() {
        if (Objects.equals(this.squashType, "butternut")) {
            return (StemBlock) PumpkinRegistry.BUTTERNUT_STEM;
        } else if (Objects.equals(this.squashType, "ghost")){
            return (StemBlock) PumpkinRegistry.GHOST_PUMPKIN_STEM;
        } else if (Objects.equals(this.squashType, "kabocha")){
            return (StemBlock) PumpkinRegistry.KABOCHA_STEM;
        } else if (Objects.equals(this.squashType, "midnight")){
            return (StemBlock) PumpkinRegistry.MIDNIGHT_PUMPKIN_STEM;
        } else if (Objects.equals(this.squashType, "mini")){
            return (StemBlock) PumpkinRegistry.MINI_PUMPKIN_STEM;
        } else if (Objects.equals(this.squashType, "sugar")){
            return (StemBlock) PumpkinRegistry.SUGAR_PUMPKIN_STEM;
        } else {
            return (StemBlock) Blocks.PUMPKIN_STEM;
        }
    }

    public AttachedStemBlock getAttachedStem() {
        if (Objects.equals(this.squashType, "butternut")) {
            return (AttachedStemBlock) PumpkinRegistry.ATTACHED_BUTTERNUT_STEM;
        } else if (Objects.equals(this.squashType, "ghost")){
            return (AttachedStemBlock) PumpkinRegistry.ATTACHED_GHOST_PUMPKIN_STEM;
        } else if (Objects.equals(this.squashType, "kabocha")){
            return (AttachedStemBlock) PumpkinRegistry.ATTACHED_KABOCHA_STEM;
        } else if (Objects.equals(this.squashType, "midnight")){
            return (AttachedStemBlock) PumpkinRegistry.ATTACHED_MIDNIGHT_PUMPKIN_STEM;
        } else if (Objects.equals(this.squashType, "mini")){
            return (AttachedStemBlock) PumpkinRegistry.ATTACHED_MINI_PUMPKIN_STEM;
        } else if (Objects.equals(this.squashType, "sugar")){
            return (AttachedStemBlock) PumpkinRegistry.ATTACHED_SUGAR_PUMPKIN_STEM;
        } else {
            return (AttachedStemBlock) Blocks.ATTACHED_PUMPKIN_STEM;
        }
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (Objects.equals(this.squashType, "butternut")) {
            return SquashShapes.BUTTERNUT_SHAPE;
        } else if (Objects.equals(this.squashType, "ghost") || Objects.equals(this.squashType, "midnight")){
            return SquashShapes.GHOST_SHAPE;
        } else if (Objects.equals(this.squashType, "kabocha")){
            return SquashShapes.KABOCHA_SHAPE;
        } else if (Objects.equals(this.squashType, "mini")){
            return SquashShapes.MINI_SHAPE;
        } else if (Objects.equals(this.squashType, "sugar")){
            return SquashShapes.SUGAR_SHAPE;
        } else {
            return SHAPE;
        }
    }


    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos,
                                             PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!stack.isOf(Items.SHEARS)) {
            return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
        } else if (world.isClient) {
            return ItemActionResult.success(world.isClient);
        } else {
            Direction direction = hit.getSide();
            Direction direction2 = direction.getAxis() ==
                    Direction.Axis.Y ? player.getHorizontalFacing().getOpposite() : direction;
            world.playSound(null, pos, SoundEvents.BLOCK_PUMPKIN_CARVE,
                    SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.setBlockState(pos, getCarvedSquash().getDefaultState()
                    .with(CarvedPumpkinBlock.FACING, direction2), 11);
            ItemEntity itemEntity =
                    new ItemEntity(world, (double)pos.getX() + 0.5 + (double)direction2.getOffsetX() * 0.65,
                            (double)pos.getY() + 0.1,
                            (double)pos.getZ() + 0.5 + (double)direction2.getOffsetZ() * 0.65,
                            new ItemStack(getSquashSeeds(), 4));
            itemEntity.setVelocity(0.05 * (double)direction2.getOffsetX() + world.random.nextDouble() * 0.02,
                    0.05, 0.05 * (double)direction2.getOffsetZ() + world.random.nextDouble() * 0.02);
            world.spawnEntity(itemEntity);
            stack.damage(1, player, LivingEntity.getSlotForHand(hand));
            world.emitGameEvent(player, GameEvent.SHEAR, pos);
            player.incrementStat(Stats.USED.getOrCreateStat(Items.SHEARS));
            return ItemActionResult.success(world.isClient);
        }
    }


}
