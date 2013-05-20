package me.skipperguy12.HungerCraftTwitchNotifier.runnables;

import me.skipperguy12.HungerCraftTwitchNotifier.plugin.TwitchNotifierPlugin;

public class DelayedRemoveFromMessaging implements Runnable {
	String name;
	TwitchNotifierPlugin plugin;

	public DelayedRemoveFromMessaging(TwitchNotifierPlugin plugin, String a) {
		this.plugin = plugin;
		this.name = a;
	}

	public void run() {
		if (plugin.messaging.contains(this.name))
			plugin.messaging.remove(this.name);
	}
}
