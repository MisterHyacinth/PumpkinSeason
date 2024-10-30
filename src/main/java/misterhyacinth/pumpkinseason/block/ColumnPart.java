package misterhyacinth.pumpkinseason.block;

import net.minecraft.util.StringIdentifiable;

public enum ColumnPart implements StringIdentifiable {
    SINGLET("singlet"),
    MIDDLE("middle"),
    TOP("top"),
    BOTTOM("bottom");

    private final String name;

    ColumnPart(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public String asString() {
        return this.name;
    }
}
