package com.example.efficient.equation_solver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_OptionsForLinear extends AppCompatActivity {
    Button two_var ;
    Button three_var ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__options_for_linear);
        two_var=(Button)findViewById(R.id.two_variable);
        three_var=(Button)findViewById(R.id.three_variable);
        two_var.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_OptionsForLinear.this,Activity_Linear.class);
                i.putExtra("variable","2");
                startActivity(i);
            }
        });
        three_var.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_OptionsForLinear.this,Activity_Linear.class);
                i.putExtra("variable","3");
                startActivity(i);
            }
        });
    }
}
