package com.example.efficient.equation_solver;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;



public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="myEquations";
    private static final String TABLE_NAME="Equation";
    private static final String KEY_ID="id";
    private static final String KEY_NAME="name";
    private static final String KEY_ROOT ="root";

    public DatabaseHandler(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        //Log.v("db created", "yes");
        String CREATE_CONTACT_TABLE="CREATE TABLE "+ TABLE_NAME +"("
                + KEY_ID +" INTEGER PRIMARY KEY,"
                + KEY_NAME +" TEXT,"
                + KEY_ROOT +" TEXT" +")";


        db.execSQL(CREATE_CONTACT_TABLE);
        //Log.v("db created", "yes");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public void addEquation(Equation equation)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "INSERT INTO EQUATION(NAME,ROOT)" +
                "VALUES('"+equation.getName()+"','"+equation.getRoot()+"')";

        //String qry = "INSERT INTO CONTACT(NAME,PHONENO)VALUES('XYZ','016')";
        //db.execSQL(query);

        ContentValues value=new ContentValues();
        value.put(KEY_NAME, equation.getName());
        value.put(KEY_ROOT,equation.getRoot());

        db.insert(TABLE_NAME, null,value);

        db.close();

    }

    public Equation getSingleEquation(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT ID,NAME,ROOT FROM EQUATION WHERE ID = "+id;
        Cursor cursor=db.rawQuery(query, null);
        //Cursor cursor = db.query(TABLE_NAME, new String[] {KEY_ID,KEY_NAME,KEY_ROOT}, "Id=?",new String[]{String.valueOf(id)} ,null, null,null, null);
        Equation myEquation = null;
        if(cursor.moveToFirst())
        {
            myEquation=new Equation(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));
        }

        return myEquation;
    }

    public List<Equation> getAllEquation()
    {
        List<Equation> myequationlist=new ArrayList<Equation>();

        String selectquery="SELECT * FROM "+ TABLE_NAME;// where phoneno LIKE '017%'";

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery(selectquery, null);

        if(cursor.moveToFirst())
        {
            do
            {
                Equation equation= new Equation(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));
                myequationlist.add(equation);
            }while(cursor.moveToNext());
        }

        return myequationlist;
    }

    public void updateEquation(Equation equ)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        String query = "UPDATE Equation SET name='"+equ.getName()+"',root='"+equ.getRoot()+"' WHERE ID = "+equ.getId();
        db.execSQL(query);



        db.close();
    }

    public void deleteContact(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String query = "DELETE From "+TABLE_NAME+" WHERE  ID="+id;
        db.execSQL(query);

        //db.delete(TABLE_NAME, KEY_ID+"=?", new String[]{String.valueOf(id)});
        db.close();
    }

}


