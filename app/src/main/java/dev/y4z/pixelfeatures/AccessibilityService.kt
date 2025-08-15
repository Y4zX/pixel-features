package dev.y4z.pixelfeatures
import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent

class AccessibilityService : AccessibilityService() {

    companion object {
        @Volatile
        var instance: dev.y4z.pixelfeatures.AccessibilityService? = null
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        instance = this
    }

    override fun onUnbind(intent: android.content.Intent?): Boolean {
        instance = null
        return super.onUnbind(intent)
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        // Not needed for our use-case
    }

    override fun onInterrupt() {
        // Not needed for our use-case
    }

    fun lockNowViaGlobalAction(): Boolean {
        // Requires API 28+: GLOBAL_ACTION_LOCK_SCREEN
        return performGlobalAction(GLOBAL_ACTION_LOCK_SCREEN)
    }
}