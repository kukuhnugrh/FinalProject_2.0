package com.example.final_project2;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.viewpager.widget.ViewPager;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private Button button;
    boolean isReciverRegistered = false;
    boolean wifiConnected = false;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        Bundle b = getIntent().getExtras();
        String s;
        s = b.getString("flag");
        Toast.makeText(this, "HALO "+s, Toast.LENGTH_SHORT).show();
    }


    public void notif(String status){
        NotificationCompat.Builder notifBuilder =
                new NotificationCompat.Builder(this, "1")
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setContentTitle("WiFi")
                        .setContentText("WiFi is "+ status)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        Intent notifIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                notifIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        notifBuilder.setContentIntent(contentIntent);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(0, notifBuilder.build());

    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "notification_channel";
            String description = "desciption of notification channel";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("1", name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            Objects.requireNonNull(notificationManager).createNotificationChannel(channel);
        }
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo  = Objects.requireNonNull(connectivityManager).getActiveNetworkInfo();

            if(networkInfo !=null){
                if(networkInfo.getType() == ConnectivityManager.TYPE_WIFI){
                    System.out.println("status: " + networkInfo.isConnected());
                    Toast.makeText(getApplicationContext(),"wifi on",Toast.LENGTH_SHORT).show();
                    notif("Wifi On");
                }
                else{
                    System.out.println("status: " + networkInfo.isConnected());
                    Toast.makeText(getApplicationContext(),"wifi off",Toast.LENGTH_SHORT).show();
                    notif("Wifi Off");
                }
            }

        }
    };

    protected void onResume(){
        super.onResume();
        if(!isReciverRegistered){
            isReciverRegistered =  true;
            wifiConnected = true;
            registerReceiver(receiver, new IntentFilter("android.net.wifi.STATE_CHANGE"));
        }
    }

    protected void onPause(){
        super.onPause();
        if(isReciverRegistered){

        }
    }
}
