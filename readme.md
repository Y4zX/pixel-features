# PixelFeatures

**PixelFeatures** is an open-source Android app designed to bring back and enhance missing or limited features for Google Pixel phone users. Built with Kotlin, it focuses on simple, customizable tools to improve your daily Pixel experience - especially for those who miss certain stock Android functionalities.

## Key Features
- **Sound Quick Settings Tile**: A custom tile in your notification panel that instantly opens the device's volume controller (media slider) with a single tap. Long-press opens the full sound settings for quick adjustments. No more digging through menus!
- **Double-Tap to Sleep Widget**: Add a home screen widget that locks your screen with a double-tap. Perfect for Pixel users who want a quick way to put their device to sleep without physical buttons. (Requires enabling the app's Accessibility Service.)
- **Accessibility Integration**: Leverages Android's Accessibility Service for secure screen locking, ensuring compatibility and minimal battery impact.

This project was created to fill gaps in Pixel's feature set, like the absence of a dedicated sound tile in Quick Settings and easy double-tap sleep options. It's lightweight, customizable, and easy to integrate into your Pixel setup.

## Getting Started
1. **Clone the Repo**: `git clone https://github.com/y4zx/pixel-features.git`
2. **Build in Android Studio**: Open the project, sync Gradle, and build the APK.
3. **Install & Configure**:
   - Install the APK on your Pixel device (Android 14+ recommended).
   - Enable the Accessibility Service in Settings > Accessibility for the lock feature.
   - Add the widget to your home screen and the tile to Quick Settings.
4. **Permissions**: Grant Accessibility for locking; no other special permissions needed.

## Tech Stack
- **Language**: Kotlin
- **Platform**: Android (minSdk 34, targetSdk 36)
- **Key Components**: AppWidgetProvider, TileService, AccessibilityService

Contributions welcome! If you're a Pixel user missing other features, open an issue or PR to suggest additions. Star the repo if it helps you out. 😊
