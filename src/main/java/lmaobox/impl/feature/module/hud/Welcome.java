package lmaobox.impl.feature.module.hud;

import lmaobox.Lmaobox;
import lmaobox.impl.api.utility.impl.meteorclient.TextHUDElement;

import meteordevelopment.meteorclient.settings.*;
import meteordevelopment.meteorclient.systems.modules.Modules;
import meteordevelopment.meteorclient.systems.modules.misc.NameProtect;
import meteordevelopment.meteorclient.systems.modules.render.hud.HUD;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Welcome extends TextHUDElement {

    private final SettingGroup General = settings.getDefaultGroup();

    private final Setting<Mode> mode = General.add(new EnumSetting.Builder<Mode>()
        .name("mode")
        .description("message mods.")
        .defaultValue(Mode.Custom)
        .build()
    );

    private final Setting<String> custom = General.add(new StringSetting.Builder()
        .name("first-part")
        .description("custom welcome message.")
        .defaultValue("You got Lmaoboxed")
        .visible(() -> mode.get() == Mode.Custom)
        .build()
    );

    private final Setting<String> custom2 = General.add(new StringSetting.Builder()
        .name("end-part")
        .description("custom welcome end.")
        .defaultValue("!")
        .visible(() -> mode.get() == Mode.Custom)
        .build()
    );

    private final Setting<String> ectny = General.add(new StringSetting.Builder()
        .name("new-year-text")
        .description("text on new year days.")
        .defaultValue("Happy New Year")
        .visible(() -> mode.get() == Mode.Events)
        .build()
    );

    private final Setting<String> ectch = General.add(new StringSetting.Builder()
        .name("christmas-text")
        .description("text on christmas days.")
        .defaultValue("Merry Christmas")
        .visible(() -> mode.get() == Mode.Events)
        .build()
    );

    private final Setting<String> ecthw = General.add(new StringSetting.Builder()
        .name("halloween-text")
        .description("text on halloween days.")
        .defaultValue("Happy Halloween")
        .visible(() -> mode.get() == Mode.Events)
        .build()
    );

    public Welcome(HUD hud) {
        super(hud, "welcome-module", "displays a welcome message.", true);
        rightColor = hud.secondaryColor.get();
    }

    @Override
    protected String getLeft() {
        switch (mode.get()) {
            default -> {
                if (Modules.get().isActive(NameProtect.class)) return custom + ", ";
                else return custom + ", ";
            }
            case Addon -> {
                if (Modules.get().isActive(NameProtect.class)) return "Welcome to " + Lmaobox.NAME + ", ";
                else return "Welcome to " + Lmaobox.NAME + ", ";
            }
            case WorldTime -> {
                if (Modules.get().isActive(NameProtect.class)) return getHour() + ", ";
                else return getHour() + ", ";
            }
            case Events -> {
                if (Modules.get().isActive(NameProtect.class)) return getDayEvents() + ", ";
                else return getDayEvents() + ", ";
            }
        }
    }

    @Override
    protected String getRight() {
        return Modules.get().get(NameProtect.class).getName(mc.getSession().getUsername());
    }

    @Override
    public String getEnd() {
        return "" + custom2;
    }

    private String getHour() {
        final String hourDate = new SimpleDateFormat("k").format(new Date());
        final int hour = Integer.valueOf(hourDate);
        if (hour < 6) return "Good Night";
        if (hour < 12) return "Good Morning";
        if (hour < 17) return "Good Afternoon";
        if (hour < 20) return "Good Evening";
        return "Good Night";
    }

    private String getDayEvents() {
        final String day = new SimpleDateFormat("D").format(new Date());
        final int d = Integer.valueOf(day);
        if (d < 5) return "" + ectny;
        if (d < 290) return "" + custom;
        if (d < 310) return "" + ecthw;
        if (d < 351) return "" + custom;
        if (d < 359) return "" + ectch;
        return "" + ectny;
    }

    public enum Mode {
        Custom,
        Addon,
        WorldTime,
        Events
    }
}
