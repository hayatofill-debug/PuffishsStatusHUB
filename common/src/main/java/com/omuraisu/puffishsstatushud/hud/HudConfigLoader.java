package com.omuraisu.puffishsstatushud.hud;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public final class HudConfigLoader {

    private static final Gson GSON =
            new GsonBuilder()
                    .setPrettyPrinting()
                    .create();


    private HudConfigLoader() {
    }


    public static void load(File configDir) {

        File file = new File(
                configDir,
                "puffishsstatushud.json"
        );


        if (!file.exists()) {
            save(configDir);
            return;
        }


        try (FileReader reader = new FileReader(file)) {

            ConfigData data =
                    GSON.fromJson(reader, ConfigData.class);


            HudConfig.enabled = data.enabled;

            HudConfig.x = data.x;
            HudConfig.y = data.y;

            HudConfig.lineHeight = data.lineHeight;

            HudConfig.shadow = data.shadow;


            HudConfig.skillNameColor =
                    parseColor(data.skillNameColor);

            HudConfig.levelColor =
                    parseColor(data.levelColor);

            HudConfig.expColor =
                    parseColor(data.expColor);

            HudConfig.pointsColor =
                    parseColor(data.pointsColor);


        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    private static int parseColor(String color) {

        if (color.startsWith("#")) {
            color = color.substring(1);
        }

        return (int) Long.parseLong(
                "FF" + color,
                16
        );
    }


    public static void save(File configDir) {

        File file = new File(
                configDir,
                "puffishsstatushud.json"
        );


        try (FileWriter writer =
                     new FileWriter(file)) {


            GSON.toJson(
                    new ConfigData(),
                    writer
            );


        } catch (Exception e) {

            e.printStackTrace();

        }
    }



    private static class ConfigData {

        boolean enabled = true;

        int x = 8;
        int y = 8;

        int lineHeight = 12;

        boolean shadow = true;


        String skillNameColor = "#FFFF55";
        String levelColor = "#FFFFFF";
        String expColor = "#55FF55";
        String pointsColor = "#55FFFF";
    }
}