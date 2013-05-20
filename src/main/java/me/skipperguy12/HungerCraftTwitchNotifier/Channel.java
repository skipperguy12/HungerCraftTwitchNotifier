package me.skipperguy12.HungerCraftTwitchNotifier;

public class Channel {

	private String name;
	private TwitchStream stream;
	
	public Channel(TwitchStream stream) {
		this.stream = stream;
	}

	public TwitchStream getStream() {
		return stream;
	}

	public String getChannelName() {
		return stream.getChannel();
	}

}
