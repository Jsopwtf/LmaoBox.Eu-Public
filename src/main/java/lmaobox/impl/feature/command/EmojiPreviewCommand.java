package lmaobox.impl.feature.command;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.systems.commands.Command;
import meteordevelopment.meteorclient.utils.player.ChatUtils;
import net.minecraft.command.CommandSource;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;

public class EmojiPreviewCommand extends Command {
    public EmojiPreviewCommand() {
        super("emoji", "emoji preview command.");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.executes(context -> {
            ChatUtils.info("> Smile: ☻");
            ChatUtils.info("> Sad: ☹");
            ChatUtils.info("> Peace: ✌");
            ChatUtils.info("> Female gender: ♀");
            ChatUtils.info("> Male gender: ♂");
            ChatUtils.info("> Medic: ⚕");
            ChatUtils.info("> Plane: ✈");
            ChatUtils.info("> Court: ⚖");
            ChatUtils.info("> Heart: ❤");
            ChatUtils.info("> Umbrella: ☂");
            ChatUtils.info("> Sun: ☀");
            ChatUtils.info("> Java: ♨");
            ChatUtils.info("> Phone: ☎");
            ChatUtils.info("> Snowman: ☃");
            ChatUtils.info("> Cloud: ☁");
            ChatUtils.info("> Star: ★");
            ChatUtils.info("> Meteor: ☄");
            ChatUtils.info("> Music: ♪");
            ChatUtils.info("> Mail: ✉");
            ChatUtils.info("> Wheelchair: ♿");
            ChatUtils.info("> Skull: ☠");
            ChatUtils.info("> X: ✖");
            return SINGLE_SUCCESS;
        });
    }
}
