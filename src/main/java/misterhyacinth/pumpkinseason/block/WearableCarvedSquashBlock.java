package misterhyacinth.pumpkinseason.block;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Equipment;

public class WearableCarvedSquashBlock extends CarvedSquashBlock implements Equipment {

    public WearableCarvedSquashBlock(String squashType, Settings settings) {
        super(squashType, settings);
    }

    @Override
    public EquipmentSlot getSlotType() {
       return EquipmentSlot.HEAD;
    }
}
