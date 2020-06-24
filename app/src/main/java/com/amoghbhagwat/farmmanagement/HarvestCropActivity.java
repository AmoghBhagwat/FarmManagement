package com.amoghbhagwat.farmmanagement;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.appcompat.app.AppCompatActivity;

public class HarvestCropActivity extends AppCompatActivity {
    private TableLayout cropsTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harvest_crop);

        this.cropsTable = findViewById(R.id.table_productivity);

        initialize();
    }

    private void initialize() {
        for (int i = 0; i < cropsTable.getChildCount(); i++) {
            TableRow row = (TableRow) cropsTable.getChildAt(i);
            row.setOnClickListener(v -> {

            });
        }
    }
}
