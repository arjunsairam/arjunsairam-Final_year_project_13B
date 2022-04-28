package com.example.criminal123456;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference databaseReference;
    private DatabaseReference firebaseDatabase;
    private TextView location, name, date, time;
    private Context context;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        databaseReference = FirebaseDatabase.getInstance().getReference("criminal");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                
            User user=snapshot.getValue(User.class);
                Log.e("uuui",user.getDate());
            notification(user);
              }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }


    public  void notification(User user){

        String CHANNEL_ID = "my_channel_01";
        CharSequence name = "my_channel";
        String Description = "This is my channel";

        int NOTIFICATION_ID = 234;
        NotificationManager notificationManager = (NotificationManager) getSystemService(getApplicationContext().NOTIFICATION_SERVICE);


            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

                int importance = NotificationManager.IMPORTANCE_HIGH;
                NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
                mChannel.setDescription(Description);
                mChannel.enableLights(true);
                mChannel.enableVibration(true);
                mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                mChannel.setShowBadge(true);

                if (notificationManager != null) {
                    notificationManager.createNotificationChannel(mChannel);
                }

            }


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setContentTitle("Criminal Identification");
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText("Location:"+ user.getLocation()+"\n"+"Name:"+user.getName()+"\n"+"Time:"+user.getTime()+"\n"+"Date:"+user.getDate()));
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setAutoCancel(true);

        Intent intent = new Intent(this, Notification.class);
        intent.putExtra("location",user.getLocation());
        intent.putExtra("Name",user.getName()) ;
        intent.putExtra("Date",user.getDate());
        intent.putExtra("Time",user.getTime());
    startActivity(intent);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        if (notificationManager != null) {

            notificationManager.notify(NOTIFICATION_ID, builder.build());
        }

    }


}
