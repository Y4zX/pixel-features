package dev.y4z.pixelfeatures
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import android.widget.RemoteViews

class LockWidgetProvider : AppWidgetProvider() {
    companion object {
        private const val ACTION_WIDGET_TAP = "dev.y4z.pixelfeatures.ACTION_WIDGET_TAP"
        private const val DOUBLE_TAP_WINDOW = 350L
        private var lastTapElapsed: Long = 0L

        fun requestUpdate(context: Context) {
            val mgr = AppWidgetManager.getInstance(context)
            val cn = ComponentName(context, LockWidgetProvider::class.java)
            val ids = mgr.getAppWidgetIds(cn)
            if (ids.isNotEmpty()) {
                val intent = Intent(AppWidgetManager.ACTION_APPWIDGET_UPDATE).apply {
                    component = cn
                    putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids)
                }
                context.sendBroadcast(intent)
            }
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
            val now = SystemClock.elapsedRealtime()
            val delta = now - lastTapElapsed
            lastTapElapsed = now
            if (delta in 1..DOUBLE_TAP_WINDOW) {
                AccessibilityService.instance?.lockNowViaGlobalAction()
            }
        }
    }
}