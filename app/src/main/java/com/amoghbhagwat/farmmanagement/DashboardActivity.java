package com.amoghbhagwat.farmmanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {
    private static final String TAG = "DashboardActivity";

    private SharedPreferences preferences;
    private String username;

    private TextView txtWelcome;
    private Button btnLogout;
    private Button btnMotor;
    private Button btnNotifications;
    private Button btnViewFarmData;
    private Button btnHarvestCrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        this.preferences = getSharedPreferences(LoginActivity.FILE_NAME, MODE_PRIVATE);

        this.txtWelcome = findViewById(R.id.txt_welcome);
        this.btnLogout = findViewById(R.id.btn_logout);
        this.btnMotor = findViewById(R.id.btn_operateMotor);
        this.btnNotifications = findViewById(R.id.btn_notifications);
        this.btnViewFarmData = findViewById(R.id.btn_farmData);
        this.btnHarvestCrop = findViewById(R.id.btn_harvestCrop);

        initialize();
    }

    @Override
    protected void onStart() {
        super.onStart();

        boolean isLogin = preferences.getBoolean(LoginActivity.IS_LOGIN, false);
        if (!isLogin) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        } else {
            username = preferences.getString(LoginActivity.USERNAME, "");
        }

        initialize();
    }

    private void initialize() {
//        txtWelcome.setText(getString(R.string.welcome, username));
        txtWelcome.setText(getString(R.string.welcome, "Farmer"));

        btnLogout.setOnClickListener(view -> {
            logout();
        });

        btnMotor.setOnClickListener(view -> {
            Intent intent = new Intent(this, MotorActivity.class);
            startActivity(intent);
        });

        btnNotifications.setOnClickListener(view -> {
            Intent intent = new Intent(this, NotificationsActivity.class);
            startActivity(intent);
        });

        btnViewFarmData.setOnClickListener(view -> {
            Intent intent = new Intent(this, FarmDataActivity.class);
            startActivity(intent);
        });

        btnHarvestCrop.setOnClickListener(view -> {
            Intent intent = new Intent(this, HarvestCropActivity.class);
            startActivity(intent);
        });
    }

    private void logout() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();

        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
