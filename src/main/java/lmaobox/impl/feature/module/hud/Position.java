package lmaobox.impl.feature.module.hud;

import lmaobox.impl.api.utility.impl.meteorclient.TextHUDElement;

import meteordevelopment.meteorclient.settings.*;
import meteordevelopment.meteorclient.systems.modules.render.hud.*;

public class Position extends TextHUDElement {

    private final SettingGroup General = settings.getDefaultGroup();

    Setting<Mode> mode = General.add(new EnumSetting.Builder<Mode>()
        .name("mode")
        .defaultValue(Mode.Normal)
        .build()
    );

    private final Setting<String> c1 = General.add(new StringSetting.Builder()
        .name("text-x")
        .description("custom text for X.")
        .defaultValue("You are, ")
		.visible(() -> mode.get() == Mode.Text)
        .build()
    );

    private final Setting<String> c2 = General.add(new StringSetting.Builder()
        .name("text-y")
        .description("custom text for Y.")
        .defaultValue("in, ")
		.visible(() -> mode.get() == Mode.Text)
        .build()
    );

    private final Setting<String> c3 = General.add(new StringSetting.Builder()
        .name("text-z")
        .description("custom text for Z.")
        .defaultValue("hell")
		.visible(() -> mode.get() == Mode.Text)
        .build()
    );

    private final Setting<Integer> spoofX = General.add(new IntSetting.Builder()
        .name("X")
        .description("custom X pos.")
        .defaultValue(0)
        .sliderRange(-30000000, 30000000)
        .visible(() -> mode.get() == Mode.Spoof)
        .build()
    );

    private final Setting<Integer> spoofY = General.add(new IntSetting.Builder()
        .name("Y")
        .description("custom Y pos.")
        .defaultValue(0)
        .sliderRange(-30000000, 30000000)
        .visible(() -> mode.get() == Mode.Spoof)
        .build()
    );

    private final Setting<Integer> spoofZ = General.add(new IntSetting.Builder()
        .name("Z")
        .description("custom Z pos.")
        .defaultValue(0)
        .sliderRange(-30000000, 30000000)
        .visible(() -> mode.get() == Mode.Spoof)
        .build()
    );

    public enum Mode {
        Normal, Spoof, Text
    }

    public Position(HUD hud) {
        super(hud, "position", "displays your position/coordinates in the world.", true);
    }

    // XYZ: [x, y, z].

    @Override
    protected String getLeft() {
        return "XYZ: [";
    }

    @Override
    protected String getRight() {
        assert mc.player != null;
        // coords
        int xc = mc.player.getBlockX();
        int yc = mc.player.getBlockY();
        int zc = mc.player.getBlockZ();

        switch (mode.get()) {
            case Text -> {
                return "" + c1 + c2 + c3;
            }
            case Spoof -> {
                return (xc + spoofX.get()) + ", " + (yc + spoofY.get()) + ", " + (zc + spoofZ.get());
            }
            default -> {
                return xc + ", " + yc + ", " + zc;
            }
        }
    }

    @Override
    protected String getEnd() {
        return "].";
    }
}
