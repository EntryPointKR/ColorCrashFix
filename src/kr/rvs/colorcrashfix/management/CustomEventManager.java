package kr.rvs.colorcrashfix.management;

import kr.rvs.colorcrashfix.events.CustomEvent;
import org.bukkit.plugin.PluginManager;

/**
 * Created by deide on 2016-10-15.
 */
public class CustomEventManager {
	private static CustomEventManager instance;
	private PluginManager pluginManager;

	public CustomEventManager(PluginManager pluginManager) {
		instance = this;
		this.pluginManager = pluginManager;
	}

	public static void callEvent(CustomEvent e) {
		instance.pluginManager.callEvent(e);
	}
}
