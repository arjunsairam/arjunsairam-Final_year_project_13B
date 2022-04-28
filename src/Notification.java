package com.example.criminal123456;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Notification extends AppCompatActivity {
private TextView location,name1,date1,time1;
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        location=findViewById(R.id.textView2);
        name1=findViewById(R.id.textView4);
        date1=findViewById(R.id.textView6);
        time1=findViewById(R.id.textView8);
        Intent intent=getIntent();
        String Location = intent.getStringExtra("location");
        String name = intent.getStringExtra("Name");
        String date=intent.getStringExtra("Date");
        String time=intent.getStringExtra("Time");
        location.setText(Location);
        name1.setText(name);
        date1.setText(date);
        time1.setText(time);

       /* databaseReference=FirebaseDatabase.getInstance().getReference("criminal");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String sta1=snapshot.child("Location").getValue(String.class);
                String sta2=snapshot.child("Name").getValue(String.class);
                String sta3=snapshot.child("date").getValue(String.class);
                String sta4=snapshot.child("time").getValue(String.class);
                location.setText(sta1);
                name.setText(sta2);
                date.setText(sta3);
                time.setText(sta4);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/
    }
}