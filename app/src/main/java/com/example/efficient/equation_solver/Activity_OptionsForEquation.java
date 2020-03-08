package com.example.efficient.equation_solver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_OptionsForEquation extends AppCompatActivity {

    Button polynomial_but ;
    Button linear_but ;
    Button database_but ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__options_for_equation);
        polynomial_but=(Button)findViewById(R.id.polynomial_button);
        linear_but=(Button)findViewById(R.id.linear_button);
        database_but=(Button)findViewById(R.id.database_button);
        polynomial_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("i was here");
                Intent i = new Intent(Activity_OptionsForEquation.this,Activity_OptionsForPolynomial.class);
                startActivity(i);
            }
        });
        linear_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(Activity_OptionsForEquation.this,Activity_OptionsForLinear.class);
                startActivity(j);
            }
        });
        database_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("i was here");
                Intent i = new Intent(Activity_OptionsForEquation.this,Activity_database.class);
                startActivity(i);
            }
        });

    }
}
