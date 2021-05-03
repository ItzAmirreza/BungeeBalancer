package me.deadlight.bungeebalancer.Commands;

import me.deadlight.bungeebalancer.Bungeebalancer;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.protocol.packet.Chat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class LobbyHubCommand extends Command {
    private AtomicBoolean processed = new AtomicBoolean(true) ;
    Random random = new Random();

    public LobbyHubCommand() {
        super("lobby");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (sender instanceof ProxiedPlayer) {

            List<ServerInfo> serverInfos = new ArrayList<>();
            ServerInfo lobby1 = Bungeebalancer.getPlugin().getProxy().getServerInfo("lobby1");
            ServerInfo lobby2 = Bungeebalancer.getPlugin().getProxy().getServerInfo("lobby2");
            ServerInfo lobby3 = Bungeebalancer.getPlugin().getProxy().getServerInfo("lobby3");
            serverInfos.add(lobby1);
            serverInfos.add(lobby2);
            serverInfos.add(lobby3);

            ProxiedPlayer player = (ProxiedPlayer) sender;

            if (serverInfos.contains(player.getServer().getInfo())) {
                player.sendMessage(new TextComponent(ChatColor.RED + "Shoma dar hale hazer dar lobby hastid."));
            } else {
                int rand = random.nextInt(serverInfos.size());
                player.connect(serverInfos.get(rand));
            }


        }

    }

    private List<ServerInfo> getOnlineInfo(List<ServerInfo> serverInfos) {
        List<ServerInfo> onlineServers = new ArrayList<>();
        for (ServerInfo info : serverInfos) {

            info.ping((result, error) -> {

                if (result != null) {

                    onlineServers.add(info);
                    System.out.println("Balancing");

                }
            });
        }

        return onlineServers;
    }



}
