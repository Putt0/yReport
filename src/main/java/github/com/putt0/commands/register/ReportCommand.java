package github.com.putt0.commands.register;

import github.com.putt0.commands.BukkitCommand;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReportCommand extends BukkitCommand {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String arg, String[] args) {
        if (this.isPlayer(commandSender)) {

            Player player = (Player) commandSender;
            boolean permission = player.isOp();

            if (command.getName().equalsIgnoreCase("report")) {
                if (args.length == 0) {
                    player.playSound(player.getLocation(), Sound.NOTE_PLING,  2.0F, 1.0F);
                    player.sendMessage("§4§lREPORT §cUsage: /report <player> <type>");
                } else if (args.length == 1) {
                    Player playerTarget = this.getPlayerFromArgs(args[0]);

                    if (player == playerTarget) {
                        player.playSound(player.getLocation(), Sound.VILLAGER_NO, 2.0F, 1.0F);
                        player.sendMessage("§4§lREPORT §cYou can't report yourself.");
                    } else if (playerTarget == null) {
                        player.playSound(player.getLocation(), Sound.VILLAGER_NO, 2.0F, 1.0F);
                        player.sendMessage("§4§lREPORT §cPlayer offline.");
                    } else {
                        player.sendMessage("§2§lREPORT §aYou are reporting: " + playerTarget.getName());
                        player.sendMessage("");
                        player.sendMessage("§aSelect a category:");

                        TextComponent Cheating = new TextComponent("§c* Cheating");
                        Cheating.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/report " + playerTarget.getName() + " Cheating"));
                        Cheating.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§eCategory: §cCheating \n§4[Click to confirm]").create()));

                        player.playSound(player.getLocation(), Sound.LEVEL_UP, 2.0F, 1.0F);
                        player.spigot().sendMessage(Cheating);

                        TextComponent Spam = new TextComponent("§c* Spam");
                        Spam.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/report " + playerTarget.getName() + " Spam"));
                        Spam.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§eCategory: §cSpam \n§4[Click to confirm]").create()));

                        player.playSound(player.getLocation(), Sound.LEVEL_UP, 2.0F, 1.0F);
                        player.spigot().sendMessage(Spam);
                    }
                } else if (args.length == 2) {
                    Player playerTarget = this.getPlayerFromArgs(args[0]);

                    if (player == playerTarget) {
                        player.playSound(player.getLocation(), Sound.VILLAGER_NO, 2.0F, 1.0F);
                        player.sendMessage("§4§lREPORT §cYou can't report yourself.");
                    } else if (playerTarget == null) {
                        player.playSound(player.getLocation(), Sound.VILLAGER_NO, 2.0F, 1.0F);
                        player.sendMessage("§4§lREPORT §cPlayer offline.");
                    } else {
                        player.playSound(player.getLocation(), Sound.LEVEL_UP, 2.0F, 1.0F);
                        player.sendMessage("§2§lREPORT §aYou are reported: " + playerTarget.getName() + " in category: §c" + args[1]);

                        for (Player players : Bukkit.getOnlinePlayers()) {
                            if (permission) {
                                players.playSound(player.getLocation(), Sound.ANVIL_BREAK, 2.0F, 1.0F);

                                TextComponent ReportC = new TextComponent("§2§lREPORT §aA new report for you!");

                                ReportC.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tp " + playerTarget.getName()));
                                ReportC.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§ePlayer: " + player.getName() + " \n§eCategory: §c" + args[1] + " \n\n§4[Click to teleport]").create()));

                                players.spigot().sendMessage(ReportC);
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}