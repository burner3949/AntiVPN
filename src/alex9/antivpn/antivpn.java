package alex9.antivpn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class antivpn implements Listener {
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		if(e.getPlayer().hasPermission("*")) return;
		try {
			URLConnection connection = new URL("https://blackbox.ipinfo.app/lookup/" + e.getPlayer().getAddress().getAddress().getHostAddress()).openConnection();
			connection.connect();
			BufferedReader r = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = r.readLine()) != null){sb.append(line);}
			if(sb.toString().equalsIgnoreCase("Y")) {
				System.out.println(e.getPlayer().getName() + " has been kicked for using a vpn.");
				e.getPlayer().kickPlayer(ChatColor.translateAlternateColorCodes('&', "&7[&cAntiVPN&7] &fUsing an VPN on this server is not allowed."));
			} else if(sb.toString().equalsIgnoreCase("N")) {
				System.out.println(e.getPlayer().getName() + " is not using a vpn.");
			}
		}catch(IOException ex) {
			//whatever
		}
	}
}
