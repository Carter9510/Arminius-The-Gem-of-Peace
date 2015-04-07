package com.overrtime.info;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class MonitorInfo {

	public static int RefreshRate;
	
	public MonitorInfo() {
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] devices = env.getScreenDevices();
		for(GraphicsDevice device : devices) {
			RefreshRate = device.getDisplayMode().getRefreshRate();
		}
		
	}
	
}