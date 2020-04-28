package com.amoghbhagwat.farmmanagement;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.switchmaterial.SwitchMaterial;

import androidx.appcompat.app.AppCompatActivity;

public class MotorActivity extends AppCompatActivity {
    public static final String MOTOR_STATUS = "motor_status";

    private boolean motorOn;

    private SharedPreferences preferences;
    private SwitchMaterial motorSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motor);

        this.motorSwitch = findViewById(R.id.switch_motor);

        this.preferences = getSharedPreferences(LoginActivity.FILE_NAME, MODE_PRIVATE);

        initialize();
    }

    private void initialize() {
        updateMotorStatus();

        motorSwitch.setOnCheckedChangeListener((button, isChecked) -> {
            motorOn = isChecked;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(MOTOR_STATUS, motorOn);
            editor.apply();
        });
    }

    private void updateMotorStatus() {
        motorOn = preferences.getBoolean(MOTOR_STATUS, false);
        motorSwitch.setChecked(motorOn);
    }
}
