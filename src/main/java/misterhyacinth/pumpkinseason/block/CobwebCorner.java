package misterhyacinth.pumpkinseason.block;

import net.minecraft.util.StringIdentifiable;

public enum CobwebCorner implements StringIdentifiable {
    NONE("none"),
    LEFT("left"),
    RIGHT("right"),
    BOTH("both");

    private final String name;

    private CobwebCorner(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public String asString() {
        return this.name;
    }
}
