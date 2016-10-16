package kr.rvs.colorcrashfix.utils;

import org.bukkit.ChatColor;

/**
 * Created by deide on 2016-10-15.
 */
public enum Lang {
	PREFIX("&c&l[ ColorCrashFix ] &f"),
	RELOADED("리로드되었습니다."),
	PERMISSION_DENIED("권한이 없습니다."),
	INVALID_CONFIG("config.yml 에 문제가 생겼습니다. config.yml 을 지우신 후 /ccfreload 해주세요"),
	CRASH_DENY("취약 색코드를 차단했습니다.");

	private final String def;

	Lang(String s) {
		def = s;
	}

	@Override
	public String toString() {
		return ChatColor.translateAlternateColorCodes('&', def);
	}
}
