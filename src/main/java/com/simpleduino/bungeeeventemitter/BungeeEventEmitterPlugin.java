package com.simpleduino.bungeeeventemitter;

import com.simpleduino.bungeeeventemitter.Listeners.ProxyListener;
import net.md_5.bungee.api.plugin.Plugin;

/**
 * Created by Simple-Duino on 01/07/2016.
 * Copyrights Simple-Duino, all rights reserved
 */

public class BungeeEventEmitterPlugin extends Plugin {

    @Override
    public void onEnable()
    {
        getLogger().info("Hello World ! Bungee Event Emitter seems to be loaded");
        this.getProxy().getPluginManager().registerListener(this, new ProxyListener());

        //sendData(String channel, byte[] data, boolean queue)
    }
}
