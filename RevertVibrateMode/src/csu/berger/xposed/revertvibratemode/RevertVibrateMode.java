package csu.berger.xposed.revertvibratemode;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class RevertVibrateMode implements IXposedHookLoadPackage{

	@Override
	public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
//        XposedBridge.log("Loaded app: " + lpparam.packageName);
		
		// check for package?
		
		findAndHookMethod("com.android.server.NotificationManagerService", lpparam.classLoader, "enqueueNotificationInternal", new XC_MethodHook() {
			@Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
				
				/*
				 * need to cancel out "final boolean convertSoundToVibration"
				 * 
				 * line 1904 in 4.4.2 r1 - latest (http://grepcode.com/file/repository.grepcode.com/java/ext/com.google.android/android/4.4.2_r1/com/android/server/NotificationManagerService.java/)
				 * 
				 * line 1091 in 4.2 r1 - original change (http://grepcode.com/file/repository.grepcode.com/java/ext/com.google.android/android/4.2_r1/com/android/server/NotificationManagerService.java/)
				*/
				
            }
		});
		
	}

}
