package raika.halseki.raven.common.library.api;

import net.minecraft.util.text.Color;

import javax.annotation.Nullable;

public enum GuardianElementColor {
        RUFUS("\\u00A74", 0xFF0000, "rufus",      "red"),
    CAERULEUM("\\u00A79", 0x0026FF, "caeruleum", "blue"),
      VIRIDIS("\\u00A7a", 0x007F0E, "viridis",  "green");

    public  final String code;
    private final int    hex;
    private final String name;
    private final String dyeName;

    GuardianElementColor(String code, int hex, String name, String dyeName) {
        this.code = code;
        this.hex  = hex;
        this.name = name;
        this.dyeName = dyeName;
    }

    public int getHex() {
        return hex;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getDyeName() {
        return dyeName;
    }
}
