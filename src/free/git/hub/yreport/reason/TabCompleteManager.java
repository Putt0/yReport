package free.git.hub.yreport.reason;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

public class TabCompleteManager implements TabCompleter {
	
	@Override
    public List<String> onTabComplete(CommandSender sender, Command command, String string, String[] args) {
        List<String> Completions = new ArrayList<>();
        
        List<String> Reasons = new ArrayList<>();
        Reasons.add(ReasonList.CHEATING.toString());
        Reasons.add(ReasonList.SPAM.toString());
        
        StringUtil.copyPartialMatches(args[0], Reasons, Completions);
        Collections.sort(Completions);
        
        return Completions;
    }
}