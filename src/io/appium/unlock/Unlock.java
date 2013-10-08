package io.appium.unlock;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;

public class Unlock extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // Set window flags to unlock screen. This works on most devices by itself.
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);

        // On most other devices, using the KeyguardManager + the permission in 
        // AndroidManifest.xml will do the trick
        KeyguardManager mKeyGuardManager = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);
        KeyguardManager.KeyguardLock mLock = mKeyGuardManager.newKeyguardLock("Unlock");
        mLock.disableKeyguard();

        // Close yourself!
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Unlock.this.finish();
            }
        }, 200);
    }
}
