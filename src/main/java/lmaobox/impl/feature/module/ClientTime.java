package lmaobox.impl.feature.module;

import lmaobox.Lmaobox;

import lmaobox.impl.feature.module.hud.Welcome;
import meteordevelopment.meteorclient.events.packets.PacketEvent;
import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.settings.*;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.network.packet.s2c.play.WorldTimeUpdateS2CPacket;

public class ClientTime extends Module {

    private final SettingGroup General = settings.getDefaultGroup();

    private final Setting<Gamemode> gamemode = General.add(new EnumSetting.Builder<Gamemode>()
        .name("gamemode")
        .description("gamemode mode.")
        .defaultValue(Gamemode.Survival)
        .build()
    );

    public final Setting<Double> custom2 = General.add(new DoubleSetting.Builder()
        .name("custom-time")
        .description("in-game time changer.")
        .defaultValue(18000)
        .min(0)
        .sliderMin(0)
        .sliderMax(24000)
        .visible(() -> gamemode.get() == Gamemode.Creative)
        .build()
    );

    public final Setting<Double> custom = General.add(new DoubleSetting.Builder()
        .name("custom-time")
        .description("in-game time changer.")
        .defaultValue(18000)
        .min(0)
        .sliderMin(0)
        .sliderMax(24000)
        .visible(() -> gamemode.get() == Gamemode.Survival)
        .build()
    );

    public ClientTime() {
        super(Lmaobox.ADD, "client-time", "allows you to switch game time.");
    }

    @EventHandler
    private void onTick(TickEvent.Post event) {
        assert mc.world != null;
        switch (gamemode.get()) {
            case Creative: {
                mc.player.sendChatMessage("/time set " + custom2.get().longValue());
                toggle();
            }
            case Survival: {
                mc.world.setTimeOfDay(custom.get().longValue());
            }
        }
    }

    @EventHandler
    private void onPacketReceive(PacketEvent.Receive event) {
        if (event.packet instanceof WorldTimeUpdateS2CPacket) {
            event.setCancelled(true);
        }
    }

    public enum Gamemode {
        Creative,
        Survival
    }
}


