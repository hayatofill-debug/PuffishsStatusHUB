package com.omuraisu.puffishsstatushud.mixin;

import net.puffish.skillsmod.client.SkillsClientMod;
import net.puffish.skillsmod.client.data.ClientSkillScreenData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(SkillsClientMod.class)
public interface SkillsClientModAccessor {

    @Accessor(value = "screenData", remap = false)
    ClientSkillScreenData getScreenData();
}