package kr.rvs.colorcrashfix;

import kr.rvs.colorcrashfix.listeners.ColorCrashListener;
import kr.rvs.colorcrashfix.management.ConfigManager;
import kr.rvs.colorcrashfix.management.CustomEventManager;
import kr.rvs.colorcrashfix.management.ProtocolLibService;
import kr.rvs.colorcrashfix.utils.Lang;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by EntryPoint on 2016-02-21.
 */
public class ColorCrashFix extends JavaPlugin implements Listener {

	public void onEnable() {
		saveDefaultConfig();
		instantiateService();
		registerEventListeners();
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.isOp()) {
			saveDefaultConfig();
			reloadConfig();
			sender.sendMessage(Lang.PREFIX.toString() + Lang.RELOADED);
		} else {
			sender.sendMessage(Lang.PREFIX.toString() + Lang.PERMISSION_DENIED);
		}
		return false;
	}

	private void instantiateService() {
		new ProtocolLibService(this);
		new CustomEventManager(getServer().getPluginManager());
		new ConfigManager(getConfig());
	}

	private void registerEventListeners(){
		getServer().getPluginManager().registerEvents(new ColorCrashListener(), this);
	}

}