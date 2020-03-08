package com.example.efficient.equation_solver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Activity_database extends AppCompatActivity {
    public static String USER_NAME= "UserName";
    Button getAllBtn,addNewContact,deleteContact,getSingleContactBtn,updateBtn;
    EditText eqnBox, rootBox, id;
    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        notify("onCreate");

        getAllBtn = (Button)findViewById(R.id.goToSecondPageBtn);
        updateBtn = (Button)findViewById(R.id.updateBtn);
        eqnBox = (EditText) findViewById(R.id.equationET);

        addNewContact = (Button)findViewById(R.id.addNewContactBtn);
        rootBox = (EditText) findViewById(R.id.rootET);

        deleteContact = (Button)findViewById(R.id.deleteContactBtn);
        id = (EditText) findViewById(R.id.contactIdET);

        getSingleContactBtn = (Button)findViewById(R.id.getSingleContactBtn);

        display = (TextView) findViewById(R.id.displayTV);
        display.setMovementMethod(new ScrollingMovementMethod());

        final DatabaseHandler db=new DatabaseHandler(this);

        addNewContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String equation= eqnBox.getText().toString();
                String root= rootBox.getText().toString();
                if(equation.equals("") || root.equals(""))
                {
                    Toast.makeText (getApplicationContext(),"Information Missing",Toast.LENGTH_SHORT).show();
                }
                else{
                    db.addEquation(new Equation(equation,root));
                    Toast.makeText (getApplicationContext(),"New Equation Is Added.",Toast.LENGTH_SHORT).show();
                    eqnBox.setText(" ");
                    rootBox.setText(" ");
                    id.setText(" ");

                }
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
            }
        });

        deleteContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String contactIdValue= id.getText().toString();
                if(contactIdValue.equals(""))
                {
                    Toast.makeText (getApplicationContext(),"Information Missing",Toast.LENGTH_SHORT).show();
                }
                else{

                    db.deleteContact(Integer.parseInt(contactIdValue));
                    Toast.makeText (getApplicationContext(),contactIdValue+" is deleted",Toast.LENGTH_SHORT).show();
                    eqnBox.setText(" ");
                    rootBox.setText(" ");
                    id.setText(" ");
                }
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
            }
        });
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idNo= id.getText().toString();
                String equation= eqnBox.getText().toString();
                String root= rootBox.getText().toString();
                if(idNo.equals("") || equation.equals("") || root.equals("") )
                {
                    Toast.makeText (getApplicationContext(),"Information Missing",Toast.LENGTH_SHORT).show();
                }
                else{
                    db.updateEquation(new Equation(Integer.parseInt(idNo),equation,root));
                    Toast.makeText (getApplicationContext(),idNo+" is updated",Toast.LENGTH_SHORT).show();
                    eqnBox.setText(" ");
                    rootBox.setText(" ");
                    id.setText(" ");
                }
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
            }

        });

        getAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<Equation> myContactList=db.getAllEquation();
                String result = "";
                for(Equation myContact : myContactList)
                {
                    result +="Id: "+ myContact.getId()+" "+myContact.getName()+" roots: "+ myContact.getRoot();
                    result +="\n";
                    Log.d("Result",result);
                }
                if(myContactList.size()  == 0)
                {
                    result = "No contact to display.";
                }
                display.setText(result);

            }
        });

        getSingleContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String contactIdValue= id.getText().toString();
                if(contactIdValue.equals(""))
                {
                    Toast.makeText (getApplicationContext(),"Information Missing",Toast.LENGTH_SHORT).show();
                }
                else{
                    Equation myContact=db.getSingleEquation(Integer.parseInt(contactIdValue));
                    String result = "";
                    if(myContact == null)
                    {
                        result = "No contact to display.";
                    }
                    else{
                        result +="Id: "+ myContact.getId()+" "+myContact.getName()+" roots: "+ myContact.getRoot();
                    }
                    display.setText(result);
                    eqnBox.setText(" ");
                    rootBox.setText(" ");
                    id.setText(" ");
                }

            }
        });

    }

    public void showText(View v){
        //String userNameValue= eqnBox.getText().toString();
        //display.setText("Hi,"+ userNameValue);

        // Intent i = new Intent(getApplicationContext(),SecondActivity.class);
        // i.putExtra(USER_NAME,eqnBox.getText().toString());
        // startActivity(i);
    }



    @Override
    protected void onStart() {
        super.onStart();
        notify("onStart");
    }


    @Override
    protected void onPause() {
        super.onPause();
        notify("onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        notify("onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        notify("onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        notify("onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        notify("onDestroy");
    }

   /* @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        notify("onRestoreInstanceState");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        notify("onSaveInstanceState");
    }*/

    private void notify(String methodName) {
        Log.d("Demo-MainActivity: ",methodName);
    }
}
