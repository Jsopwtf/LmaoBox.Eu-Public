package lmaobox.impl.feature.module;

import lmaobox.Lmaobox;

import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.settings.*;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;

public class RegistrationUtilities extends Module {

    private final SettingGroup General = settings.getDefaultGroup();
    private final SettingGroup Login = settings.createGroup("Login");
    private final SettingGroup Reg = settings.createGroup("Register");

    private final Setting<String> password = General.add(new StringSetting.Builder()
        .name("password")
        .description("sent here your password.")
        .defaultValue("Sent here your password!")
        .build()
    );

    private final Setting<Integer> delay = General.add(new IntSetting.Builder()
        .name("delay")
        .description("time period after registration.")
        .defaultValue(0)
        .min(0)
        .sliderMax(100)
        .build()
    );

    private final Setting<Boolean> enableAutoLogin = Login.add(new BoolSetting.Builder()
        .name("enable-auto-login")
        .description("enable auto login.")
        .defaultValue(true)
        .build()
    );

    private final Setting<Boolean> enableAutoRegistration = Reg.add(new BoolSetting.Builder()
        .name("enable-auto-registration")
        .description("enable auto registration.")
        .defaultValue(false)
        .build()
    );

    private final Setting<Register> registrationMode = Reg.add(new EnumSetting.Builder<Register>()
        .name("registration-mode")
        .description("registration mode.")
        .defaultValue(Register.Double)
        .visible(enableAutoRegistration :: get)
        .build()
    );

    public RegistrationUtilities(){
        super(Lmaobox.ADD, "registration-utilities", "auto registration and login in one module, good work!");
    }

    @EventHandler
    private void onTick(TickEvent.Post event) {
        if (enableAutoRegistration.get()) {
            switch (registrationMode.get()) {
                case Single: {
                    mc.player.sendChatMessage("/register " + password);
                }
                case Double: {
                    mc.player.sendChatMessage("/register " + password + " " + password);
                }
            }
        }

        if (enableAutoLogin.get()) {
            mc.player.sendChatMessage("/login " + password);
        }
        toggle();
    }

    public enum Register {
        Single,
        Double
    }
}
