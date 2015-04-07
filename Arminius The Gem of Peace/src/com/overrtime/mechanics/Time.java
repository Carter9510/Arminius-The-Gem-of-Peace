package com.overrtime.mechanics;

public class Time {

	public static int hour = 0;
	public static int minute = 0;
	public static int second = 0;
	public static int tickNext = 100;
	public static int currentTick = 50;
	public static String timeString = "";
	
	public static boolean am = true, pm = false;
	public static String type  ="A.M";
	
	public void tick()throws Exception{
		currentTick++;
		
		if(currentTick >= tickNext) {
			second+=60f;
			//Thread.sleep(500);
			if(second >= 60f) {
				minute += 60f;
				second = 0;
				if(minute >= 60f) {
					hour += 1f;
					minute = 0;
					if(hour == 13f) {
						if(!am) {
							type = "A.M";
							am = true;
						}else {
							type = "P.M";
							pm = true;
						}
						hour = 0;
						minute = 0;
						second = 0;
					}
				}
			}
			timeString = "" + hour + " : " + minute + " : " + second + "    " + type;	
			
			if(type == "A.M" && hour == 12) {
				type = "P.M";
			} 
			if(type == "P.M" && hour == 12 && minute == 59) {
				hour = 1;
			}
			if(type == "P.M" && hour == 12) {
				type = "A.M";
			}
			
			currentTick = 0;
		}	
	}
}
