package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); // load Driver

            // established connection
            Connection connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/StudentsDB","root", "Uttpal@chandu9199204438");

            //Create statement
            Statement statement = connection.createStatement();

            //Execute sql queery
            String querry = "Select * From Students";
            ResultSet resultSet = statement.executeQuery(querry);

            // proccess the querry
            while (resultSet.next()){
                int id =resultSet.getInt("id");
                String name =resultSet.getString("name");
                String course =resultSet.getString("course");
                System.out.println("id = " + id + " Name = " + name + "course = " + course);
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

