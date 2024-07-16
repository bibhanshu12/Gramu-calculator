package com.bibo.gramu_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button calculate, gramsEntry, costEntry;
    EditText cost1, gm1;
    TextView result;
    boolean isGramsEntry = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculate = findViewById(R.id.calculate);
        cost1 = findViewById(R.id.cost1);
        gm1 = findViewById(R.id.gm1);
        result = findViewById(R.id.result);
        gramsEntry = findViewById(R.id.grams_entery);
        costEntry = findViewById(R.id.portions_cost_entry);

        gm1.setVisibility(View.GONE);

        gramsEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gm1.setHint("Enter grams");
                gm1.setVisibility(View.VISIBLE);
                isGramsEntry = true;
            }
        });

        costEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gm1.setHint("Enter cost");
                gm1.setVisibility(View.VISIBLE);
                isGramsEntry = false;
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String costStr = cost1.getText().toString();
                String gmStr = gm1.getText().toString();

                if (costStr.isEmpty() || gmStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter both cost and grams/cost", Toast.LENGTH_SHORT).show();
                    return;
                }

                double cost = Double.parseDouble(costStr);
                double gm = Double.parseDouble(gmStr);

                if (cost <= 0 || gm <= 0) {
                    Toast.makeText(MainActivity.this, "Please enter valid positive numbers", Toast.LENGTH_SHORT).show();
                    return;
                }

                double costPerGram = cost / 1000;

                if (isGramsEntry) {
                    double totalCost = costPerGram * gm;
                    result.setText("Cost: " + String.valueOf(totalCost));
                } else {
                    double gramsCanBeBought = gm / costPerGram;
                    result.setText("Grams: " + String.valueOf(gramsCanBeBought));
                }
            }
        });
    }
}
