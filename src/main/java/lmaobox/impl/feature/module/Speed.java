package lmaobox.impl.feature.module;

import lmaobox.Lmaobox;

import meteordevelopment.meteorclient.events.game.GameLeftEvent;
import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.events.entity.player.JumpVelocityMultiplierEvent;
import meteordevelopment.meteorclient.events.entity.player.PlayerMoveEvent;
import meteordevelopment.meteorclient.utils.player.PlayerUtils;
import meteordevelopment.meteorclient.settings.BoolSetting;
import meteordevelopment.meteorclient.settings.DoubleSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.modules.Modules;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.systems.modules.world.Timer;
import meteordevelopment.orbit.EventHandler;

import net.minecraft.client.option.KeyBinding;

public class Speed extends Module {

    private final SettingGroup General = settings.getDefaultGroup();
    private final SettingGroup Auto = settings.createGroup("Auto Settings");

    private final Setting<Double> yheight = General.add(new DoubleSetting.Builder()
        .name("Y-height")
        .description("Y-axis height value.")
        .defaultValue(0.3)
        .min(0)
        .build()
    );
    
    public final Setting<Double> timer = General.add(new DoubleSetting.Builder()
        .name("timer-value")
        .description("the timer multiplier amount.")
        .defaultValue(1.2)
        .min(0.01)
        .sliderMin(0.01)
        .sliderMax(10)
        .build()
    );

    private final Setting<Boolean> disableOnLeave = General.add(new BoolSetting.Builder()
        .name("disable-on-leave")
        .description("disable on leave.")
        .defaultValue(true)
        .build()
    );

    private final Setting<Boolean> StepUpgrader = General.add(new BoolSetting.Builder()
        .name("step-upgrader")
        .description("upgrade your step.")
        .defaultValue(true)
        .build()
    );

    private final Setting<Boolean> WalkForward = Auto.add(new BoolSetting.Builder()
        .name("auto-walk")
        .description("enable auto walk.")
        .defaultValue(false)
        .build()
    );

    private final Setting<Boolean> AutoJump = Auto.add(new BoolSetting.Builder()
        .name("auto-jump")
        .description("enable auto jump.")
        .defaultValue(true)
        .build()
    );

    private final Setting<Boolean> Sprint = Auto.add(new BoolSetting.Builder()
        .name("auto-sprint")
        .description("enable auto sprint.")
        .defaultValue(true)
        .build()
    );

    public Speed() {
        super(Lmaobox.ADD, "Speed-+", "Y-axis speed.");
    }

    @Override
    public void onActivate() {
        if (StepUpgrader.get()) {
            mc.options.autoJump = true;
        }
    }
    @Override
    public void onDeactivate() {
        if (StepUpgrader.get()) {
            mc.options.autoJump = false;
        }
        Modules.get().get(Timer.class).setOverride(Timer.OFF);
        if (WalkForward.get()) unpress();
    }

    @EventHandler
    private void onPlayerMove(PlayerMoveEvent event) {
        Modules.get().get(Timer.class).setOverride(PlayerUtils.isMoving() ? timer.get() : Timer.OFF);
    }

    private void unpress() {
        setPressed(mc.options.keyForward, false);
    }

    @EventHandler
    private void onTick(TickEvent.Pre event) {
        if (Sprint.get()) {
            mc.player.setSprinting(true);
        }
		if (WalkForward.get()) {
            setPressed(mc.options.keyForward, true);
        }
        if (AutoJump.get()) {
            if (mc.player.isOnGround()) mc.player.jump();
        }
    }

    private void setPressed(KeyBinding key, boolean pressed) {
        key.setPressed(pressed);
    }

    @EventHandler
    private void onJumpVelocityMultiplier(JumpVelocityMultiplierEvent event) {
        event.multiplier *= yheight.get();
    }

    @EventHandler
    private void onGameLeft(GameLeftEvent event) {
        if (disableOnLeave.get()) toggle();
    }

}


