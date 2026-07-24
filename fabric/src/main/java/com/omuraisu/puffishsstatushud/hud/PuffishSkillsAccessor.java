package com.omuraisu.puffishsstatushud.hud;

import com.omuraisu.puffishsstatushud.mixin.SkillsClientModAccessor;
import net.puffish.skillsmod.client.SkillsClientMod;
import net.puffish.skillsmod.client.data.ClientSkillScreenData;

public final class PuffishSkillsAccessor {

    private PuffishSkillsAccessor() {
    }

    public static ClientSkillScreenData getScreenData() {
        SkillsClientMod mod = SkillsClientMod.getInstance();

        if (mod == null) {
            return null;
        }

        return ((SkillsClientModAccessor) mod).getScreenData();
    }
}