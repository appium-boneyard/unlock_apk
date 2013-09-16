# Unlock

> Wake up and unlock an Android device or emulator.

A small and simple Android application that, when run, wakes up the device, unlocks the screen. Then the application shuts down.

# Requirements

* [Android SDK](developer.android.com)

# Building

    $ cd into/this/repo
    $ ant debug

You can also run `ant debug install` to build and immediately deploy the app to a connected Android device or emulator.

# Running

Once installed on a device, turn the device's screen off. If you have a security lock on your device, turning the screen off will
also enable the security lock.

Now to see the magic:

    $ adb shell am start -n io.appium.unlock/.Unlock

Voila! Your device or emulator is awake and unlocked!

# License

Apache License 2.0 
