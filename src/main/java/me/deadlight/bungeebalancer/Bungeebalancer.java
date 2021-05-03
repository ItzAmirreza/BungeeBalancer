package me.deadlight.bungeebalancer;

import me.deadlight.bungeebalancer.Commands.LobbyHubCommand;
import me.deadlight.bungeebalancer.Listeners.OnBungeeCommandExecution;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.plugin.Plugin;

public final class Bungeebalancer extends Plugin {

    private static Bungeebalancer plugin;

    public static Bungeebalancer getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;

        // Plugin startup logic
        getProxy().getPluginManager().registerCommand(this, new LobbyHubCommand());
        getProxy().getPluginManager().registerListener(this, new OnBungeeCommandExecution());
        getProxy().getConsole().sendMessage(ChatColor.translateAlternateColorCodes('&', "&aBungeeBalancer load shod. By Dead_Light"));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
