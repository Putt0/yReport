package github.com.putt0;

import org.bukkit.plugin.java.JavaPlugin;

public class BukkitMain extends JavaPlugin {

    protected void loadService() {
        try {
            BukkitLoader.plugin = this;
            System.out.print("[yReport] -> Inicializando...");
        } catch (Exception exception) {
            System.out.print("[yReport] -> Ocorreu um erro ao tentar inicializar: (" + exception + ")");
        }
    }

    protected void enableService() {
        try {
            System.out.print("[yReport] -> Iniciado!");
        } catch (Exception exception) {
            System.out.print("[yReport] -> Ocorreu um erro ao inicializar: (" + exception + ")");
        }
    }

    protected void disableService() {
        try {
            System.out.print("[yReport] -> Desligando...");
            BukkitLoader.plugin = null;
        } catch (Exception exception) {
            System.out.print("[yReport] -> Ocorreu um erro ao desligar: (" + exception + ")");
        }
    }
}