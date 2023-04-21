package github.com.putt0.reasons;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TabCompleteManager implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String arg, String[] args) {
        List<String> Completions = new ArrayList<>();

        List<String> Reasons = new ArrayList<>();

        for (Reason reason : Reason.values()) {
            Reasons.add(reason.name());
        }

        List<String> Players = new ArrayList<>();

        for (Player players : Bukkit.getOnlinePlayers()) {
            Players.add(players.getName());
        }

        if (command.getName().equalsIgnoreCase("report")) {
            if (args.length == 1) {
                StringUtil.copyPartialMatches(args[0], Players, Completions);
                Collections.sort(Completions);
            } else if (args.length == 2) {
                StringUtil.copyPartialMatches(args[1], Reasons, Completions);
                Collections.sort(Completions);
            }
        }
        return Completions;
    }
}