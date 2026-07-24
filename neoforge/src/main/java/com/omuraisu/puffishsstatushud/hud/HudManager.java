package com.omuraisu.puffishsstatushud.hud;

import net.puffish.skillsmod.client.data.ClientCategoryData;
import net.puffish.skillsmod.client.data.ClientSkillScreenData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class HudManager {

    private static final List<HudData> CACHE = new ArrayList<>();

    private HudManager() {
    }
    
    public static void update() {

        ClientSkillScreenData screenData =
                PuffishSkillsAccessor.getScreenData();

        if (screenData == null) {
            return;
        }

        List<ClientCategoryData> categories =
                screenData.streamCategories().toList();

        CACHE.clear();

        for (ClientCategoryData category : categories) {
            CACHE.add(new HudData(
                    category.getConfig().id().getPath(),
                    category.getCurrentLevel(),
                    category.getCurrentExperience(),
                    category.getRequiredExperience(),
                    category.getPointsLeft(),
                    category.getEarnedPoints()
            ));
        }
    }

    public static List<HudData> getData() {
        return Collections.unmodifiableList(CACHE);
    }
}