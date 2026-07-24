package com.omuraisu.puffishsstatushud;

import com.omuraisu.puffishsstatushud.hud.HudManager;
import com.omuraisu.puffishsstatushud.hud.HudRenderer;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RenderGuiLayerEvent;
import net.neoforged.neoforge.common.NeoForge;

public class PuffishStatusHUDClient {

    public static void init() {

        NeoForge.EVENT_BUS.addListener(
                PuffishStatusHUDClient::onClientTick
        );

        NeoForge.EVENT_BUS.addListener(
                PuffishStatusHUDClient::onRenderGuiLayer
        );
    }


    private static void onClientTick(ClientTickEvent.Post event) {

        HudManager.update();

    }


    private static void onRenderGuiLayer(RenderGuiLayerEvent.Post event) {

        HudRenderer.render(
                event.getGuiGraphics(),
                HudManager.getData()
        );

    }
}