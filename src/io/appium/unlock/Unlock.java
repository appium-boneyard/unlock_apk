package io.appium.unlock;

import android.app.Activity;
import android.app.KeyguardManager;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Unlock extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // Set window flags to unlock screen. This works on most devices by itself.
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);

        // On most other devices, using the KeyguardManager + the permission in
        // AndroidManifest.xml will do the trick
        KeyguardManager mKeyGuardManager = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);
        KeyguardManager.KeyguardLock mLock = mKeyGuardManager.newKeyguardLock("Unlock");
        mLock.disableKeyguard();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) 
    {
        super.onPostCreate(savedInstanceState);
        moveTaskToBack(true);
    }
}
