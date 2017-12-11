package app.com.firedetectionnotification.view;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import app.com.firedetectionnotification.MainActivity;
import app.com.firedetectionnotification.R;
import app.com.firedetectionnotification.data.HttpClient_Singleton;

/**
 * Created by Administrator on 2015-06-16.
 */
public class Login extends Activity{

    String id, pw;
    EditText edit_id, edit_pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button login_btn = (Button)findViewById(R.id.btn_login);
        edit_id = (EditText)findViewById(R.id.edit_id);
        edit_pw = (EditText)findViewById(R.id.edit_pw);

        login_btn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                id = edit_id.getText().toString();
                pw = edit_pw.getText().toString();

                if(id.equals("")||pw.equals("")){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "ID와 Password를 입력해주세요", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    login(id, pw);
                }

            }
        });
    }
    private void login(String id, String pass) {
//        notification();
        String URL = "http://203.230.100.254:8080/Android/Login.do";
        Log.d("Send_login  call", id + " " + pass);
        new Send_login().execute(URL, id, pass);
//        Log.d("hong","로그인 함수 접속");
//        ReceiveData receivedata = new ReceiveData();
//        receivedata.execute();
    }

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
        notification.sound = Uri.parse("file:///sdcard/media/alram.mp3");
//        notification.sound = Uri.parse("file:///storage/extSdCard/alram.mp3");
        // 소리와 진동을 재생합니다
        notification.defaults = Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE ;

        notification.number = 13;

        // 알림 우선순위를 정합니다 API 16부터 사용가능합니다 (Added in API level 16)
//        notification.priority = Notification.PRIORITY_DEFAULT;

        // MainActivity.class는 알림을 터치하면 이동할 액티비티입니다
        // PendingIntent에 대해서는 아직 몰라도 됩니다
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, Login.class), PendingIntent.FLAG_CANCEL_CURRENT);

        // 첫번째에는 Context가, 두번째와 세번째는 각각 제목과 내용이 들어갑니다
        notification.setLatestEventInfo(this, "경고메시지", "화재가 발생하였습니다.", pendingIntent);

        // 1234는 알림을 구분할 상수입니다 알림을 지울땐 nm.cancel(1234)로 지울수 있습니다
        nm.notify(1234, notification);
    }

    private class Send_login extends AsyncTask<String, Void, HttpResponse> {
        @Override
        protected HttpResponse doInBackground(String... params) {
            // TODO Auto-generated method stub

            try {
                DefaultHttpClient client = HttpClient_Singleton.getInstance();

                ArrayList<NameValuePair> login_list = new ArrayList<NameValuePair>();
                login_list.add(new BasicNameValuePair("id", params[1]));
                login_list.add(new BasicNameValuePair("pw", params[2]));
                Log.d("login_list", params[1] + " " + params[2]);
                // 타임아웃 설정
                HttpParams param = client.getParams();
                HttpConnectionParams.setConnectionTimeout(param, 5000);
                HttpConnectionParams.setSoTimeout(param, 5000);

                HttpPost post = new HttpPost(params[0]);
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(
                        login_list, "utf-8");
                post.setEntity(entity);

                HttpResponse response = client.execute(post);
                HttpEntity httpEntity = response.getEntity();

                BufferedReader buffreader = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()));
                String line;
                String result = "";
                while ((line = buffreader.readLine()) != null) {
                    result += line;
                }
                Log.d("Send", result);

                if (result != null) {
                    JSONObject json = new JSONObject(result);
                    String check = json.getString("login_check");

                    Log.d("hong", "login Check : "+ check);
                    int toast_check;
                    if (check.equals("success")) {
                        toast_check = 0;
                        ToastHandler.sendEmptyMessage(toast_check);
                    } else if (check.equals("fail")) {
//                        toast_check = 1;
                        toast_check = 0;
                        ToastHandler.sendEmptyMessage(toast_check);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("hong", "login error");
            }
            return null;
        }
    }

    public Handler ToastHandler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 0) {

                // Intent main = new Intent(Login.this,
                // mainview.TapWidget.class);
                Intent main = new Intent(Login.this,
                        MainActivity.class);
                startActivity(main);

            } else if (msg.what == 1) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "ID와 Password를 다시 확인해주세요", Toast.LENGTH_LONG);
                toast.show();

            }
        }
    };
}


