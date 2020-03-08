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

import java.util.ArrayList;

public class Activity_Linear extends AppCompatActivity {
    int variable;

    Button two_variable_but;
    Button three_variable_but;
    EditText x_equ1, y_equ1, const_equ1,x_equ2, y_equ2, const_equ2,x_equ3, y_equ3, const_equ3,z_equ1, z_equ2,z_equ3;
    ListView two_variable_show;
    ListView three_variable_show;
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
        if (variable == 3)
        {
            setContentView(R.layout.activity_linear_3_variable);

            x_equ1 = (EditText)findViewById(R.id.x1value);
            y_equ1 = (EditText)findViewById(R.id.y1value);
            z_equ1 = (EditText)findViewById(R.id.z1value);
            const_equ1 = (EditText)findViewById(R.id.constant1);

            x_equ2 = (EditText)findViewById(R.id.x2value);
            y_equ2 = (EditText)findViewById(R.id.y2value);
            z_equ2 = (EditText)findViewById(R.id.z2value);
            const_equ2 = (EditText)findViewById(R.id.constant2);
            x_equ3 = (EditText)findViewById(R.id.x3value);
            y_equ3 = (EditText)findViewById(R.id.y3value);
            z_equ3 = (EditText)findViewById(R.id.z3value);
            const_equ3 = (EditText)findViewById(R.id.constant3);

            three_variable_show =(ListView) findViewById(R.id.linear_listview3);
            three_variable_but =(Button) findViewById(R.id.solution_3var);
            three_variable_but.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String Input1 = x_equ1.getText().toString();
                    String Input2 = y_equ1.getText().toString();
                    String Input3 = z_equ1.getText().toString();
                    String Input4 = const_equ1.getText().toString();

                    String Input5 = x_equ2.getText().toString();
                    String Input6 = y_equ2.getText().toString();
                    String Input7 = z_equ2.getText().toString();
                    String Input8 = const_equ2.getText().toString();

                    String Input9 = x_equ3.getText().toString();
                    String Input10 = y_equ3.getText().toString();
                    String Input11 = z_equ3.getText().toString();
                    String Input12 = const_equ3.getText().toString();

                    String Lin_eqn_3var ="";
                    Lin_eqn_3var +="Linear equations  are: ";
                    Lin_eqn_3var += Input1+"x+ ";
                    Lin_eqn_3var += Input2+"y+ ";
                    Lin_eqn_3var += Input3+"z+ = ";
                    Lin_eqn_3var += Input4+" " ;
                    Lin_eqn_3var += Input5+"x+ ";
                    Lin_eqn_3var += Input6+"y+ ";
                    Lin_eqn_3var += Input7+"z+ = ";
                    Lin_eqn_3var += Input8+" " ;
                    Lin_eqn_3var += Input9+"x+ ";
                    Lin_eqn_3var += Input10+"y+ ";
                    Lin_eqn_3var += Input11+"z+ = ";
                    Lin_eqn_3var += Input12+" " ;


                    if(isDouble(Input1)!=1 || isDouble(Input2)!=1 || isDouble(Input3)!=1 || isDouble(Input4)!=1 || isDouble(Input5)!=1 || isDouble(Input6)!=1  || (isDouble(Input7)!=1 || isDouble(Input8)!=1 || isDouble(Input9)!=1 || isDouble(Input10)!=1 || isDouble(Input11)!=1 || isDouble(Input12)!=1))
                    {
                        Toast.makeText(getBaseContext(),"Please give numeric number for getting root",Toast.LENGTH_LONG).show();
                        ((EditText)findViewById(R.id.x1value)).setText(" ");
                        ((EditText)findViewById(R.id.y1value)).setText(" ");
                        ((EditText)findViewById(R.id.z1value)).setText(" ");
                        ((EditText)findViewById(R.id.constant1)).setText(" ");
                        ((EditText)findViewById(R.id.x2value)).setText(" ");
                        ((EditText)findViewById(R.id.y2value)).setText(" ");
                        ((EditText)findViewById(R.id.z2value)).setText(" ");
                        ((EditText)findViewById(R.id.constant2)).setText(" ");

                        ((EditText)findViewById(R.id.x3value)).setText(" ");
                        ((EditText)findViewById(R.id.y3value)).setText(" ");
                        ((EditText)findViewById(R.id.z3value)).setText(" ");
                        ((EditText)findViewById(R.id.constant3)).setText(" ");

                    }

                    else if(Input1 == null || Input2 == null || Input3 == null || Input4 == null || Input5 == null || Input6 == null || Input1.trim().equals("") || Input2.trim().equals("") || Input3.trim().equals("") || Input4.trim().equals("") || Input5.trim().equals("") || Input6.trim().equals("") || Input7 == null || Input8 == null || Input9 == null || Input10 == null || Input11 == null || Input12 == null || Input7.trim().equals("") || Input8.trim().equals("") || Input9.trim().equals("") || Input10.trim().equals("") || Input11.trim().equals("") || Input12.trim().equals("") )
                    {
                        Toast.makeText(getBaseContext(),"Null item",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        ans.clear();
                        variables.clear();
                        variables.add(Double.parseDouble(Input1));
                        variables.add(Double.parseDouble(Input2));
                        variables.add(Double.parseDouble(Input3));
                        variables.add(Double.parseDouble(Input4));
                        variables.add(Double.parseDouble(Input5));
                        variables.add(Double.parseDouble(Input6));
                        variables.add(Double.parseDouble(Input7));
                        variables.add(Double.parseDouble(Input8));
                        variables.add(Double.parseDouble(Input9));
                        variables.add(Double.parseDouble(Input10));
                        variables.add(Double.parseDouble(Input11));
                        variables.add(Double.parseDouble(Input12));

                        //   LinearEquationSolver obj = new LinearEquationSolver(2,variables);
                        linear(3,variables);

                        ArrayAdapter myAdapter = new ArrayAdapter(Activity_Linear.this,android.R.layout.simple_list_item_1,ans);

                        String roots= "";
                        for(int i=0;i<ans.size();i++)
                        {
                            roots += ans.get(0).toString()+", ";

                        }
                        db.addEquation(new Equation(Lin_eqn_3var,roots));

                        three_variable_show.setAdapter(myAdapter);
                        variables.clear();
                        ((EditText)findViewById(R.id.x1value)).setText(" ");
                        ((EditText)findViewById(R.id.y1value)).setText(" ");
                        ((EditText)findViewById(R.id.z1value)).setText(" ");
                        ((EditText)findViewById(R.id.constant1)).setText(" ");
                        ((EditText)findViewById(R.id.x2value)).setText(" ");
                        ((EditText)findViewById(R.id.y2value)).setText(" ");
                        ((EditText)findViewById(R.id.z2value)).setText(" ");
                        ((EditText)findViewById(R.id.constant2)).setText(" ");

                        ((EditText)findViewById(R.id.x3value)).setText(" ");
                        ((EditText)findViewById(R.id.y3value)).setText(" ");
                        ((EditText)findViewById(R.id.z3value)).setText(" ");
                        ((EditText)findViewById(R.id.constant3)).setText(" ");

                    }
                }
            });

        }

        else

        {
            setContentView(R.layout.activity_linear_2_variable);

            x_equ1 = (EditText)findViewById(R.id.x1value);
            y_equ1 = (EditText)findViewById(R.id.y1value);
            const_equ1 = (EditText)findViewById(R.id.constant1);

            x_equ2 = (EditText)findViewById(R.id.x2value);
            y_equ2 = (EditText)findViewById(R.id.y2value);
            const_equ2 = (EditText)findViewById(R.id.constant2);
            two_variable_show =(ListView) findViewById(R.id.linear_listview);
            two_variable_but =(Button) findViewById(R.id.solution_3var);
            two_variable_but.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String Input1 = x_equ1.getText().toString();
                    String Input2 = y_equ1.getText().toString();
                    String Input3 = const_equ1.getText().toString();

                    String Input4 = x_equ2.getText().toString();
                    String Input5 = y_equ2.getText().toString();
                    String Input6 = const_equ2.getText().toString();

                    String Lin_eqn_2var ="";
                    Lin_eqn_2var +="Linear equations  are: ";
                    Lin_eqn_2var += Input1+"x+ ";
                    Lin_eqn_2var += Input2+"y+ = ";
                    Lin_eqn_2var += Input3+" " ;
                    Lin_eqn_2var += Input4+"x+ ";
                    Lin_eqn_2var += Input5+"y+ = ";
                    Lin_eqn_2var += Input6+" " ;

                    if(isDouble(Input1)!=1 || isDouble(Input2)!=1 || isDouble(Input3)!=1 || isDouble(Input4)!=1 || isDouble(Input5)!=1 || isDouble(Input6)!=1)
                    {
                        Toast.makeText(getBaseContext(),"Please give numeric number for getting root",Toast.LENGTH_LONG).show();
                        ((EditText)findViewById(R.id.x1value)).setText(" ");
                        ((EditText)findViewById(R.id.y1value)).setText(" ");
                        ((EditText)findViewById(R.id.constant1)).setText(" ");
                        ((EditText)findViewById(R.id.x2value)).setText(" ");
                        ((EditText)findViewById(R.id.y2value)).setText(" ");
                        ((EditText)findViewById(R.id.constant2)).setText(" ");

                    }

                    else if(Input1 == null || Input2 == null || Input3 == null || Input4 == null || Input5 == null || Input6 == null || Input1.trim().equals("") || Input2.trim().equals("") || Input3.trim().equals("") || Input4.trim().equals("") || Input5.trim().equals("") || Input6.trim().equals("") )
                    {
                        Toast.makeText(getBaseContext(),"Null item",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        ans.clear();
                        //variables.clear();
                        variables.add(Double.parseDouble(Input1));
                        variables.add(Double.parseDouble(Input2));
                        variables.add(Double.parseDouble(Input3));
                        variables.add(Double.parseDouble(Input4));
                        variables.add(Double.parseDouble(Input5));
                        variables.add(Double.parseDouble(Input6));

                        //   LinearEquationSolver obj = new LinearEquationSolver(2,variables);
                        linear(2,variables);
                        ArrayAdapter myAdapter = new ArrayAdapter(Activity_Linear.this,android.R.layout.simple_list_item_1,ans);

                        String roots= "";
                        for(int i=0;i<ans.size();i++)
                        {
                            roots += ans.get(0).toString()+", ";

                        }
                        db.addEquation(new Equation(Lin_eqn_2var,roots));

                        two_variable_show.setAdapter(myAdapter);
                        variables.clear();
                        ((EditText)findViewById(R.id.x1value)).setText(" ");
                        ((EditText)findViewById(R.id.y1value)).setText(" ");
                        ((EditText)findViewById(R.id.constant1)).setText(" ");
                        ((EditText)findViewById(R.id.x2value)).setText(" ");
                        ((EditText)findViewById(R.id.y2value)).setText(" ");
                        ((EditText)findViewById(R.id.constant2)).setText(" ");

                    }
                }
            });
        }


    }


    static ArrayList<Double> ans = new ArrayList<Double>();
    static ArrayList<Double> variables = new ArrayList<Double>();
    public static void linear (int variableNo, ArrayList<Double> arr){

        System.out.println("Enter the number of variables in the equations: ");
        //Scanner input = new Scanner(System.in);
        int n = variableNo;//input.nextInt();
        System.out.println("Enter the coefficients of each variable for each equations");
        System.out.println("ax + by + cz + ... = d");
        double [][]mat = new double[n][n];
        double [][]constants = new double[n][1];
        int index = 0;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                mat[i][j] = arr.get(index);
                index++;//input.nextDouble();
            }
            constants[i][0] = arr.get(index);
            index++;//input.nextDouble();
        }

        //inverse of matrix mat[][]
        double inverted_mat[][] = invert(mat);
        double result[][] = new double[variableNo][1];
        for (int i = 0; i < variableNo; i++)
        {
            for (int j = 0; j < 1; j++)
            {
                for (int k = 0; k < variableNo; k++)
                {
                    result[i][j] = result[i][j] + inverted_mat[i][k] * constants[k][j];
                }
            }
        }
        System.out.println("The product is:");
        for(int i=0; i<variableNo; i++)
        {
            //System.out.println(result[i][0] + " ");
            ans.add(Double.parseDouble(String.format("%.2f",result[i][0])));
        }


    }

    public static double[][] invert(double a[][])
    {
        int n = a.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i=0; i<n; ++i)
            b[i][i] = 1;

        // Transform the matrix into an upper triangle
        gaussian(a, index);

        // Update the matrix b[i][j] with the ratios stored
        for (int i=0; i<n-1; ++i)
            for (int j=i+1; j<n; ++j)
                for (int k=0; k<n; ++k)
                    b[index[j]][k]
                            -= a[index[j]][i]*b[index[i]][k];

        // Perform backward substitutions
        for (int i=0; i<n; ++i)
        {
            x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
            for (int j=n-2; j>=0; --j)
            {
                x[j][i] = b[index[j]][i];
                for (int k=j+1; k<n; ++k)
                {
                    x[j][i] -= a[index[j]][k]*x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }

// Method to carry out the partial-pivoting Gaussian
// elimination.  Here index[] stores pivoting order.

    public static void gaussian(double a[][], int index[])
    {
        int n = index.length;
        double c[] = new double[n];

        // Initialize the index
        for (int i=0; i<n; ++i)
            index[i] = i;

        // Find the rescaling factors, one from each row
        for (int i=0; i<n; ++i)
        {
            double c1 = 0;
            for (int j=0; j<n; ++j)
            {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }

        // Search the pivoting element from each column
        int k = 0;
        for (int j=0; j<n-1; ++j)
        {
            double pi1 = 0;
            for (int i=j; i<n; ++i)
            {
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1)
                {
                    pi1 = pi0;
                    k = i;
                }
            }

            // Interchange rows according to the pivoting order
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i=j+1; i<n; ++i)
            {
                double pj = a[index[i]][j]/a[index[j]][j];

                // Record pivoting ratios below the diagonal
                a[index[i]][j] = pj;

                // Modify other elements accordingly
                for (int l=j+1; l<n; ++l)
                    a[index[i]][l] -= pj*a[index[j]][l];
            }
        }
    }
}
