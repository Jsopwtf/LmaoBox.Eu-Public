package lmaobox.impl.feature.module.hud;

import lmaobox.Lmaobox;
import lmaobox.impl.api.utility.impl.meteorclient.TextHUDElement;

import meteordevelopment.meteorclient.settings.*;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.modules.render.hud.HUD;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Watermark extends TextHUDElement {

    private final SettingGroup General = settings.getDefaultGroup();

    private final Setting<String> custom1 = General.add(new StringSetting.Builder()
        .name("first-text")
        .description("the first part of watermark custom text.")
        .defaultValue("Lmao")
        .build()
    );

    private final Setting<String> custom2 = General.add(new StringSetting.Builder()
        .name("second-text")
        .description("the second part of watermark custom text.")
        .defaultValue("Box.Net")
        .build()
    );

    private final Setting<String> custom3 = General.add(new StringSetting.Builder()
        .name("third-text")
        .description("the third part of watermark custom text.")
        .defaultValue(" - " + Lmaobox.VERSION)
        .build()
    );

    private final Setting<String> ectsd = General.add(new StringSetting.Builder()
        .name("simple-day-text")
        .description("text on ordinary days.")
        .defaultValue("Good day for owning nn's")
        .build()
    );

    public Watermark(HUD hud) {
        super(hud, "new-watermark", "displays a lmaobox.ru watermark.", true);
        leftColor = hud.primaryColor.get();
        rightColor = hud.secondaryColor.get();
    }
    @Override
    protected String getLeft() {
        return "" + custom1;
    }

    @Override
    protected String getRight() {
        return custom2 + "" + custom3;
    }

    @Override
    public String getEnd() {
        return "";
    }
}
