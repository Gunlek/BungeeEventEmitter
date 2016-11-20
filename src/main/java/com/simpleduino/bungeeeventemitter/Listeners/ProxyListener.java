package com.simpleduino.bungeeeventemitter.Listeners;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by Simple-Duino on 01/07/2016.
 * Copyrights Simple-Duino, all rights reserved
 */

public class ProxyListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PostLoginEvent e)
    {
        ByteArrayOutputStream msgBytes = new ByteArrayOutputStream();
        DataOutputStream msgout = new DataOutputStream(msgBytes);
        try {
            msgout.writeUTF("PlayerJoinProxy");
            msgout.writeUTF(e.getPlayer().getName());
            msgout.writeUTF(e.getPlayer().getUniqueId().toString());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        for(ServerInfo si : ProxyServer.getInstance().getServers().values())
        {
            si.sendData("BungeeCord", msgBytes.toByteArray());
        }
    }

    @EventHandler
    public void onPlayerDisconnect(PlayerDisconnectEvent e)
    {
        ByteArrayOutputStream msgBytes = new ByteArrayOutputStream();
        DataOutputStream msgout = new DataOutputStream(msgBytes);
        try {
            msgout.writeUTF("PlayerLeftProxy");
            msgout.writeUTF(e.getPlayer().getName());
            msgout.writeUTF(e.getPlayer().getUniqueId().toString());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        for(ServerInfo si : ProxyServer.getInstance().getServers().values())
        {
            si.sendData("BungeeCord", msgBytes.toByteArray());
        }
    }
}
