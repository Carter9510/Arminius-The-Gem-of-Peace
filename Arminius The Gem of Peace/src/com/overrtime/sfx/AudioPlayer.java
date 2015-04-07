package com.overrtime.sfx;

import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class AudioPlayer {

	protected String url;
	protected static Player player;
	
	public AudioPlayer(String url) {
		this.url = url;
		
		InputStream is = getClass().getResourceAsStream(url);
		try {
			player = new Player(is);
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void playAudio() {
		try {
			player.play();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
	}
	
	public static void stopAudio() {
			player.close();
	}
	
}
