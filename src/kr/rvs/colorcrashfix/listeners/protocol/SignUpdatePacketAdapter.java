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
public class SignUpdatePacketAdapter extends PacketAdapter {
	public SignUpdatePacketAdapter(Plugin plugin) {
		super(plugin, ListenerPriority.HIGHEST, PacketType.Play.Server.UPDATE_SIGN);
	}

	@Override
	public void onPacketSending(PacketEvent e) {
		if (e.getPacketType() == PacketType.Play.Server.UPDATE_SIGN) {
			PacketContainer packet = e.getPacket();
			String[] strArr = packet.getStringArrays().read(0);
			for (String str : strArr) {
				if (str.contains("§k") || str.contains("&k")) {
					CustomEvent customEvent = new UseCrashColorCodeEvent(e.getPlayer());
					CustomEventManager.callEvent(customEvent);
					e.setCancelled(customEvent.isCancelled());
				}
			}
		}
	}
}
