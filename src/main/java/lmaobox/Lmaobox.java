package lmaobox;

import lmaobox.impl.feature.Feature;

import meteordevelopment.meteorclient.MeteorClient;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.config.Config;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;

import net.minecraft.item.Items;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;

public class Lmaobox extends MeteorAddon {

    public static final String NAME = "LmaoBox.Eu";
    public static final String VERSION = "v.1.0.3 X-mas-Edition";

    public static final Logger LOGGER = LogManager.getLogger();
    public static final Category ADD = new Category("LmaoBox.Eu", Items.ENCHANTED_GOLDEN_APPLE.getDefaultStack());

    @Override
    public void onInitialize() {

        LOGGER.info("Start " + NAME + " initializing!");
        startClient();

        MeteorClient.EVENT_BUS.registerLambdaFactory("lmaobox", (lookupInMethod, klass) -> (MethodHandles.Lookup) lookupInMethod.invoke(null, klass, MethodHandles.lookup()));

        Feature.load();

        Config.get().customWindowTitleText = NAME;

        LOGGER.info(NAME + " initializing finished!");
    }

    private void startClient() {
    }

    public void onRegisterCategories() {
        Modules.registerCategory(Lmaobox.ADD);
    }
}
