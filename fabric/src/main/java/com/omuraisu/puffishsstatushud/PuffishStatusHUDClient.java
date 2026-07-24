package com.omuraisu.puffishsstatushud;

import com.omuraisu.puffishsstatushud.hud.HudManager;
import com.omuraisu.puffishsstatushud.hud.HudRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class PuffishStatusHUDClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        ClientTickEvents.END_CLIENT_TICK.register(client -> {

            if (client.player != null) {
                HudManager.update();
            }

        });


        HudRenderCallback.EVENT.register((graphics, deltaTracker) -> {

            HudRenderer.render(
                    graphics,
                    HudManager.getData()
            );

        });
    }
}