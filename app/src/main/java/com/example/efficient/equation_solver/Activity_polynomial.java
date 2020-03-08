package com.example.efficient.equation_solver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Activity_polynomial extends AppCompatActivity {
    int variable;
    Button two_degree_but;
    EditText two_degree_text1,two_degree_text2,two_degree_text3;
    ListView two_degree_show;
    Button three_degree_but;
    EditText three_degree_text1,three_degree_text2,three_degree_text3,three_degree_text4;
    ListView three_degree_show;
    Button four_degree_but;
    EditText four_degree_text1,four_degree_text2,four_degree_text3,four_degree_text4,four_degree_text5;
    ListView four_degree_show;
    Button five_degree_but;
    EditText five_degree_text1,five_degree_text2,five_degree_text3,five_degree_text4,five_degree_text5,five_degree_text6;
    ListView five_degree_show;
    Button six_degree_but;
    EditText six_degree_text1,six_degree_text2,six_degree_text3,six_degree_text4,six_degree_text5,six_degree_text6,six_degree_text7;
    ListView six_degree_show;
    final DatabaseHandler db = new DatabaseHandler(this);
    public int isDouble( String input )
    {
        try
        {
            Double.parseDouble( input );
            return 1;
        }
        catch( Exception e )
        {
            return 0;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent myIntent = getIntent(); // gets the previously created intent
        String firstKeyName = myIntent.getStringExtra("variable");
        variable = Integer.parseInt(firstKeyName);
        if (variable == 2)
        {
            setContentView(R.layout.activity_finding_root_degree_two);
            two_degree_text1 = (EditText)findViewById(R.id.root_textinput1);
            two_degree_text2 = (EditText)findViewById(R.id.root_textinput2);
            two_degree_text3 = (EditText)findViewById(R.id.root_textinput3);
            two_degree_show =(ListView) findViewById(R.id.root_listview);
            two_degree_but=(Button) findViewById(R.id.root_but1);
            two_degree_but.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String Input1 = two_degree_text1.getText().toString();
                    String Input2 = two_degree_text2.getText().toString();
                    String Input3 = two_degree_text3.getText().toString();
                    String eqn_2_deg ="";
                    eqn_2_deg +="Polynomial equation  is: ";
                    eqn_2_deg += Input1+"x^2+ ";
                    eqn_2_deg += Input2+"x+ ";
                    eqn_2_deg += Input3 +" = 0";
                    if(isDouble(Input1)!=1 || isDouble(Input2)!=1 || isDouble(Input3)!=1)
                    {
                        Toast.makeText(getBaseContext(),"Please give numeric number for getting root",Toast.LENGTH_LONG).show();
                        ((EditText)findViewById(R.id.root_textinput1)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput2)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput3)).setText(" ");
                    }

                    else if(Input1 == null || Input2 == null || Input3 == null || Input1.trim().equals("") || Input2.trim().equals("") || Input3.trim().equals("") )
                    {
                        Toast.makeText(getBaseContext(),"Null item",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        root.clear();
                        input.clear();
                        input.add(Double.parseDouble(Input1));
                        input.add(Double.parseDouble(Input2));
                        input.add(Double.parseDouble(Input3));

                        get_input(2,input);

                        ArrayAdapter<Double> myAdapter = new ArrayAdapter<Double>(Activity_polynomial.this,android.R.layout.simple_list_item_1,root);

                        String roots= "";
                        for(int i=0;i<root.size();i++)
                        {
                            roots += root.get(i).toString()+", ";

                        }
                        db.addEquation(new Equation(eqn_2_deg,roots));

                        //System.out.println(r.r.size());
                        // updatedData(a);
                        two_degree_show.setAdapter(myAdapter);
                        input.clear();
                        ((EditText)findViewById(R.id.root_textinput1)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput2)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput3)).setText(" ");

                    }
                }
            });
        }
        else if (variable == 3)
        {
            setContentView(R.layout.activity_finding_root_degree_three);
            three_degree_text1 = (EditText)findViewById(R.id.root_textinput1);
            three_degree_text2 = (EditText)findViewById(R.id.root_textinput2);
            three_degree_text3 = (EditText)findViewById(R.id.root_textinput3);
            three_degree_text4 = (EditText)findViewById(R.id.root_textinput4);


            three_degree_show =(ListView) findViewById(R.id.root_listview);
            three_degree_but=(Button) findViewById(R.id.root_but1);
            three_degree_but.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String Input1 = three_degree_text1.getText().toString();
                    String Input2 = three_degree_text2.getText().toString();
                    String Input3 = three_degree_text3.getText().toString();
                    String Input4 = three_degree_text4.getText().toString();
                    String eqn_3_deg ="";
                    eqn_3_deg +="Polynomial equation  is: ";
                    eqn_3_deg += Input1+"x^3+ ";
                    eqn_3_deg += Input2+"x^2+ ";
                    eqn_3_deg += Input3+"x+ ";
                    eqn_3_deg += Input4 +" = 0";

                    if(isDouble(Input1)!=1 || isDouble(Input2)!=1 || isDouble(Input3)!=1 || isDouble(Input4)!=1)
                    {
                        Toast.makeText(getBaseContext(),"Please give numeric number for getting root",Toast.LENGTH_LONG).show();
                        ((EditText)findViewById(R.id.root_textinput1)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput2)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput3)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput4)).setText(" ");
                    }

                    else if(Input1 == null || Input2 == null || Input3 == null || Input4 == null ||  Input1.trim().equals("") || Input2.trim().equals("") || Input3.trim().equals("") || Input4.trim().equals(""))
                    {
                        Toast.makeText(getBaseContext(),"Null item",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        root.clear();
                        input.clear();
                        input.add(Double.parseDouble(Input1));
                        input.add(Double.parseDouble(Input2));
                        input.add(Double.parseDouble(Input3));
                        input.add(Double.parseDouble(Input4));

                        get_input(3,input);

                        ArrayAdapter<Double> myAdapter = new ArrayAdapter<Double>(Activity_polynomial.this,android.R.layout.simple_list_item_1,root);

                        String roots= "";
                        for(int i=0;i<root.size();i++)
                        {
                            roots += root.get(i).toString()+", ";

                        }
                        db.addEquation(new Equation(eqn_3_deg,roots));
                        //System.out.println(r.r.size());
                        // updatedData(a);
                        three_degree_show.setAdapter(myAdapter);
                        input.clear();
                        ((EditText)findViewById(R.id.root_textinput1)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput2)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput3)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput4)).setText(" ");
                    }
                }
            });
        }

        else if (variable == 4)
        {
            setContentView(R.layout.activity_finding_root_degree_four);
            four_degree_text1 = (EditText)findViewById(R.id.root_textinput1);
            four_degree_text2 = (EditText)findViewById(R.id.root_textinput2);
            four_degree_text3 = (EditText)findViewById(R.id.root_textinput3);
            four_degree_text4 = (EditText)findViewById(R.id.root_textinput4);
            four_degree_text5 = (EditText)findViewById(R.id.root_textinput5);
            four_degree_show =(ListView) findViewById(R.id.root_listview);
            four_degree_but=(Button) findViewById(R.id.root_but1);
            four_degree_but.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String Input1 = four_degree_text1.getText().toString();
                    String Input2 = four_degree_text2.getText().toString();
                    String Input3 = four_degree_text3.getText().toString();
                    String Input4 = four_degree_text4.getText().toString();
                    String Input5 = four_degree_text5.getText().toString();

                    String eqn_4_deg ="";
                    eqn_4_deg +="Polynomial equation  is: ";
                    eqn_4_deg += Input1+"x^4+ ";
                    eqn_4_deg += Input2+"x^3+ ";
                    eqn_4_deg += Input3+"x^2+ ";
                    eqn_4_deg += Input4+"x+ ";
                    eqn_4_deg += Input5 +" = 0";


                    if(isDouble(Input1)!=1 || isDouble(Input2)!=1 || isDouble(Input3)!=1 || isDouble(Input4)!=1 || isDouble(Input5)!=1)
                    {
                        Toast.makeText(getBaseContext(),"Please give numeric number for getting root",Toast.LENGTH_LONG).show();
                        ((EditText)findViewById(R.id.root_textinput1)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput2)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput3)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput4)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput5)).setText(" ");
                    }

                    else if(Input1 == null || Input2 == null || Input3 == null || Input4 == null || Input5 == null || Input1.trim().equals("") || Input2.trim().equals("") || Input3.trim().equals("") || Input4.trim().equals("") || Input5.trim().equals(""))
                    {
                        Toast.makeText(getBaseContext(),"Null item",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        root.clear();
                        input.clear();
                        input.add(Double.parseDouble(Input1));
                        input.add(Double.parseDouble(Input2));
                        input.add(Double.parseDouble(Input3));
                        input.add(Double.parseDouble(Input4));
                        input.add(Double.parseDouble(Input5));

                        get_input(4,input);

                        ArrayAdapter<Double> myAdapter = new ArrayAdapter<Double>(Activity_polynomial.this,android.R.layout.simple_list_item_1,root);

                        String roots= "";
                        for(int i=0;i<root.size();i++)
                        {
                            roots += root.get(i).toString()+", ";

                        }
                        db.addEquation(new Equation(eqn_4_deg,roots));

                        //System.out.println(r.r.size());
                        // updatedData(a);
                        four_degree_show.setAdapter(myAdapter);
                        input.clear();
                        ((EditText)findViewById(R.id.root_textinput1)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput2)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput3)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput4)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput5)).setText(" ");
                    }
                }
            });
        }
        else if(variable == 5)
        {
            setContentView(R.layout.activity_finding_root_degree_five);
            five_degree_text1 = (EditText)findViewById(R.id.root_textinput1);
            five_degree_text2 = (EditText)findViewById(R.id.root_textinput2);
            five_degree_text3 = (EditText)findViewById(R.id.root_textinput3);
            five_degree_text4 = (EditText)findViewById(R.id.root_textinput4);
            five_degree_text5 = (EditText)findViewById(R.id.root_textinput5);
            five_degree_text6 = (EditText)findViewById(R.id.root_textinput6);
            five_degree_show =(ListView) findViewById(R.id.root_listview);
            five_degree_but=(Button) findViewById(R.id.root_but1);
            five_degree_but.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String Input1 = five_degree_text1.getText().toString();
                    String Input2 = five_degree_text2.getText().toString();
                    String Input3 = five_degree_text3.getText().toString();
                    String Input4 = five_degree_text4.getText().toString();
                    String Input5 = five_degree_text5.getText().toString();
                    String Input6 = five_degree_text6.getText().toString();

                    String eqn_5_deg ="";
                    eqn_5_deg +="Polynomial equation  is: ";
                    eqn_5_deg += Input1+"x^5+ ";
                    eqn_5_deg += Input2+"x^4+ ";
                    eqn_5_deg += Input3+"x^3+ ";
                    eqn_5_deg += Input4+"x^2+ ";
                    eqn_5_deg += Input5+"x+ ";
                    eqn_5_deg += Input6 +" = 0";


                    if(isDouble(Input1)!=1 || isDouble(Input2)!=1 || isDouble(Input3)!=1 || isDouble(Input4)!=1 || isDouble(Input5)!=1 || isDouble(Input6)!=1)
                    {
                        Toast.makeText(getBaseContext(),"Please give numeric number for getting root",Toast.LENGTH_LONG).show();
                        ((EditText)findViewById(R.id.root_textinput1)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput2)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput3)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput4)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput5)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput6)).setText(" ");
                    }

                    else if(Input1 == null || Input2 == null || Input3 == null || Input4 == null || Input5 == null || Input6 == null || Input1.trim().equals("") || Input2.trim().equals("") || Input3.trim().equals("") || Input4.trim().equals("") || Input5.trim().equals("") || Input6.trim().equals(""))
                    {
                        Toast.makeText(getBaseContext(),"Null item",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        root.clear();
                        input.clear();
                        input.add(Double.parseDouble(Input1));
                        input.add(Double.parseDouble(Input2));
                        input.add(Double.parseDouble(Input3));
                        input.add(Double.parseDouble(Input4));
                        input.add(Double.parseDouble(Input5));
                        input.add(Double.parseDouble(Input6));

                        get_input(5,input);

                        ArrayAdapter<Double> myAdapter = new ArrayAdapter<Double>(Activity_polynomial.this,android.R.layout.simple_list_item_1,root);

                        String roots= "";
                        for(int i=0;i<root.size();i++)
                        {
                            roots += root.get(i).toString()+", ";

                        }
                        db.addEquation(new Equation(eqn_5_deg,roots));

                        //System.out.println(r.r.size());
                        // updatedData(a);
                        five_degree_show.setAdapter(myAdapter);
                        input.clear();
                        ((EditText)findViewById(R.id.root_textinput1)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput2)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput3)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput4)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput5)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput6)).setText(" ");
                    }
                }
            });
        }
        else if (variable == 6)
        {
            setContentView(R.layout.activity_finding_root_degree_six);
            six_degree_text1 = (EditText)findViewById(R.id.root_textinput1);
            six_degree_text2 = (EditText)findViewById(R.id.root_textinput2);
            six_degree_text3 = (EditText)findViewById(R.id.root_textinput3);
            six_degree_text4 = (EditText)findViewById(R.id.root_textinput4);
            six_degree_text5 = (EditText)findViewById(R.id.root_textinput5);
            six_degree_text6 = (EditText)findViewById(R.id.root_textinput6);
            six_degree_text7 = (EditText)findViewById(R.id.root_textinput7);
            six_degree_show =(ListView) findViewById(R.id.root_listview);
            six_degree_but=(Button) findViewById(R.id.root_but1);
            six_degree_but.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String Input1 = six_degree_text1.getText().toString();
                    String Input2 = six_degree_text2.getText().toString();
                    String Input3 = six_degree_text3.getText().toString();
                    String Input4 = six_degree_text4.getText().toString();
                    String Input5 = six_degree_text5.getText().toString();
                    String Input6 = six_degree_text6.getText().toString();
                    String Input7 = six_degree_text7.getText().toString();

                    String eqn_6_deg ="";
                    eqn_6_deg +="Polynomial equation  is: ";
                    eqn_6_deg += Input1+"x^6+ ";
                    eqn_6_deg += Input2+"x^5+ ";
                    eqn_6_deg += Input3+"x^4+ ";
                    eqn_6_deg += Input4+"x^3+ ";
                    eqn_6_deg += Input5+"x^2+ ";
                    eqn_6_deg += Input6+"x+ ";
                    eqn_6_deg += Input7 +" = 0";


                    if(isDouble(Input1)!=1 || isDouble(Input2)!=1 || isDouble(Input3)!=1 || isDouble(Input4)!=1 || isDouble(Input5)!=1 || isDouble(Input6)!=1 || isDouble(Input7)!=1)
                    {
                        Toast.makeText(getBaseContext(),"Please give numeric number for getting root",Toast.LENGTH_LONG).show();
                        ((EditText)findViewById(R.id.root_textinput1)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput2)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput3)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput4)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput5)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput6)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput7)).setText(" ");
                    }

                    else if(Input1 == null || Input2 == null || Input3 == null || Input4 == null || Input5 == null || Input6 == null || Input7 == null || Input1.trim().equals("") || Input2.trim().equals("") || Input3.trim().equals("") || Input4.trim().equals("") || Input5.trim().equals("") || Input6.trim().equals("") || Input7.trim().equals(""))
                    {
                        Toast.makeText(getBaseContext(),"Null item",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        root.clear();
                        input.clear();
                        input.add(Double.parseDouble(Input1));
                        input.add(Double.parseDouble(Input2));
                        input.add(Double.parseDouble(Input3));
                        input.add(Double.parseDouble(Input4));
                        input.add(Double.parseDouble(Input5));
                        input.add(Double.parseDouble(Input6));
                        input.add(Double.parseDouble(Input7));

                        get_input(6,input);
                        ArrayAdapter<Double> myAdapter = new ArrayAdapter<Double>(Activity_polynomial.this,android.R.layout.simple_list_item_1,root);

                        String roots= "";
                        for(int i=0;i<root.size();i++)
                        {
                            roots += root.get(i).toString()+", ";

                        }
                        db.addEquation(new Equation(eqn_6_deg,roots));

                        //System.out.println(r.r.size());
                        // updatedData(a);
                        six_degree_show.setAdapter(myAdapter);
                        input.clear();
                        ((EditText)findViewById(R.id.root_textinput1)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput2)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput3)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput4)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput5)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput6)).setText(" ");
                        ((EditText)findViewById(R.id.root_textinput7)).setText(" ");
                    }
                }
            });
        }
    }
    static ArrayList<Double> root = new ArrayList<Double>();
    static ArrayList<Double> input = new ArrayList<Double>();
    double e=0.00001;
    void get_input(int variableNo, ArrayList<Double> arr)
    {
        double d=0.1;
        double a = -100,b=100;
        int n = variableNo;
        do
        {
            bisection(a,a+d,n,arr);
            a=a+d;
        }while(a<b);
    }
    double horner(double x,int n,ArrayList<Double> arr)
    {

        double result=arr.get(0);
        for(int i=1;i<=n;i++)
        {
            result=result*x+arr.get(i);
        }
        System.out.println("for "+x+" value is "+result);
        return result;
    }
    double err(double x1,double x2)
    {
        return ((x2-x1)/x2);
    }
    void bisection(double x1,double x2,int n,ArrayList<Double> arr)
    {

        double f1= horner(x1,n,arr);
        double f2= horner(x2,n,arr);
        if(f1*f2>0)
        {System.out.println("hello world");
            return;
        }
        double x0,f0,error;
        do
        {
            x0=(x1+x2)/2;
            f0=horner(x0,n,arr);
            if(f1*f0<0)
                x2=x0;
            else
                x1=x0;
            error= Math.abs(err(x1,x2));
        }while(error>e);
        //root.add(x0);
        root.add(Double.parseDouble(String.format("%.2f",x0)));
    }

}
