package kr.rvs.colorcrashfix.listeners;

import kr.rvs.colorcrashfix.events.UseCrashColorCodeEvent;
import kr.rvs.colorcrashfix.management.ConfigManager;
import kr.rvs.colorcrashfix.utils.Lang;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * Created by deide on 2016-10-15.
 */
public class ColorCrashListener implements Listener {
	@EventHandler
	public void onTryCrash(UseCrashColorCodeEvent e) {
		Player p = e.getPlayer();
		if (p.isOp() && ConfigManager.isAllowOp()) {
			return;
		}
		String msg = Lang.PREFIX.toString() + Lang.CRASH_DENY;
		if (ConfigManager.isKick()) {
			p.kickPlayer(msg);
		}
		p.sendMessage(msg);
		e.setCancelled(true);
	}
}
