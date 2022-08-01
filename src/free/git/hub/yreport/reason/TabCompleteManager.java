package free.git.hub.yreport.reason;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

public class TabCompleteManager implements TabCompleter {
	
	@Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String string, String[] args) {
        List<String> Completions = new ArrayList<>();
        
        List<String> Reasons = new ArrayList<>();
        Reasons.add(ReasonList.CHEATING.toString());
        Reasons.add(ReasonList.SPAM.toString());
        
        if (cmd.getName().equalsIgnoreCase("reports")) {
        	StringUtil.copyPartialMatches(args[0], Reasons, Completions);
            Collections.sort(Completions);
        }
        
        List<String> Players = new ArrayList<>();
        for (Player player : Bukkit.getOnlinePlayers()) {
        	Players.add(player.getName());
        }
        
        if (cmd.getName().equalsIgnoreCase("report")) {
        	if (args.length == 1) {
        		StringUtil.copyPartialMatches(args[0], Players, Completions);
                Collections.sort(Completions);
        	}
        }
		return Completions;
	}
}