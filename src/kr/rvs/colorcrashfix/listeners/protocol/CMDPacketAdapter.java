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
public class CMDPacketAdapter extends PacketAdapter {
	public CMDPacketAdapter(Plugin plugin) {
		super(plugin, ListenerPriority.HIGHEST, PacketType.Play.Client.CLIENT_COMMAND);
	}

	@Override
	public void onPacketReceiving(PacketEvent e) {
		if (e.getPacketType() == PacketType.Play.Client.CLIENT_COMMAND) {
			PacketContainer packet = e.getPacket();
			try {
				String cmd = packet.getStrings().read(0);
				if (cmd.contains("§k") || cmd.contains("&k")) {
					CustomEvent customEvent = new UseCrashColorCodeEvent(e.getPlayer());
					CustomEventManager.callEvent(customEvent);
					e.setCancelled(customEvent.isCancelled());
				}
			}catch(Exception ex){}
		}
	}
}
