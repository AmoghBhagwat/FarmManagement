package com.amoghbhagwat.farmmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NotificationsActivity extends AppCompatActivity {
    private ListView notificationsList;
    private ListAdapter adapter;

    private List<String> notifications = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        this.notificationsList = findViewById(R.id.notifications_list);

        // dummy data
        for (int i = 0; i < 30; i++) {
            notifications.add("Item " + i);
        }

        this.adapter = new ArrayAdapter<>(this, R.layout.notification, notifications);

        notificationsList.setAdapter(adapter);
    }
}
