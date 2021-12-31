package lmaobox.impl.feature;

import lmaobox.impl.feature.command.*;
import lmaobox.impl.feature.module.hud.*;
import lmaobox.impl.feature.module.hud.items.counter.*;
import lmaobox.impl.feature.module.*;

import meteordevelopment.meteorclient.systems.commands.Commands;
import meteordevelopment.meteorclient.systems.commands.Command;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.systems.modules.Modules;
import meteordevelopment.meteorclient.systems.modules.render.hud.HUD;

/* модули добавлять только в алфавитном порядке!1!! :3
   A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z. */

public class Feature {
    public static void load() {
        // Module
        add(new ArrowTrails());
        // - add(new BowMcBomb());
        add(new ChatPrefix());
        add(new ClientTime());
        add(new DiscordPresence());
        add(new EmojiManager());
        // - add(new Nametags());
        add(new RegistrationUtilities());
        add(new Speed());

        // Command
        add(new AddonInfoCommand());
        add(new EmojiPreviewCommand());

        // HUD
        HUD hud = Modules.get().get(HUD.class);

        hud.elements.add(new Logo(hud));
        hud.elements.add(new Position(hud));
        hud.elements.add(new Watermark(hud));
        hud.elements.add(new Welcome(hud));

        hud.elements.add(new Bed(hud));
        hud.elements.add(new EnchantedGoldenApple(hud));
        hud.elements.add(new EndCrystal(hud));
        hud.elements.add(new ExperienceBottle(hud));

    }

    private static void add(Module module) {
        Modules.get().add(module);
    }

    private static void add(Command command) {
        Commands.get().add(command);
    }
}
