package com.omuraisu.puffishsstatushud.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

import java.util.List;

public final class HudRenderer {

    private HudRenderer() {
    }

    public static void render(
            GuiGraphics graphics,
            List<HudData> dataList
    ) {

        Minecraft mc = Minecraft.getInstance();

        int x = HudConfig.x;
        int y = HudConfig.y;

        for (HudData data : dataList) {

            MutableComponent text = Component.empty()
                    .append(
                            Component.literal(data.id())
                                    .withColor(HudConfig.skillNameColor)
                    )
                    .append(
                            Component.literal(" Lv ")
                                    .withColor(HudConfig.levelColor)
                    )
                    .append(
                            Component.literal(String.valueOf(data.level()))
                                    .withColor(HudConfig.levelColor)
                    )
                    .append(
                            Component.literal(
                                            " [EXP " + data.currentExp()
                                                    + "/" + data.requiredExp() + "]"
                                    )
                                    .withColor(HudConfig.expColor)
                    )
                    .append(
                            Component.literal(
                                            " [Points " + data.pointsLeft()
                                                    + "/" + data.earnedPoints() + "]"
                                    )
                                    .withColor(HudConfig.pointsColor)
                    );

            graphics.drawString(
                    mc.font,
                    text,
                    x,
                    y,
                    HudConfig.textColor,
                    HudConfig.shadow
            );

            y += HudConfig.lineHeight;
        }
    }
}