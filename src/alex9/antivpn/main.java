package alex9.antivpn;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements CommandExecutor{
	public static Server plugin;
	public static String currentVersion = "v1.0";
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new antivpn(), this);
		Bukkit.getServer().getPluginManager().getPlugin("AntiVpn");
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("antivpn")) {
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&cAntiVPN&7] &fAntiVPN plugin is running on version: " + currentVersion));
		}
		return true;
	}
}
