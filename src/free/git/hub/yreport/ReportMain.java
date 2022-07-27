package free.git.hub.yreport;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ReportMain extends JavaPlugin {

	private static Plugin instance;
	
    public static Plugin getInstance() {
        return instance;
    }
	
	@Override
	public void onLoad() {
		instance = this;
		saveDefaultConfig();
		System.out.println("[yReport] Loading...");
	}
	
	@Override
	public void onEnable() {
		ReportCommon.registerListener();
		ReportCommon.registerCommand();
		System.out.println("[yReport] Enabled.");
	}
	
	@Override
	public void onDisable() {
		instance = null;
		
		for (Player player : Bukkit.getOnlinePlayers()) {
			player.kickPlayer("§cThis server is unavailable.");
		}
		
		System.out.println("[yReport] Disabled.");
	}
}