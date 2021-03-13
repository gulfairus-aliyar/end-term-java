package com.company;
import java.sql.*;
import java.util.Scanner;
public class Login extends ForUser{
    Scanner myObj = new Scanner(System.in);
    User_reg obj2=new User_reg();
    ForUser obj1=new ForUser();
    String user_login;
    String user_password;
    public void login() {
        System.out.println("username:");
        user_login=myObj.nextLine();
        System.out.println("password:");
        user_password=myObj.nextLine();
        Connection connection = null;
        String host = "localhost";
        String port = "5432";
        String db_name = "postgres";
        String db_username = "postgres";
        String db_password = "t110e3t110e4";
        try {
            Class.forName("org.postgresql.Driver");
            // Establish the connection
            //connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "0000");
            connection = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + db_name, db_username, db_password);
            if (connection != null) {
                System.out.println("Database opened successfully \n");
            } else {
                System.out.println("Database failed to open \n");
            }
            String sql1 = "SELECT user_password FROM users where user_login="+obj2.getUsername()+"";
            Statement statement1 = connection.createStatement();
            ResultSet result = statement1.executeQuery(sql1);
            while (result.next()) {
                String username = result.getString(2);
                System.out.println(username);
            }
        } catch (Exception e) {
            System.out.println(e);
            obj1.setIs_authenticated(true);
            obj1.setCurrent_user(user_login);
        }
        System.out.println("Your login or password is wrong!");
        login();
    }
}