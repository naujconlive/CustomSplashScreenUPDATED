package eu.midnightdust.customsplashscreen;

import eu.midnightdust.customsplashscreen.config.CustomSplashScreenConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;

import java.io.*;
import java.nio.file.*;

public class CustomSplashScreenClient implements ClientModInitializer {
    public static File CONFIG_PATH = new File(FabricLoader.getInstance().getConfigDir() + "/customsplashscreen");
    public static float spinningProgress;

    @Override
    public void onInitializeClient() {
        CustomSplashScreenConfig.init("customsplashscreen", CustomSplashScreenConfig.class);

        ClientTickEvents.END_CLIENT_TICK.register((client -> {
            if (spinningProgress > 1) spinningProgress = 0f;
            spinningProgress = spinningProgress + 0.01f;
        }));
    }

    public static Identifier id(String path) {
        return Identifier.of("customsplashscreen", path);
    }
}
