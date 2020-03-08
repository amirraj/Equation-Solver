package com.example.efficient.equation_solver;


public class Equation {
    int _id;
    String _name;
    String root;

    public Equation()
    {

    }
    public Equation(int Id, String Name , String Root)
    {

        this._id=Id;
        this._name=Name;
        this.root=Root;

    }

    public Equation(String Name, String Root)
    {
        this._name=Name;
        this.root=Root;

    }

    public int getId()
    {
        return this._id;
    }
    public void setId(int Id)
    {
        this._id=Id;
    }

    public String getName()
    {
        return this._name;
    }
    public void setName(String Name)
    {
        this._name=Name;
    }

    public String getRoot()
    {
        return this.root;
    }
    public void setContactNumber(String Root)
    {
        this.root=Root;
    }



}


