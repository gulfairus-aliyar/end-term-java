package com.company;
import java.util.Scanner;
import java.sql.Statement;
public class User_reg{
    Scanner myObj = new Scanner(System.in);
    private String Username;
    private String FName;
    private String LName;
    private String password;
    public void setUsername(String Username) {
        this.Username=Username;
    }
    public String getUsername(){
        return Username;
    }
    public void setFName(String Fname) {
        this.FName=Fname;
    }
    public String getFName(){
        return FName;
    }
    public void setLName(String Lname) {
        this.LName=Lname;
    }
    public String getLName(){
        return LName;
    }
    public void setPassword(String password) {
        this.password=password;
    }
    public String getPassword(){
        return password;
    }
}