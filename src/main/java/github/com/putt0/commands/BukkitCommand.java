package github.com.putt0.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class BukkitCommand implements CommandExecutor {

    public boolean isPlayer(CommandSender commandSender) {
        return (commandSender instanceof Player);
    }

    public Player getPlayerFromArgs(String player) {
        return Bukkit.getPlayer(player);
    }

    public Player getPlayerFromSender(CommandSender commandSender) {
        return (Player) commandSender;
    }
}