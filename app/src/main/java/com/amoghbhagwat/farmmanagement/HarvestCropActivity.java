package com.amoghbhagwat.farmmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HarvestCropActivity extends AppCompatActivity {
    private TextView crop;
    private TextView estimatedProductivity;
    private TextView marketRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harvest_crop);

        this.crop = findViewById(R.id.txt_crop);
        this.estimatedProductivity = findViewById(R.id.txt_estimatedProductivity);
        this.marketRate = findViewById(R.id.txt_marketRate);

        initialize();
    }

    private void initialize() {
        crop.setText(getCrop());
        estimatedProductivity.setText(getEstimatedProductivity());
        marketRate.setText(getMarketRate());
    }

    private String getMarketRate() {
        return "\u20B9100";
    }

    private String getEstimatedProductivity() {
        return "100%";
    }

    private String getCrop() {
        return "Wheat";
    }
}
