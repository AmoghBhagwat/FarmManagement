package com.amoghbhagwat.farmmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MotorActivity extends AppCompatActivity {
    public static final String MOTOR_STATUS = "motor_status";

    private boolean motorOn;

    private SharedPreferences preferences;
    private Button btnToggleMotor;
    private TextView txtMotorStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motor);

        this.btnToggleMotor = findViewById(R.id.btn_changeMotorStatus);
        this.txtMotorStatus = findViewById(R.id.txt_motorStatus);

        this.preferences = getSharedPreferences(LoginActivity.FILE_NAME, MODE_PRIVATE);

        initialize();
    }

    private void initialize() {
        updateMotorStatus();

        btnToggleMotor.setOnClickListener(view -> {
            toggleMotor();
        });
    }

    private void toggleMotor() {
        motorOn = !motorOn;
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(MOTOR_STATUS, motorOn);
        editor.apply();

        updateMotorStatus();
    }

    private void updateMotorStatus() {
        motorOn = preferences.getBoolean(MOTOR_STATUS, false);
        if (motorOn) {
            txtMotorStatus.setText(getString(R.string.motor_status, "ON"));
            btnToggleMotor.setText(getString(R.string.toggle_motor, "OFF"));
        } else {
            txtMotorStatus.setText(getString(R.string.motor_status, "OFF"));
            btnToggleMotor.setText(getString(R.string.toggle_motor, "ON"));
        }
    }
}
