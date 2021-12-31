package lmaobox.impl.feature.module.hud;

import meteordevelopment.meteorclient.renderer.*;
import meteordevelopment.meteorclient.settings.*;
import meteordevelopment.meteorclient.systems.modules.render.hud.*;
import meteordevelopment.meteorclient.systems.modules.render.hud.modules.HudElement;

import net.minecraft.util.Identifier;

import static meteordevelopment.meteorclient.utils.Utils.WHITE;

public class Logo extends HudElement {

    private final SettingGroup General = settings.getDefaultGroup();

    private final Setting<Double> scale = General.add(new DoubleSetting.Builder()
        .name("scale")
        .description("logo scale.")
        .defaultValue(3)
        .min(0.1)
        .sliderRange(0.1, 10)
        .build()
    );

    private final Identifier TEXTURE = new Identifier("meteor-client", "textures/lmaobox.png");

    public Logo(HUD hud) {
        super(hud, "lmaobox-logo", "shows the lmaobox.net logo in the HUD.");
    }

    @Override
    public void update(HudRenderer renderer) {
        box.setSize(64 * scale.get(), 64 * scale.get());
    }

    @Override
    public void render(HudRenderer renderer) {
        GL.bindTexture(TEXTURE);
        Renderer2D.TEXTURE.begin();
        Renderer2D.TEXTURE.texQuad(box.getX(), box.getY(), box.width, box.height, WHITE);
        Renderer2D.TEXTURE.render(null);
    }

}
