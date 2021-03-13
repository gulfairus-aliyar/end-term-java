package com.company;

public class ForUser{
    public boolean is_authenticated;
    private String current_user;
    public ForUser(){
        is_authenticated=false;
        current_user="guest";
    }
    public ForUser(boolean is_authenticated, String current_user){
        this.is_authenticated=is_authenticated;
        this.current_user=current_user;
    }
    public String getCurrent_user() {
        return current_user;
    }
    public void setCurrent_user(String color) {
        this.current_user = current_user;
    }
    public void setIs_authenticated(boolean is_authenticated) {
        this.is_authenticated = is_authenticated;
    }
    public boolean isIs_authenticated() {
        return is_authenticated;
    }
    public void menu_options() {
        if (!is_authenticated) {
            System.out.println("Welcome to Product Management System "+current_user+"!");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.println("4. See products");
        }
        else {
            System.out.println("Welcome to Product Management System "+current_user+"!");
            System.out.println("1. See products");
            System.out.println("2. Put products into cart");
            System.out.println("3. Exit");
            System.out.println("4. My cart");
        }
    }
}