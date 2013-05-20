package me.skipperguy12.HungerCraftTwitchNotifier.runnables;

import me.skipperguy12.HungerCraftTwitchNotifier.Channel;
import me.skipperguy12.HungerCraftTwitchNotifier.plugin.TwitchNotifierPlugin;

public class ChannelCheckRunnable implements Runnable {
	TwitchNotifierPlugin plugin;

	public ChannelCheckRunnable(TwitchNotifierPlugin instance) {
		this.plugin = instance;
	}

	@Override
	public void run() {
		for (Channel c : plugin.channels) {
			c.getStream().refresh();
			if (c.getStream().isOnline()) {
				plugin.Broadcast("Live streaming at twitch.tv/" + c.getChannelName() + "! Join us now!");
			}
		}
	}

}
