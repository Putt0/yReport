package free.git.hub.yreport;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import free.git.hub.yreport.command.ReportCommand;
import free.git.hub.yreport.reason.TabCompleteManager;

public class ReportCommon {
	
	/*
	 * Register || Command's
	 */
	
	public static void registerCommand() {
		Plugin Commands = ReportMain.getInstance();
		((JavaPlugin) Commands).getCommand("report").setExecutor(new ReportCommand());
		((JavaPlugin) Commands).getCommand("report").setTabCompleter(new TabCompleteManager());
	}
}
