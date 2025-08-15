package dev.y4z.pixelfeatures
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import android.widget.RemoteViews
import android.provider.Settings


class LockWidgetProvider : AppWidgetProvider() {
    companion object {
        private const val ACTION_WIDGET_TAP = "dev.y4z.pixelfeatures.ACTION_WIDGET_TAP"
        private const val DOUBLE_TAP_WINDOW = 350L
        private var lastTapElapsed: Long = 0L

        private fun isAccessibilityServiceEnabled(context: Context): Boolean {
            val enabledServices = Settings.Secure.getString(
                context.contentResolver,
                Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES
            )
            return enabledServices?.contains("dev.y4z.pixelfeatures/dev.y4z.pixelfeatures.AccessibilityService") == true
        }

        private fun openAccessibilitySettings(context: Context) {
            val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
    }

    override fun onUpdate(context: Context, manager: AppWidgetManager, ids: IntArray) {
        for (id in ids) {
            val views = RemoteViews(context.packageName, R.layout.widget_lock)
            val intent = Intent(context, LockWidgetProvider::class.java).apply {
                action = ACTION_WIDGET_TAP
            }
            val pi = PendingIntent.getBroadcast(
                context,
                id,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
            views.setOnClickPendingIntent(R.id.hitArea, pi)
            manager.updateAppWidget(id, views)
        }
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        if (intent.action == ACTION_WIDGET_TAP) {
            if (!isAccessibilityServiceEnabled(context)) {
                openAccessibilitySettings(context)
                return
            }

            val now = SystemClock.elapsedRealtime()
            val delta = now - lastTapElapsed
            lastTapElapsed = now
            if (delta in 1..DOUBLE_TAP_WINDOW) {
                AccessibilityService.instance?.lockNowViaGlobalAction()
            }
        }
    }

}

