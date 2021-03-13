package com.company;

import java.util.Scanner;
public class Main {
    public Main() {
    }
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        ConnectDB obj1 = new ConnectDB();
        ForUser obj2 = new ForUser();
        User_reg obj3 = new User_reg();
        Login obj4 = new Login();
        String choose_option = "a";
        while(choose_option != "3") {
            obj2.menu_options();
            System.out.println("Please choose what to do: ");
            choose_option = myObj.nextLine();
            if (choose_option.equals("1") && !obj2.is_authenticated) {
                System.out.println("user_login:");
                String a = myObj.nextLine();
                obj3.setUsername(a);
                System.out.println("user_name:");
                String b = myObj.nextLine();
                obj3.setFName(b);
                System.out.println("user_surname:");
                String c = myObj.nextLine();
                obj3.setLName(c);
                System.out.println("user_password:");
                String d = myObj.nextLine();
                obj3.setPassword(d);
            } else if (choose_option.equals("1") && obj2.is_authenticated) {
                obj2.menu_options();
            } else if (choose_option.equals("2") && !obj2.is_authenticated) {
                obj4.login();
            } else if (choose_option.equals("2") && obj2.is_authenticated) {
                obj2.menu_options();
            } else {
                if (choose_option.equals("3")) {
                    break;
                }
                if (choose_option.equals("4") && !obj2.is_authenticated) {
                    obj1.get_connection();
                }
            }
        }
    }
}