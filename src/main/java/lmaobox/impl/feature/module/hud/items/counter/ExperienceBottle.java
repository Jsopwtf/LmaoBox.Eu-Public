package lmaobox.impl.feature.module.hud.items.counter;

import meteordevelopment.meteorclient.settings.DoubleSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.modules.render.hud.HUD;
import meteordevelopment.meteorclient.systems.modules.render.hud.HudRenderer;
import meteordevelopment.meteorclient.systems.modules.render.hud.modules.HudElement;
import meteordevelopment.meteorclient.utils.player.InvUtils;
import meteordevelopment.meteorclient.utils.render.RenderUtils;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ExperienceBottle extends HudElement {

    private final SettingGroup sgGeneral = settings.getDefaultGroup();

    private final Setting<Double> scale = sgGeneral.add(new DoubleSetting.Builder()
        .name("scale")
        .description("The scale.")
        .defaultValue(2)
        .min(1)
        .sliderRange(1, 5)
        .build()
    );

    public ExperienceBottle(HUD hud) {
        super(hud, "experience-bottles-counter", "displays the amount of ex-bottles in your inventory.", false);
    }

    @Override
    public void update(HudRenderer renderer) {
        box.setSize(16 * scale.get(), 16 * scale.get());
    }

    @Override
    public void render(HudRenderer renderer) {
        double x = box.getX();
        double y = box.getY();

        if (isInEditor()) {
            RenderUtils.drawItem(Items.EXPERIENCE_BOTTLE.getDefaultStack(), (int) x, (int) y, scale.get(), true);
        }
        else if (InvUtils.find(Items.EXPERIENCE_BOTTLE).getCount() > 0) {
            RenderUtils.drawItem(new ItemStack(Items.EXPERIENCE_BOTTLE, InvUtils.find(Items.EXPERIENCE_BOTTLE).getCount()), (int) x, (int) y, scale.get(), true);
        }
    }
}
