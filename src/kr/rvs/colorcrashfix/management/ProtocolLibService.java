package kr.rvs.colorcrashfix.management;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketAdapter;
import kr.rvs.colorcrashfix.listeners.protocol.CMDPacketAdapter;
import kr.rvs.colorcrashfix.listeners.protocol.ChatPacketAdapter;
import kr.rvs.colorcrashfix.listeners.protocol.SignUpdatePacketAdapter;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.List;

/**
 * Created by deide on 2016-10-16.
 */
public class ProtocolLibService {
	private Plugin plugin;

	public ProtocolLibService(Plugin plugin) {
		this.plugin = plugin;
		init();
	}

	public void init() {
		List<PacketAdapter> adapterList = Arrays.asList(
				new ChatPacketAdapter(plugin),
				new CMDPacketAdapter(plugin),
				new SignUpdatePacketAdapter(plugin)
		);
		for (PacketAdapter adapter : adapterList) {
			ProtocolLibrary.getProtocolManager().addPacketListener(adapter);
		}
	}
}
