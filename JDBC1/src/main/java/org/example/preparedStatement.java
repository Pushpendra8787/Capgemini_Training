package org.example;

import com.mysql.cj.jdbc.Driver;

import javax.sound.midi.Soundbank;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class preparedStatement
{
    public static void main(String[] args) throws SQLException , InputMismatchException {
        Scanner sc= new Scanner(System.in);
        Driver driver = new Driver();
        DriverManager.registerDriver(driver);
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test",
                "root",
                "Gopalji@2844");
        int id = 0,marks = 0;
        String name="";
        try{
        System.out.println("enter the ID");
         id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the name");
         name =sc.nextLine();
        System.out.println("enter marks");
        marks=sc.nextInt();}
        catch (InputMismatchException e1){
            System.out.println(e1.getMessage());
        }
        String query = "insert into students (id, name, marks) VALUES (?, ?, ?)";



           PreparedStatement ps = connection.prepareStatement(query);
        int rows = 0;
       try{
           ps.setInt(1, id);
           ps.setString(2, name);
           ps.setInt(3, marks);
           rows=ps.executeUpdate();
           if(rows>0){
               System.out.println("Row inserted");
           }
           else {
               System.out.println("Insertion Failed");
           }
       }
       catch (Exception e){
           System.out.println("I Think You enter the Duplicate ID ");
           System.out.println(e.getMessage());
       }
       ResultSet result = ps.executeQuery("Select * from students");
       while (result.next()){
           int i=result.getInt(1);
           int m=result.getInt(3);
           String n=result.getString(2);
           System.out.println(i+" | "+n+" | "+m);

       }
    }
}
