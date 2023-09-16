package com.bibo.gramu_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

Button calculate;
EditText cost1,gm1;
TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      calculate = findViewById(R.id.calculate);
         cost1 = findViewById(R.id.cost1);
         gm1 = findViewById(R.id.gm1);
        result = findViewById(R.id.result);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double cost = Double.parseDouble(cost1.getText().toString());
                double gm = Double.parseDouble(gm1.getText().toString());

                double test = cost / 1000;
                double test2 = test * gm;

                result.setText("Cost: " + String.valueOf(test2));


//                if(cost>0){
////                    result.System.out.println("Cost:"+test2);
//                    result.setText("Cost: " + String.valueOf(test2));
//
//                }else{
////                    System.out.println("Material cost invalid");
//                    result.setText("Material cost invaild");
//                }

            }
        });
    }
}