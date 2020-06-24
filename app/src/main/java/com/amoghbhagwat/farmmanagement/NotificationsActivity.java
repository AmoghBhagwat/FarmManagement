package com.amoghbhagwat.farmmanagement;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class NotificationsActivity extends AppCompatActivity {
    private ListView notificationsList;
    private ListAdapter adapter;

    private List<String> notifications = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        this.notificationsList = findViewById(R.id.notifications_list);

        notifications.add("Wheat was successfully harvested");
        notifications.add("Maize was successfully harvested");
        notifications.add("Rice was successfully harvested");
        notifications.add("Wheat has grown and is ready to be harvested");
        notifications.add("Maize has grown and is ready to be harvested");
        notifications.add("Rice has grown and is ready to be harvested");

        this.adapter = new ArrayAdapter<>(this, R.layout.notification, notifications);

        notificationsList.setAdapter(adapter);
    }
}
