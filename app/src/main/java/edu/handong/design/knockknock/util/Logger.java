package edu.handong.design.knockknock.util;

import android.util.Log;

public class Logger {
	
	public static void log(Object... objs) {
		for (Object obj : objs) {
			Log.e("ERROR", obj.toString());
		}
	}
}
