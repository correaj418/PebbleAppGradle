package com.getpebble.android.framework.pebblekit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.common.b.b.c;
import com.getpebble.android.common.model.au;
import com.getpebble.android.framework.appmessage.AppMessage;
import com.getpebble.android.framework.g.k;
import com.google.b.f;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;

public class b extends BroadcastReceiver {
    private static final int NOT_SET = -1;
    private static final String TAG = "PebbleKitReceiver";
    private static com.getpebble.android.b.b.a sCsm;
    private static final f sGson = new f();

    private static class a {
        public static final String TYPE = "PEBBLE_ALERT";
        public final String body;
        public final String title;

        private a(String str, String str2) {
            this.title = str;
            this.body = str2;
        }
    }

    public b(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.getpebble.action.dl.ACK_DATA");
        intentFilter.addAction("com.getpebble.action.dl.REQUEST_DATA");
        intentFilter.addAction("com.getpebble.action.app.ACK");
        intentFilter.addAction("com.getpebble.action.app.NACK");
        intentFilter.addAction("com.getpebble.action.app.SEND");
        intentFilter.addAction("com.getpebble.action.app.START");
        intentFilter.addAction("com.getpebble.action.app.STOP");
        intentFilter.addAction("com.getpebble.action.app.CONFIGURE");
        intentFilter.addAction("com.getpebble.action.SEND_NOTIFICATION");
        context.registerReceiver(this, intentFilter);
    }

    public void destroy() {
        com.getpebble.android.common.a.K().unregisterReceiver(this);
    }

    public static void setCsm(com.getpebble.android.b.b.a aVar) {
        sCsm = aVar;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            com.getpebble.android.common.b.a.f.b(TAG, "intent is null");
        } else if (intent.getAction() == null) {
            com.getpebble.android.common.b.a.f.b(TAG, "intent.getAction() is null");
        } else {
            String action = intent.getAction();
            com.getpebble.android.common.b.a.f.d(TAG, "action = " + action);
            if (sCsm != null) {
                sCsm.b(false);
            }
            if ("com.getpebble.action.dl.ACK_DATA".equals(action)) {
                handleDataloggingAck(intent);
            } else if ("com.getpebble.action.dl.REQUEST_DATA".equals(action)) {
                handleDataloggingRequestData(intent);
            } else if ("com.getpebble.action.app.ACK".equals(action)) {
                handleAppMessageAck(intent, context);
            } else if ("com.getpebble.action.app.NACK".equals(action)) {
                handleAppMessageNack(intent, context);
            } else if ("com.getpebble.action.app.SEND".equals(action)) {
                au.a(com.getpebble.android.common.model.au.a.PEBBLEKIT_APP_MESSAGE_IN, context.getContentResolver());
                handleAppMessageClientSend(intent, context);
            } else if ("com.getpebble.action.app.START".equals(action)) {
                handleAppStart(intent, context);
            } else if ("com.getpebble.action.app.STOP".equals(action)) {
                handleAppStop(intent, context);
            } else if ("com.getpebble.action.app.CONFIGURE".equals(action)) {
                handleConfigureApp(intent, context);
            } else if ("com.getpebble.action.SEND_NOTIFICATION".equals(action)) {
                handleNotification(intent, context);
            }
        }
    }

    private void handleAppStart(Intent intent, Context context) {
        UUID uuid = getUuid(intent, "uuid");
        if (uuid == null) {
            com.getpebble.android.common.b.a.f.b(TAG, "No UUID in Start message");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(com.getpebble.android.framework.g.k.b.UUID.toString(), uuid.toString());
        sendRequestToConnectedWatch(context, new k(com.getpebble.android.bluetooth.g.a.APP_RUN_STATE, com.getpebble.android.framework.g.k.a.START_APP, bundle));
    }

    private void handleAppStop(Intent intent, Context context) {
        UUID uuid = getUuid(intent, "uuid");
        if (uuid == null) {
            com.getpebble.android.common.b.a.f.b(TAG, "No UUID in Stop message");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(com.getpebble.android.framework.g.k.b.UUID.toString(), uuid.toString());
        sendRequestToConnectedWatch(context, new k(com.getpebble.android.bluetooth.g.a.APP_RUN_STATE, com.getpebble.android.framework.g.k.a.STOP_APP, bundle));
    }

    private void handleConfigureApp(Intent intent, Context context) {
        int intExtra = intent.getIntExtra("app_type", NOT_SET);
        if (intExtra == 1 || intExtra == 0) {
            String stringExtra = intent.getStringExtra("name");
            Bitmap bitmap = (Bitmap) intent.getParcelableExtra("icon");
            Bundle bundle = new Bundle();
            bundle.putString(com.getpebble.android.framework.g.k.b.APP_TITLE.toString(), stringExtra);
            bundle.putParcelable(com.getpebble.android.framework.g.k.b.BITMAP.toString(), bitmap);
            bundle.putInt(com.getpebble.android.framework.g.k.b.APP_TYPE.toString(), intExtra);
            sendRequestToConnectedWatch(context, new k(com.getpebble.android.bluetooth.g.a.APP_CUSTOMIZE, com.getpebble.android.framework.g.k.a.CUSTOMIZE_APP, bundle));
            return;
        }
        com.getpebble.android.common.b.a.f.c(TAG, "Received customization message for unknow app type: " + intExtra);
    }

    private void handleAppMessageAck(Intent intent, Context context) {
        int intExtra = intent.getIntExtra("transaction_id", NOT_SET);
        if (intExtra == NOT_SET) {
            com.getpebble.android.common.b.a.f.c(TAG, "handleAppMessageAck: transactionId not set");
            return;
        }
        Parcelable appMessage = new AppMessage((byte) (intExtra & 255), null, com.getpebble.android.framework.appmessage.AppMessage.a.ACK, null);
        Bundle bundle = new Bundle();
        bundle.putParcelable(com.getpebble.android.framework.g.k.b.APP_MESSAGE.toString(), appMessage);
        sendRequestToConnectedWatch(context, new k(com.getpebble.android.bluetooth.g.a.APP_MESSAGE, com.getpebble.android.framework.g.k.a.PUSH_APP_MESSAGE, bundle));
    }

    private void handleAppMessageNack(Intent intent, Context context) {
        int intExtra = intent.getIntExtra("transaction_id", NOT_SET);
        if (intExtra == NOT_SET) {
            com.getpebble.android.common.b.a.f.c(TAG, "handleAppMessageNack: transactionId not set");
            return;
        }
        Parcelable appMessage = new AppMessage((byte) (intExtra & 255), null, com.getpebble.android.framework.appmessage.AppMessage.a.NACK, null);
        Bundle bundle = new Bundle();
        bundle.putParcelable(com.getpebble.android.framework.g.k.b.APP_MESSAGE.toString(), appMessage);
        sendRequestToConnectedWatch(context, new k(com.getpebble.android.bluetooth.g.a.APP_MESSAGE, com.getpebble.android.framework.g.k.a.PUSH_APP_MESSAGE, bundle));
    }

    private void handleAppMessageClientSend(Intent intent, Context context) {
        Throwable e;
        try {
            int intExtra = intent.getIntExtra("transaction_id", NOT_SET);
            UUID uuid = getUuid(intent, "uuid");
            if (uuid == null) {
                com.getpebble.android.common.b.a.f.b(TAG, "No UUID in AppMessage");
                return;
            }
            Parcelable appMessage = new AppMessage((byte) (intExtra & 255), uuid, com.getpebble.android.framework.appmessage.AppMessage.a.PUSH, com.getpebble.android.framework.appmessage.b.a(intent.getStringExtra("msg_data")));
            Bundle bundle = new Bundle();
            bundle.putParcelable(com.getpebble.android.framework.g.k.b.APP_MESSAGE.toString(), appMessage);
            sendRequestToConnectedWatch(context, new k(com.getpebble.android.bluetooth.g.a.APP_MESSAGE, com.getpebble.android.framework.g.k.a.PUSH_APP_MESSAGE, bundle));
        } catch (JSONException e2) {
            e = e2;
            com.getpebble.android.common.b.a.f.b(TAG, "handleAppMessageClientSend: Could handle incoming appmessage: " + null, e);
        } catch (IllegalArgumentException e3) {
            e = e3;
            com.getpebble.android.common.b.a.f.b(TAG, "handleAppMessageClientSend: Could handle incoming appmessage: " + null, e);
        }
    }

    private void handleDataloggingAck(Intent intent) {
        try {
            UUID uuid = getUuid(intent, "data_log_uuid");
            if (uuid == null) {
                com.getpebble.android.common.b.a.f.b(TAG, "logUuid is null");
                return;
            }
            int intExtra = intent.getIntExtra("pbl_data_id", NOT_SET);
            if (intExtra == NOT_SET) {
                com.getpebble.android.common.b.a.f.b(TAG, "dataId is invalid");
            } else {
                getDatalogging().a(uuid, intExtra);
            }
        } catch (Throwable e) {
            com.getpebble.android.common.b.a.f.b(TAG, "Error handling datalogging ack", e);
        }
    }

    private void handleDataloggingRequestData(Intent intent) {
        try {
            UUID uuid = (UUID) intent.getSerializableExtra("uuid");
            if (uuid == null) {
                com.getpebble.android.common.b.a.f.b(TAG, "appUuid is null");
            } else {
                getDatalogging().a(uuid);
            }
        } catch (Throwable e) {
            com.getpebble.android.common.b.a.f.b(TAG, "Error handling datalogging ack", e);
        }
    }

    private UUID getUuid(Intent intent, String str) {
        Serializable serializableExtra = intent.getSerializableExtra(str);
        if (serializableExtra != null) {
            if (serializableExtra instanceof UUID) {
                return (UUID) serializableExtra;
            }
            if (serializableExtra instanceof String) {
                try {
                    return UUID.fromString((String) serializableExtra);
                } catch (Throwable e) {
                    com.getpebble.android.common.b.a.f.b(TAG, "Error getting UUID from String", e);
                }
            }
        }
        return null;
    }

    private void handleNotification(Intent intent, Context context) {
        String stringExtra = intent.getStringExtra("messageType");
        String stringExtra2 = intent.getStringExtra("sender");
        String stringExtra3 = intent.getStringExtra("notificationData");
        if (context == null) {
            com.getpebble.android.common.b.a.f.a(TAG, "handleNotification: context was null");
            return;
        }
        c cVar = new c(context);
        if (com.google.a.a.k.a(stringExtra) || com.google.a.a.k.a(stringExtra2) || com.google.a.a.k.a(stringExtra3)) {
            com.getpebble.android.common.b.a.f.b(TAG, "Received a malformed PebbleNotification intent");
        } else if (!cVar.a(com.getpebble.android.common.b.b.c.a.ALLOW_THIRD_PARTY_NOTIFICATIONS, true)) {
            com.getpebble.android.common.b.a.f.c(TAG, "Ignoring 3rd-party notification from: " + String.valueOf(stringExtra2));
        } else if (stringExtra.equals(a.TYPE)) {
            try {
                List list = (List) sGson.a(stringExtra3, new com.google.b.c.a<List<a>>() {
                }.getType());
                if (list.size() != 1) {
                    com.getpebble.android.common.b.a.f.b(TAG, "Received malformed PebbleAlertNotificationData");
                    return;
                }
                a aVar = (a) list.get(0);
                com.getpebble.android.notifications.a.b.a aVar2 = new com.getpebble.android.notifications.a.b.a();
                aVar2.b = aVar.title;
                aVar2.d = aVar.body;
                com.getpebble.android.framework.i.b.a(com.getpebble.android.notifications.a.b.a(aVar2, com.getpebble.android.notifications.a.b.c.PEBBLEKIT, System.currentTimeMillis()));
            } catch (Throwable e) {
                com.getpebble.android.common.b.a.f.b(TAG, "Received malformed PebbleAlertNotificationData", e);
            } catch (Throwable e2) {
                com.getpebble.android.common.b.a.f.a(TAG, "Caught an unexpected exception while parsing PebbleAlertNotificationData", e2);
            }
        } else {
            com.getpebble.android.common.b.a.f.b(TAG, "Don't know how to handle messageType = " + stringExtra);
        }
    }

    protected com.getpebble.android.framework.d.a getDatalogging() {
        return com.getpebble.android.framework.d.a.a();
    }

    protected void sendRequestToConnectedWatch(Context context, k kVar) {
        PebbleDevice n = PebbleApplication.n();
        if (n == null) {
            com.getpebble.android.common.b.a.f.c(TAG, "Can't send message to watch: connected device is null");
            return;
        }
        com.getpebble.android.framework.b.a c = com.getpebble.android.framework.b.a.c(n);
        if (c == null) {
            com.getpebble.android.common.b.a.f.c(TAG, "Can't send message to watch: router is null");
        } else {
            c.a(kVar, null);
        }
    }
}
