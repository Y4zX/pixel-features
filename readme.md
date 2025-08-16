# PixelFeatures

PixelFeatures is an open‑source Android app that restores and enhances missing or limited conveniences on Google Pixel devices. Built with Kotlin, it offers lightweight, customizable tools to streamline everyday tasks - especially if stock Android removed or hid features users rely on.

## ✨ Highlights
- Sound Quick Settings Tile: Add a tile that opens the media volume slider instantly with a tap; long‑press to jump straight into full sound settings - no menu diving.
- Double‑Tap to Sleep Widget: Place a widget on the home screen to lock the device with a double‑tap, reducing wear on physical buttons. Requires enabling the Accessibility Service.
- Secure Accessibility Integration: Uses Accessibility Service solely to perform screen lock-kept minimal for reliability and battery efficiency.

This project focuses on practicality and privacy: small footprint, no bloat, and transparent behavior.

## 🚀 Getting Started
1. Clone the repo:
   - git clone https://github.com/y4z-dev/pixel-features.git
2. Open in Android Studio, sync Gradle, and build the APK.
3. Install & configure:
   - Install on a Pixel device (Android 14+ required; minSdk 34, targetSdk 36).
   - Enable the Accessibility Service in Settings → Accessibility (needed for lock).
   - Add the widget to the home screen and the tile to Quick Settings.
4. Permissions:
   - Accessibility permission for screen locking; no other special permissions.

Note: Google Play Protect may warn about apps that request Accessibility for lock actions. If flagged, temporarily disable Play Protect during install, then re‑enable it. The service is used only for lock functionality.

## 🧰 Tech Stack
- Language: Kotlin
- Platform: Android (minSdk 34, targetSdk 36)
- Components: AppWidgetProvider, TileService, AccessibilityService
- Design goals: Minimal, battery‑friendly, no unwanted background activities

## 🔐 Trust & Transparency
- Open source-inspect, modify, and build locally.
- No trackers or hidden behavior; features are scoped to what’s necessary.
- Prefer building from source if extra assurance is desired.

## 📌 Feature Summary
- Sound Quick Settings tile (tap: media slider; long‑press: full sound settings)
- Double‑tap to sleep home widget (requires Accessibility)
- Battery‑optimized, lightweight implementation
- Android 14+ support
- Already tested on real devices

## 🤝 Contributing
Ideas, bug reports, and PRs are welcome - especially if there are other Pixel conveniences worth bringing back. If PixelFeatures helps, consider starring the repo. 😊

— Built to make Pixels feel a little more personal and powerful.
