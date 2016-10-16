package kr.rvs.colorcrashfix.events;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

/**
 * Created by deide on 2016-10-15.
 */
public class UseCrashColorCodeEvent extends CustomEvent {
	private static final HandlerList handlers = new HandlerList();
	private boolean cancel;

	public UseCrashColorCodeEvent(Player who) {
		super(who);
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	public boolean isCancelled() {
		return cancel;
	}

	public void setCancelled(boolean cancel) {
		this.cancel = cancel;
	}
}
