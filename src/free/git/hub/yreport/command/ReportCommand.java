package free.git.hub.yreport.command;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import free.git.hub.yreport.ReportMain;

public class ReportCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§4§lCOMMAND §cCommand only available in game.");
			return true;
		}
		
		Player player = (Player)sender;
		
		if (cmd.getName().equalsIgnoreCase("reports")) {
			if (!player.hasPermission("cmd.reports")) {
				player.sendMessage("§4§lREPORT §cYou don't have permission.");
				player.playSound(player.getLocation(), Sound.VILLAGER_NO,  2.0F, 1.0F);
			} else if (args.length == 0) {
				player.sendMessage("§2§lREPORT §cUse: /reports <type>");
				player.playSound(player.getLocation(), Sound.NOTE_PLING,  2.0F, 1.0F);
			} else if (args.length == 1) {
				if (args[0].equalsIgnoreCase("cheating")) {
					player.sendMessage("§2§lREPORT §aAll cheating report's");
					player.sendMessage("");
					player.sendMessage(ReportMain.getInstance().getConfig().getString("Reports.Cheating").replace("&", "§"));
					player.playSound(player.getLocation(), Sound.LEVEL_UP,  2.0F, 1.0F);
				}
			}
		}
		return false;
	}
}