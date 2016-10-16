package kr.rvs.colorcrashfix.management;

import org.bukkit.configuration.file.FileConfiguration;

/**
 * Created by deide on 2016-10-15.
 */
public class ConfigManager {
	private static ConfigManager instance;
	private boolean isAllowOp;
	private boolean isKick;

	public ConfigManager(FileConfiguration config) {
		instance = this;
		isAllowOp = config.getBoolean("allow-op");
		isKick = config.getBoolean("kick");
	}

	public static boolean isAllowOp() {
		return instance.isAllowOp;
	}

	public static boolean isKick() {
		return instance.isKick;
	}
}
