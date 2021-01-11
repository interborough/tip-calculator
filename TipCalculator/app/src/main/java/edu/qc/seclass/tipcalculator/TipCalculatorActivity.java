package edu.qc.seclass.tipcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TipCalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button computeButton = findViewById(R.id.buttonCompute);
        computeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText checkAmountText = findViewById(R.id.checkAmountValue);
                EditText partySizeText = findViewById(R.id.partySizeValue);
                CharSequence toastText = "Empty or incorrect value(s)!";
                int checkAmount = 0;
                int partySize = 0;

                try {
                    checkAmount = Integer.parseInt(checkAmountText.getText().toString().trim());
                    partySize = Integer.parseInt(partySizeText.getText().toString().trim());
                }
                catch(Exception e) {
                    Toast.makeText(getApplicationContext(), toastText, Toast.LENGTH_SHORT).show();
                }

                if(checkAmount < 0 || partySize < 1)
                {
                    Toast.makeText(getApplicationContext(), toastText, Toast.LENGTH_SHORT).show();
                    return;
                }

                //We only need to initialize these variables if the input is valid.
                EditText fifteenPercentTipValueText = findViewById(R.id.fifteenPercentTipValue);
                EditText twentyPercentTipValueText = findViewById(R.id.twentyPercentTipValue);
                EditText twentyfivePercentTipValueText = findViewById(R.id.twentyfivePercentTipValue);
                EditText fifteenPercentTotalValueText = findViewById(R.id.fifteenPercentTotalValue);
                EditText twentyPercentTotalValueText = findViewById(R.id.twentyPercentTotalValue);
                EditText twentyfivePercentTotalValueText = findViewById(R.id.twentyfivePercentTotalValue);

                int fifteenPercentTipValue = (int) Math.round(((checkAmount * 0.15) / partySize));
                int twentyPercentTipValue = (int) Math.round(((checkAmount * 0.20) / partySize));
                int twentyfivePercentTipValue = (int) Math.round(((checkAmount * 0.25) / partySize));

                int fifteenPercentTotalValue = (int) Math.round(((checkAmount * 1.15) / partySize));
                int twentyPercentTotalValue = (int) Math.round(((checkAmount * 1.20) / partySize));
                int twentyfivePercentTotalValue = (int) Math.round(((checkAmount * 1.25) / partySize));

                fifteenPercentTipValueText.setText(String.valueOf(fifteenPercentTipValue));
                twentyPercentTipValueText.setText(String.valueOf(twentyPercentTipValue));
                twentyfivePercentTipValueText.setText(String.valueOf(twentyfivePercentTipValue));

                fifteenPercentTotalValueText.setText(String.valueOf(fifteenPercentTotalValue));
                twentyPercentTotalValueText.setText(String.valueOf(twentyPercentTotalValue));
                twentyfivePercentTotalValueText.setText(String.valueOf(twentyfivePercentTotalValue));
            }
        });
    }
}