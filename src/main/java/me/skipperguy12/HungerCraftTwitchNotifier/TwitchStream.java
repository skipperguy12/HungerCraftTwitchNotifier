package me.skipperguy12.HungerCraftTwitchNotifier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 
 * Credit to chasechocolate for creating the original version of this class
 * (Modified by skipperguy12)
 * 
 */
public class TwitchStream {
	private String channel;

	private URL url;
	private BufferedReader reader;

	private boolean online = false;

	public TwitchStream(String channel) {
		this.channel = channel;

		refresh();
	}

	public void refresh() {
		try {
			this.url = new URL("http://api.justin.tv/api/stream/list.json?jsonp=&channel=" + channel);
			this.reader = new BufferedReader(new InputStreamReader(url.openStream()));

			if (!(reader.readLine().equals("[]"))) {
				online = true;
			} else {
				online = false;
			}
		} catch (MalformedURLException e) {
			// e.printStackTrace();
		} catch (IOException e) {
			// e.printStackTrace();
		}
	}

	public URL getUrl() {
		return this.url;
	}

	public boolean isOnline() {
		return this.online;
	}

	public String getChannel() {
		return channel;
	}
}