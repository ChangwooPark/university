package app.com.firedetectionnotification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import app.com.firedetectionnotification.view.Login;

/**
 * API 가이드 (http://developer.android.com/reference/android/app/Notification.html)
 *
 * Notification notification = new Notification(icon, tickerText, when);
 * icon : 아이콘
 * tickerText : 글자
 * when : 알림을 표시할 시각
 *
 * notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
 * context : 컨텍스트 개체
 * contentTitle : notification에 표시될 제목
 * contentText : notification에 표시될 글자
 * contentIntent : 알림 터치시 수행할 작업
 *
 * PendingIntent contentIntent = PendingIntent.getActivity(context, requestCode, intent, flags);
 * context : 컨텍스트 개체
 * requestCode : 요청코드
 * intent : 처리할 작업이 포함되어 있는 intent객체
 * flags : 기타 실행 옵션
 *
 * nm.notify(id, notification)
 * id: 알림을 구별할 상수
 * notification : notification 객체
 */

/**
 * Created by Administrator on 2015-10-04.
 */
public class PushAlram extends Activity {

    public void notification(){


        // 알림은 시스탬 서비스 입니다 시스탬 서비스를 호출합니다
        NotificationManager nm = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        // 아이콘과 잠깐 표시될 메세지를 표시합니다 예를들어 "새로운 메세지가 도착했습니다"
        // 마지막 System.currentTimeMillis()는 알림을 표시할 시각입니다 현재 밀리세컨드초를 반환하여 바로 알림을 표시합니다
        Notification notification = new Notification(R.drawable.logoicon, "Nomal Notification", System.currentTimeMillis());

        // flag를 설정합니다
        // FLAG_AUTO_CANCEL : 알림(터치하면 지워짐), FLAG_ONGOING_EVENT : 진행중(게속 표시)
        notification.flags = Notification.FLAG_AUTO_CANCEL;

        // Sdcard에 있는 소리파일을 재생하거나 assets의 파일을 재생할수 있습니다
//        notification.sound = Uri.parse("file:///sdcard/media/gogosing.mp3");

        // 소리와 진동을 재생합니다
        notification.defaults = Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE ;

        notification.number = 13;

        // 알림 우선순위를 정합니다 API 16부터 사용가능합니다 (Added in API level 16)
//        notification.priority = Notification.PRIORITY_DEFAULT;

        // MainActivity.class는 알림을 터치하면 이동할 액티비티입니다
        // PendingIntent에 대해서는 아직 몰라도 됩니다
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, Login.class), PendingIntent.FLAG_UPDATE_CURRENT);

        // 첫번째에는 Context가, 두번째와 세번째는 각각 제목과 내용이 들어갑니다
        notification.setLatestEventInfo(this, "Nomal Title", "Nomal Summary", pendingIntent);

        // 1234는 알림을 구분할 상수입니다 알림을 지울땐 nm.cancel(1234)로 지울수 있습니다
        nm.notify(1234, notification);
    }
}
