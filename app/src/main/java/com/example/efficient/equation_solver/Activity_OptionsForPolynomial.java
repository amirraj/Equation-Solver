package com.example.efficient.equation_solver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_OptionsForPolynomial extends AppCompatActivity {
    Button degree_two,degree_three,degree_four,degree_five,degree_six;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__options_for_polynomial);
        degree_two = (Button)findViewById(R.id.degree_two);
        degree_three = (Button)findViewById(R.id.degree_three);
        degree_four = (Button)findViewById(R.id.degree_four);
        degree_five = (Button)findViewById(R.id.degree_five);
        degree_six = (Button)findViewById(R.id.degree_six);


        degree_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_OptionsForPolynomial.this,Activity_polynomial.class);
                i.putExtra("variable","2");
                startActivity(i);
            }
        });

        degree_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_OptionsForPolynomial.this,Activity_polynomial.class);
                i.putExtra("variable","3");
                startActivity(i);
            }
        });

        degree_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_OptionsForPolynomial.this,Activity_polynomial.class);
                i.putExtra("variable","4");
                startActivity(i);
            }
        });

        degree_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_OptionsForPolynomial.this,Activity_polynomial.class);
                i.putExtra("variable","5");
                startActivity(i);
            }
        });

        degree_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_OptionsForPolynomial.this,Activity_polynomial.class);
                i.putExtra("variable","6");
                startActivity(i);
            }
        });
    }
}
