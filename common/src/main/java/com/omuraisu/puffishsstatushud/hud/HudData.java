package com.omuraisu.puffishsstatushud.hud;

public record HudData(
        String id,
        int level,
        int currentExp,
        int requiredExp,
        int pointsLeft,
        int earnedPoints
) {
}