package me.deadlight.bungeebalancer.Listeners;

import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class OnBungeeCommandExecution implements Listener {

    @EventHandler
    public void onExecute(ChatEvent event) {

        if (event.isProxyCommand()) {
            if (event.getMessage().equalsIgnoreCase("/Lobby1")) {
                event.setCancelled(true);
            } else if (event.getMessage().equalsIgnoreCase("/Lobby2")) {
                event.setCancelled(true);
            } else if (event.getMessage().equalsIgnoreCase("/Lobby3")) {
                event.setCancelled(true);
            }
        }
    }

}
