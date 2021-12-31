package lmaobox.impl.api.utility.impl.meteorclient;

import meteordevelopment.meteorclient.utils.render.color.Color;
import meteordevelopment.meteorclient.systems.modules.render.hud.HUD;
import meteordevelopment.meteorclient.systems.modules.render.hud.modules.HudElement;
import meteordevelopment.meteorclient.systems.modules.render.hud.HudRenderer;

public abstract class TextHUDElement extends HudElement {
    protected Color colorLeft;
    protected Color leftColor;
    protected Color rightColor;
    protected Color right2Color;
    protected Color right3Color;
    protected boolean visible = true;

    private String left, right, end;

    private double leftWidth;
    private double rightWidth;

    public TextHUDElement(HUD hud, String name, String description, boolean defaultActive) {
        super(hud, name, description, defaultActive);
        this.leftColor = hud.primaryColor.get();
        this.colorLeft = hud.secondaryColor.get();
        this.rightColor = hud.secondaryColor.get();
        this.right2Color = hud.secondaryColor.get();
        this.right3Color = hud.secondaryColor.get();
    }

    @Override
    public void update(HudRenderer renderer) {
        left = getLeft();
        right = getRight();
        end = getEnd();
        leftWidth = renderer.textWidth(left);
        rightWidth = renderer.textWidth(right);

        double textWidth = leftWidth + renderer.textWidth(right);

        box.setSize(textWidth + renderer.textWidth(end), renderer.textHeight());
    }

    @Override
    public void render(HudRenderer renderer) {
        if (!visible) return;

        double x = box.getX();
        double y = box.getY();

        renderer.text(left, x, y, leftColor);
        renderer.text(right, x + leftWidth, y, rightColor);
        renderer.text(end, x + leftWidth + rightWidth, y, hud.primaryColor.get());
    }

    protected void setLeft(String left) {
        this.left = left;
        this.leftWidth = 0;
    }

    protected abstract String getLeft();
    protected abstract String getRight();
    protected abstract String getEnd();
}
