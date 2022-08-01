package free.git.hub.yreport.command;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import free.git.hub.yreport.ReportMain;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

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
				player.sendMessage("§4§lREPORT §cUse: /reports <type>");
				player.playSound(player.getLocation(), Sound.NOTE_PLING,  2.0F, 1.0F);
			} else if (args.length == 1) {
				if (args[0].equalsIgnoreCase("cheating")) {
					player.sendMessage("§2§lREPORT §aAll cheating report's");
					player.sendMessage("");
					player.sendMessage(ReportMain.getInstance().getConfig().getString("Reports.Cheating").replace("&", "§"));
					player.playSound(player.getLocation(), Sound.LEVEL_UP,  2.0F, 1.0F);
				} else if (args[0].equalsIgnoreCase("spam")) {
					player.sendMessage("§2§lREPORT §aAll spam report's");
					player.sendMessage("");
					player.sendMessage(ReportMain.getInstance().getConfig().getString("Reports.Spam").replace("&", "§"));
					player.playSound(player.getLocation(), Sound.LEVEL_UP,  2.0F, 1.0F);
				}
			}
		} else if (cmd.getName().equalsIgnoreCase("report")) {
			if (args.length == 0) {
				player.sendMessage("§4§lREPORT §cUse: /report <player>");
				player.playSound(player.getLocation(), Sound.NOTE_PLING,  2.0F, 1.0F);
			} else if (args.length == 1) {
				Player player2 = Bukkit.getPlayer(args[0]);
				Player target = Bukkit.getPlayer(args[0]);
				if (player == player2) {
					player.sendMessage("§4§lREPORT §cYou can't report yourself.");
					player.playSound(player.getLocation(), Sound.VILLAGER_NO,  2.0F, 1.0F);
				} else if (target == null) {
					player.sendMessage("§4§lREPORT §cPlayer offline.");
					player.playSound(player.getLocation(), Sound.VILLAGER_NO,  2.0F, 1.0F);
				} else {
					player.sendMessage("§2§lREPORT §aYou are reporting: " + target.getName());
					player.sendMessage("");
					player.sendMessage("§aSelect a category:");
					
                    TextComponent Cheating = new TextComponent("§c* Cheating");
                    Cheating.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§eCategory: §cCheating \n§4[Click to confirm]").create()));
					
					player.spigot().sendMessage((BaseComponent)Cheating);
					
					TextComponent Spam = new TextComponent("§c* Spam");
                    Spam.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§eCategory: §cSpam \n§4[Click to confirm]").create()));
					
					player.spigot().sendMessage((BaseComponent)Spam);
					player.playSound(player.getLocation(), Sound.LEVEL_UP,  2.0F, 1.0F);
				}
			}
		}
		return false;
	}
}