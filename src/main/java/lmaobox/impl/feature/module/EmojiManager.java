package lmaobox.impl.feature.module;

import lmaobox.Lmaobox;

import meteordevelopment.meteorclient.settings.*;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.events.game.SendMessageEvent;
import meteordevelopment.orbit.EventHandler;

public class EmojiManager extends Module {

    private final SettingGroup General = settings.getDefaultGroup();

    public final Setting<Boolean> enable = General.add(new BoolSetting.Builder()
        .name("enable-emojes")
        .description("enable emojes.")
        .defaultValue(true)
        .build()
    );

    private final Setting<String> smile = General.add(new StringSetting.Builder()
        .name("smile")
        .description("smile emoji.")
        .defaultValue(":notforuse:")
        .visible(enable :: get)
        .build()
    );

    private final Setting<String> sad = General.add(new StringSetting.Builder()
        .name("sad")
        .description("sad emoji.")
        .defaultValue(":notforuse:")
        .visible(enable :: get)
        .build()
    );

    private final Setting<String> peace = General.add(new StringSetting.Builder()
        .name("peace")
        .description("peace emoji.")
        .defaultValue(":notforuse:")
        .visible(enable :: get)
        .build()
    );

    private final Setting<String> femalegender = General.add(new StringSetting.Builder()
        .name("female-gender")
        .description("female gender emoji.")
        .defaultValue(":notforuse:")
        .visible(enable :: get)
        .build()
    );

    private final Setting<String> malegender = General.add(new StringSetting.Builder()
        .name("male-gender")
        .description("male gender emoji.")
        .defaultValue(":notforuse:")
        .visible(enable :: get)
        .build()
    );

    private final Setting<String> medic = General.add(new StringSetting.Builder()
        .name("medic")
        .description("medic emoji.")
        .defaultValue(":notforuse:")
        .visible(enable :: get)
        .build()
    );

    private final Setting<String> plane = General.add(new StringSetting.Builder()
        .name("airplane")
        .description("airplane emoji.")
        .defaultValue(":notforuse:")
        .visible(enable :: get)
        .build()
    );

    private final Setting<String> court = General.add(new StringSetting.Builder()
        .name("court")
        .description("court emoji.")
        .defaultValue(":notforuse:")
        .visible(enable :: get)
        .build()
    );

    private final Setting<String> heart = General.add(new StringSetting.Builder()
        .name("heart")
        .description("heart emoji.")
        .defaultValue(":notforuse:")
        .visible(enable :: get)
        .build()
    );

    private final Setting<String> umbrella = General.add(new StringSetting.Builder()
        .name("umbrella")
        .description("umbrella emoji.")
        .defaultValue(":notforuse:")
        .visible(enable :: get)
        .build()
    );

    private final Setting<String> sun = General.add(new StringSetting.Builder()
        .name("sun")
        .description("sun emoji.")
        .defaultValue(":notforuse:")
        .visible(enable :: get)
        .build()
    );

    private final Setting<String> java = General.add(new StringSetting.Builder()
        .name("java")
        .description("java emoji.")
        .defaultValue(":notforuse:")
        .visible(enable :: get)
        .build()
    );

    private final Setting<String> phone = General.add(new StringSetting.Builder()
        .name("phone")
        .description("phone emoji.")
        .defaultValue(":notforuse:")
        .visible(enable :: get)
        .build()
    );

    private final Setting<String> snowman = General.add(new StringSetting.Builder()
        .name("snow-man")
        .description("snow man emoji.")
        .defaultValue(":notforuse:")
        .visible(enable :: get)
        .build()
    );

    private final Setting<String> cloud = General.add(new StringSetting.Builder()
        .name("cloud")
        .description("cloud emoji.")
        .defaultValue(":notforuse:")
        .visible(enable :: get)
        .build()
    );

    private final Setting<String> star = General.add(new StringSetting.Builder()
        .name("star")
        .description("star emoji.")
        .defaultValue(":notforuse:")
        .visible(enable :: get)
        .build()
    );

    private final Setting<String> meteor = General.add(new StringSetting.Builder()
        .name("meteor")
        .description("meteor emoji.")
        .defaultValue(":notforuse:")
        .visible(enable :: get)
        .build()
    );

    private final Setting<String> music = General.add(new StringSetting.Builder()
        .name("music")
        .description("sosa music baby.")
        .defaultValue(":notforuse:")
        .visible(enable :: get)
        .build()
    );

    private final Setting<String> mail = General.add(new StringSetting.Builder()
        .name("mail")
        .description("mail emoji.")
        .defaultValue(":notforuse:")
        .visible(enable :: get)
        .build()
    );

    private final Setting<String> wheelchair = General.add(new StringSetting.Builder()
        .name("wheelchair")
        .description("wheelchair emoji.")
        .defaultValue(":notforuse:")
        .visible(enable :: get)
        .build()
    );

    private final Setting<String> skull = General.add(new StringSetting.Builder()
        .name("skull")
        .description("skull emoji.")
        .defaultValue(":notforuse:")
        .visible(enable :: get)
        .build()
    );

    private final Setting<String> x = General.add(new StringSetting.Builder()
        .name("X")
        .description("X baby.")
        .defaultValue(":notforuse:")
        .visible(enable :: get)
        .build()
    );

    public EmojiManager() {
        super(Lmaobox.ADD, "emoji-manager", "\"(prefix)emojis\" for preview all emojis.");
    }

    @EventHandler
    private void onMessageSend(SendMessageEvent event) {
        String message = event.message;
        if (enable.get()) message = Emojes(message);
        event.message = message;
    }

    public String Emojes(String emoji) {

        if (emoji.contains(smile.get())) emoji = emoji.replace(smile.get(), "☻");
        if (emoji.contains(sad.get())) emoji = emoji.replace(sad.get(), "☹");
        if (emoji.contains(peace.get())) emoji = emoji.replace(peace.get(), "✌");
        if (emoji.contains(femalegender.get())) emoji = emoji.replace(femalegender.get(), "♀");
        if (emoji.contains(malegender.get())) emoji = emoji.replace(malegender.get(), "♂");
        if (emoji.contains(medic.get())) emoji = emoji.replace(medic.get(), "⚕");
        if (emoji.contains(plane.get())) emoji = emoji.replace(plane.get(), "✈");
        if (emoji.contains(court.get())) emoji = emoji.replace(court.get(), "⚖");
        if (emoji.contains(heart.get())) emoji = emoji.replace(heart.get(), "❤");
        if (emoji.contains(umbrella.get())) emoji = emoji.replace(umbrella.get(), "☂");
        if (emoji.contains(sun.get())) emoji = emoji.replace(sun.get(), "☀");
        if (emoji.contains(java.get())) emoji = emoji.replace(java.get(), "♨");
        if (emoji.contains(phone.get())) emoji = emoji.replace(phone.get(), "☎");
        if (emoji.contains(snowman.get())) emoji = emoji.replace(snowman.get(), "☃");
        if (emoji.contains(cloud.get())) emoji = emoji.replace(cloud.get(), "☁");
        if (emoji.contains(star.get())) emoji = emoji.replace(star.get(), "★");
        if (emoji.contains(meteor.get())) emoji = emoji.replace(meteor.get(), "☄");
        if (emoji.contains(music.get())) emoji = emoji.replace(music.get(), "♪");
        if (emoji.contains(mail.get())) emoji = emoji.replace(mail.get(), "✉");
        if (emoji.contains(wheelchair.get())) emoji = emoji.replace(wheelchair.get(), "♿");
        if (emoji.contains(skull.get())) emoji = emoji.replace(skull.get(), "☠");
        if (emoji.contains(x.get())) emoji = emoji.replace(x.get(), "✖");

        return emoji;

    }


}
