package lmaobox.impl.feature.command;

import lmaobox.Lmaobox;
import meteordevelopment.meteorclient.systems.commands.Command;
import meteordevelopment.meteorclient.utils.player.ChatUtils;

import net.minecraft.command.CommandSource;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import static com.mojang.brigadier.Command.SINGLE_SUCCESS;

public class AddonInfoCommand extends Command {
    public AddonInfoCommand() {
        super("addon", "send a lmaobox info.");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.executes(context -> {
            ChatUtils.info("> NAME: " + Lmaobox.NAME + ".");
            ChatUtils.info("> VESION: " + Lmaobox.VERSION + ".");
            ChatUtils.info("> AUTHORS: мяучер, Jsopn.");
            return SINGLE_SUCCESS;
        });
    }
}
