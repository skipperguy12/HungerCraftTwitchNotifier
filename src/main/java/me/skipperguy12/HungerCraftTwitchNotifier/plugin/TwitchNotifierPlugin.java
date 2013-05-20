package me.skipperguy12.HungerCraftTwitchNotifier.plugin;

import java.util.ArrayList;

import me.skipperguy12.HungerCraftTwitchNotifier.Channel;
import me.skipperguy12.HungerCraftTwitchNotifier.TwitchStream;
import me.skipperguy12.HungerCraftTwitchNotifier.runnables.ChannelCheckRunnable;
import me.skipperguy12.HungerCraftTwitchNotifier.runnables.DelayedRemoveFromMessaging;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class TwitchNotifierPlugin extends JavaPlugin {

	public ArrayList<Channel> channels = new ArrayList<Channel>();
	public ArrayList<String> messaging = new ArrayList<String>();

	public void onEnable() {
		createChannels();
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new ChannelCheckRunnable(this), 1, 1);
	}

	public void onDisable() {
	}

	public void createChannels() {
		channels.add(new Channel(new TwitchStream("HungerCraftTV")));
	}

	public void Broadcast(String message) {
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (!messaging.contains(p.getName())) {
				p.sendMessage(ChatColor.AQUA + "[HungerCraft] " + ChatColor.RED + message);
				messaging.add(p.getName());
				Bukkit.getScheduler().scheduleSyncDelayedTask(this, new DelayedRemoveFromMessaging(this, p.getName()), 20 * 10);
			}
		}
	}
}
