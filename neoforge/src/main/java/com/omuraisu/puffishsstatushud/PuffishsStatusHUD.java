package com.omuraisu.puffishsstatushud;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod("puffishsstatushud")
public class PuffishsStatusHUD {

    public PuffishsStatusHUD(IEventBus modEventBus) {

        Constants.LOG.info(
                "Initializing PuffishStatusHUD for NeoForge"
        );

        modEventBus.addListener(
                this::onClientSetup
        );
    }


    private void onClientSetup(FMLClientSetupEvent event) {

        event.enqueueWork(PuffishStatusHUDClient::init);
    }
}