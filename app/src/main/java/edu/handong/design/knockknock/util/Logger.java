package edu.handong.design.knockknock.util;

import android.util.Log;

public class Logger {
	
	public static void log(Object... objs) {

		for (Object obj : objs) {
            if (obj == null) {
                Log.e("ERROR", "null");
                continue;
            }
			Log.e("ERROR", obj.toString());
		}
	}
}
