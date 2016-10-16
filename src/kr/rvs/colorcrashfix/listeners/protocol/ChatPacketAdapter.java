package kr.rvs.colorcrashfix.listeners.protocol;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import kr.rvs.colorcrashfix.events.CustomEvent;
import kr.rvs.colorcrashfix.events.UseCrashColorCodeEvent;
import kr.rvs.colorcrashfix.management.CustomEventManager;
import org.bukkit.plugin.Plugin;

/**
 * Created by deide on 2016-10-16.
 */
public class ChatPacketAdapter extends PacketAdapter {
	public ChatPacketAdapter(Plugin plugin) {
		super(plugin, ListenerPriority.HIGHEST, PacketType.Play.Client.CHAT);
	}

	@Override
	public void onPacketReceiving(PacketEvent e) {
		if (e.getPacketType() == PacketType.Play.Client.CHAT) {
			PacketContainer packet = e.getPacket();
			String msg = packet.getStrings().read(0);
			if (msg.contains("§k") || msg.contains("&k")) {
				CustomEvent customEvent = new UseCrashColorCodeEvent(e.getPlayer());
				CustomEventManager.callEvent(customEvent);
				e.setCancelled(customEvent.isCancelled());
			}
		}
	}
}