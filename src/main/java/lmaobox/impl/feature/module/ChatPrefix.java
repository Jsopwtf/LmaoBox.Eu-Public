package lmaobox.impl.feature.module;

import lmaobox.Lmaobox;

import meteordevelopment.meteorclient.settings.*;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.utils.player.ChatUtils;

import meteordevelopment.meteorclient.utils.render.color.SettingColor;
import net.minecraft.text.BaseText;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TextColor;
import net.minecraft.util.Formatting;

public class ChatPrefix extends Module {

    private final SettingGroup General = settings.getDefaultGroup();
    private final SettingGroup ColorS = settings.createGroup("Color Settings");
    private final SettingGroup Addons = settings.createGroup("Other Addons");

    private final Setting<Mode> mode = General.add(new EnumSetting.Builder<Mode>()
        .name("mode")
        .description("prefix mods.")
        .defaultValue(Mode.Custom)
        .build()
    );

    private final Setting<String> customSides = General.add(new StringSetting.Builder()
        .name("first-side")
        .description("the third part of watermark custom text.")
        .defaultValue("")
        .visible(() -> mode.get() == Mode.Custom)
        .build()
    );

    private final Setting<String> customPrefix = General.add(new StringSetting.Builder()
        .name("text")
        .description("the third part of watermark custom text.")
        .defaultValue("" + Lmaobox.NAME)
        .visible(() -> mode.get() == Mode.Custom)
        .build()
    );

    private final Setting<String> custom2Sides = General.add(new StringSetting.Builder()
        .name("second-side")
        .description("the third part of watermark custom text.")
        .defaultValue(" >> ")
        .visible(() -> mode.get() == Mode.Custom)
        .build()
    );
    // bruh
    private final Setting<Boolean> meteor = General.add(new BoolSetting.Builder()
        .name("meteor-modules")
        .description("prefix works with meteor modules.")
        .defaultValue(true)
        .build()
    );

    private final Setting<SettingColor> customPrefixColor = ColorS.add(new ColorSetting.Builder()
        .name("prefix-color")
        .defaultValue(new SettingColor(0, 160, 255, 255))
        .visible(() -> mode.get() == Mode.Custom)
        .build()
    );

    private final Setting<SettingColor> customSidesColor = ColorS.add(new ColorSetting.Builder()
        .name("sides-color")
        .defaultValue(new SettingColor(0, 160, 255, 255))
        .visible(() -> mode.get() == Mode.Custom)
        .build()
    );

    // Work in others addons

    private final Setting<Boolean> mrejects = Addons.add(new BoolSetting.Builder()
        .name("meteor-rejects")
        .description("lmaobox prefix works with meteor rejects addon modules.")
        .defaultValue(false)
        .build()
    );

    private final Setting<Boolean> bedtrap = Addons.add(new BoolSetting.Builder()
        .name("bed-trap")
        .description("lmaobox prefix works with bed trap addon modules.")
        .defaultValue(false)
        .build()
    );

    private final Setting<Boolean> ion = Addons.add(new BoolSetting.Builder()
        .name("ion")
        .description("lmaobox prefix works with ion addon modules.")
        .defaultValue(false)
        .build()
    );

    private final Setting<Boolean> orion = Addons.add(new BoolSetting.Builder()
        .name("orion")
        .description("lmaobox prefix works with orion modules.")
        .defaultValue(false)
        .build()
    );

    private final Setting<Boolean> bananaplus = Addons.add(new BoolSetting.Builder()
        .name("banana-plus")
        .description("lmaobox prefix works with banana plus modules.")
        .defaultValue(false)
        .build()
    );

    private final Setting<Boolean> vector = Addons.add(new BoolSetting.Builder()
        .name("vector")
        .description("lmaobox prefix works with vector addon modules.")
        .defaultValue(false)
        .build()
    );

    private final Setting<Boolean> lightswitch = Addons.add(new BoolSetting.Builder()
        .name("lightswitch")
        .description("lmaobox prefix works with lightswitch modules.")
        .defaultValue(false)
        .build()
    );

    private final Setting<Boolean> sortirleak = Addons.add(new BoolSetting.Builder()
        .name("sortirleak")
        .description("lmaobox prefix works with sortirleak modules.")
        .defaultValue(false)
        .build()
    );

    private final Setting<Boolean> karasic = Addons.add(new BoolSetting.Builder()
        .name("karasic")
        .description("lmaobox prefix works with karasic addon modules.")
        .defaultValue(false)
        .build()
    );

    private final Setting<Boolean> skidCladdon = Addons.add(new BoolSetting.Builder()
        .name("crystalCl-addon")
        .description("bruh.")
        .defaultValue(false)
        .build()
    );

    public ChatPrefix() {
        super(Lmaobox.ADD, "chat-prefix", "cool LmaoBox.Net prefix for chat.");
    }

    @Override
    public void onActivate() {
        // Normal
        ChatUtils.registerCustomPrefix("lmaobox", this::getPrefix);
        if (meteor.get()) {
            ChatUtils.registerCustomPrefix("meteordevelopment.meteorclient", this::getPrefix);
        }
        // Other Addons
        if (mrejects.get()) {
            ChatUtils.registerCustomPrefix("anticope.rejects", this::getPrefix);
        }
        if (bedtrap.get()) {
            ChatUtils.registerCustomPrefix("me.bedtrapteam.addon", this::getPrefix);
        }
        if (ion.get()) {
            ChatUtils.registerCustomPrefix("me.ghosttypes.ion", this::getPrefix);
        }
        if (orion.get()) {
            ChatUtils.registerCustomPrefix("me.ghosttypes.orion", this::getPrefix);
        }
        if (bananaplus.get()) {
            ChatUtils.registerCustomPrefix("bplusdevelopment.addons", this::getPrefix);
        }
        if (vector.get()) {
            ChatUtils.registerCustomPrefix("cally72jhb.addon", this::getPrefix);
        }
        if (lightswitch.get()) {
            ChatUtils.registerCustomPrefix("lightswitch", this::getPrefix);
        }
        if (sortirleak.get()) {
            ChatUtils.registerCustomPrefix("mrcrafterz.sortirleak", this::getPrefix);
        }
        if (karasic.get()) {
            ChatUtils.registerCustomPrefix("bedtrap.kiriyaga.karasic", this::getPrefix);
        }
        if (skidCladdon.get()) {
            ChatUtils.registerCustomPrefix("crystal.addons", this::getPrefix);
        }

    }

    public LiteralText getPrefix() {
        BaseText prefix = new LiteralText("");
        LiteralText sides = new LiteralText("");

        switch (mode.get()) {
            default -> {
                sides.setStyle(sides.getStyle().withColor(TextColor.fromRgb(customSidesColor.get().getPacked())));
                sides.setStyle(prefix.getStyle().withColor(TextColor.fromRgb(customPrefixColor.get().getPacked())));
                sides.setStyle(sides.getStyle().withColor(TextColor.fromRgb(customSidesColor.get().getPacked())));
            }
            case Italic -> {
                sides.setStyle(sides.getStyle().withFormatting(Formatting.ITALIC));
                sides.setStyle(prefix.getStyle().withFormatting(Formatting.ITALIC));
            }
            case Bold -> {
                sides.setStyle(sides.getStyle().withFormatting(Formatting.BOLD));
                sides.setStyle(prefix.getStyle().withFormatting(Formatting.BOLD));
            }
            case Obfuscated -> {
                sides.setStyle(sides.getStyle().withFormatting(Formatting.OBFUSCATED));
                sides.setStyle(prefix.getStyle().withFormatting(Formatting.OBFUSCATED));
            }
            case Strikethrough -> {
                sides.setStyle(sides.getStyle().withFormatting(Formatting.STRIKETHROUGH));
                sides.setStyle(prefix.getStyle().withFormatting(Formatting.STRIKETHROUGH));
            }
            case Underline -> {
                sides.setStyle(sides.getStyle().withFormatting(Formatting.UNDERLINE));
                sides.setStyle(prefix.getStyle().withFormatting(Formatting.UNDERLINE));
            }
			case None -> {
				sides.append("");
                sides.append("");
                sides.append("");
			}
        }
        sides.append("" + customSides);
        sides.append("" + customPrefix);
        sides.append("" + custom2Sides);
        return sides;
    }

    public enum Mode {
        Custom,
        Obfuscated,
        Bold,
        Strikethrough,
        Underline,
        Italic,
		None
    }
}
