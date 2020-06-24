package com.amoghbhagwat.farmmanagement;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FarmDataActivity extends AppCompatActivity {
    private TextView currentCrop;
    private TextView date;
    private TextView recordingTime;

    private TextView temperature;
    private TextView humidity;
    private TextView soilMoisture;
    private TextView waterLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_data);

        this.currentCrop = findViewById(R.id.txt_currentCrop);
        this.date = findViewById(R.id.txt_date);
        this.recordingTime = findViewById(R.id.txt_recordingTime);

        this.temperature = findViewById(R.id.txt_temperature);
        this.humidity = findViewById(R.id.txt_humidity);
        this.soilMoisture = findViewById(R.id.txt_soilMoisture);
        this.waterLevel = findViewById(R.id.txt_waterLevel);

        initialize();
    }

    private void initialize() {  // TODO: 04-Apr-20 Implement methods for getting the data
        currentCrop.setText(getString(R.string.current_crop, getCurrentCrop()));
        date.setText(getString(R.string.date, getDate()));
        recordingTime.setText(getString(R.string.recording_time, getRecordingTime()));

        temperature.setText(getTemperature());
        humidity.setText(getHumidity());
        soilMoisture.setText(getSoilMoisture());
        waterLevel.setText(getWaterLevel());
    }

    private String getWaterLevel() {
        return "80%";
    }

    private String getSoilMoisture() {
        return "10%";
    }

    private String getTemperature() {
        return "10\u00B0C";
    }

    private String getHumidity() {
        return "50%";
    }

    private String getRecordingTime() {
        return "10 am";
    }

    private String getDate() {
        return "8th November, 2020";
    }

    private String getCurrentCrop() {
        return "Wheat";
    }
}
