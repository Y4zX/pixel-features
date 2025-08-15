package dev.y4z.pixelfeatures

import android.app.Activity
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.os.Bundle
import android.service.quicksettings.TileService

// Optional shorter names
import android.media.AudioManager.ADJUST_SAME
import android.media.AudioManager.STREAM_MUSIC
import android.media.AudioManager.FLAG_SHOW_UI
import android.media.AudioManager.FLAG_PLAY_SOUND

class SoundControlTileService : TileService() {

    override fun onClick() {
        super.onClick()

        // Show the system volume slider
        showVolumePanel()

        // Create PendingIntent to a transparent activity that finishes immediately
        val intent = Intent(this, TransparentActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        // Collapse the QS panel (non-deprecated way)
        startActivityAndCollapse(pendingIntent)
    }

    private fun showVolumePanel() {
        try {
            (getSystemService(AUDIO_SERVICE) as AudioManager)
                .adjustStreamVolume(
                    STREAM_MUSIC,
                    ADJUST_SAME,
                    FLAG_SHOW_UI or FLAG_PLAY_SOUND
                )
        } catch (_: Exception) {
            // No action on failure
        }
    }
}

// Add this transparent activity
class TransparentActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        finish()  // Immediately close without showing anything
    }
}
