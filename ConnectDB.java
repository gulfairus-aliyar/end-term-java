package com.company;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class ConnectDB {
    User_reg obj1=new User_reg();
    public Connection get_connection() {
        Connection connection = null;
        String host = "localhost";
        String port = "5432";
        String db_name = "postgres";
        String db_username = "postgres";
        String db_password = "t110e3t110e4";
        String user_login=obj1.getUsername();
        String user_name=obj1.getFName();
        String user_surname=obj1.getLName();
        String user_password=obj1.getPassword();
        try {
            Class.forName("org.postgresql.Driver");
            // Establish the connection
            //connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "0000");
            connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db_name, db_username, db_password);
            if(connection!=null) {
                System.out.println("Database opened successfully \n");
            } else {
                System.out.println("Database failed to open \n");
            }
            String sql = "INSERT INTO users(user_login, user_name, user_surname, user_password)" + "VALUES(?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user_login);
            statement.setString(2, user_name);
            statement.setString(3, user_surname);
            statement.setString(4, user_password);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
            String sql1 = "SELECT * FROM products";
            Statement statement1 = connection.createStatement();
            ResultSet result = statement1.executeQuery(sql1);
            while (result.next()) {
                String username4 = result.getString(1);
                String username = result.getString(2);
                String username1 = result.getString(3);
                String username2 = result.getString(4);
                String username3 = result.getString(5);
                System.out.println("Id:"+username4+"  Name:" + username + " Product description:" + username1 + " Category:" + username2 + " Price" + username3);
            }
        }catch(Exception e) {
            System.out.println(e);
        }
        return connection;
    }
}