package com.example.loancalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText LoanAmount,InterestRate,LoanTerm,LoanFees,MinimumPayment;
    private Button button;
    private TextView TotalInterest, MonthlyPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
    }

    public void addListenerOnButton()
    {
        LoanAmount = (EditText) findViewById(R.id.textLoanAmount);
        InterestRate = (EditText) findViewById(R.id.textInterestRate);
        LoanTerm = (EditText) findViewById(R.id.textLoanTerm);
        LoanFees = (EditText) findViewById(R.id.textLoanFees);
        button = (Button) findViewById(R.id.button);
        TotalInterest = (TextView)  findViewById(R.id.textViewTotalInterest);
        MonthlyPayment = (TextView)  findViewById(R.id.textViewMonthlyPayment);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value1 = LoanAmount.getText().toString();
                String value2 = InterestRate.getText().toString();
                String value3 = LoanTerm.getText().toString();
                String value4 = LoanFees.getText().toString();


                int a = Integer.parseInt(value1);
                int r = Integer.parseInt(value2);
                int t = Integer.parseInt(value3);
                int f = Integer.parseInt(value4);

                double ir = (double) ( 1 + .01 * r);
                double i = (double) ( ( a + f ) * (Math.pow(ir,t)) );
                double ti =  i - ( a + f );
                double mp = i / ( t * 12 );

                String totalInterest = String.valueOf(String.format("%.2f", ti));
                String monthlyPayment = String.valueOf(String.format("%.2f", mp));

                TotalInterest.setText(totalInterest);
                MonthlyPayment.setText(monthlyPayment);

            }
        });
    }
}