package dev.y4z.pixelfeatures

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.Settings

class TileLongPressActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Launch phone sound settings
        val intent = Intent(Settings.ACTION_SOUND_SETTINGS)
        startActivity(intent)

        // Close this activity immediately
        finish()
    }
}
