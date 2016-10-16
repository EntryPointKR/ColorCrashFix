package kr.rvs.colorcrashfix.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.player.PlayerEvent;

/**
 * Created by deide on 2016-10-16.
 */
public abstract class CustomEvent extends PlayerEvent implements Cancellable {
	CustomEvent(Player p) {
		super(p);
	}
}
