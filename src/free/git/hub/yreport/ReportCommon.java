package free.git.hub.yreport;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import free.git.hub.yreport.command.ReportCommand;
import free.git.hub.yreport.listeners.ServerListeners;
import free.git.hub.yreport.reason.TabCompleteManager;

public class ReportCommon {
	
	/**
	 * Register || Listener's
	 */
	
	public static void registerListener() {
		PluginManager Listeners = Bukkit.getPluginManager();
		Listeners.registerEvents(new ServerListeners(), ReportMain.getInstance());
	}
	
	
	/*
	 * Register || Command's
	 */
	
	public static void registerCommand() {
		Plugin Commands = ReportMain.getInstance();
		((JavaPlugin) Commands).getCommand("reports").setExecutor(new ReportCommand());
		((JavaPlugin) Commands).getCommand("reports").setTabCompleter(new TabCompleteManager());
		
		((JavaPlugin) Commands).getCommand("report").setExecutor(new ReportCommand());
		((JavaPlugin) Commands).getCommand("report").setTabCompleter(new TabCompleteManager());
	}
}
