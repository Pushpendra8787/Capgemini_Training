package org.example;
import java.sql.*;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;
public class PlayerService {
    static void add(Connection connection,Scanner sc) throws SQLException {
        System.out.println("enter your details ID, Name , marks in same order");
        int id= sc.nextInt();
        sc.nextLine();
        String name=sc.nextLine();
        int marks= sc.nextInt();

        Statement statement = connection.createStatement();
        String Query="Insert into students values ("+id+","+"'"+name+"'"+","+marks+")";
        try {
            int rowInserted = statement.executeUpdate(Query);
            if(rowInserted>0){
                System.out.println(rowInserted+" row inserted");
            }else {
                System.out.println("Insert Failed");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
    public static void main(String[] args) throws SQLException {
        Scanner sc= new Scanner(System.in);
        Driver driver = new Driver();
        DriverManager.registerDriver(driver);
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test",
                "root",
                "Gopalji@2844");
        Statement statement = connection.createStatement();
// ==========================INSERT=====================================
//        add(connection,sc);
//        try {
//            int rowInserted = statement.executeUpdate("Insert into students values (1,'Pushpendra',9)");
//            if(rowInserted>0){
//                System.out.println(rowInserted+" row inserted");
//            }else {
//                System.out.println("Insert Failed");
//            }
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }

// ============================== Updating data=============================
//        int rowsUpdated=statement.executeUpdate("update students set marks =-1 where id =3");
//        if (rowsUpdated>0){
//            System.out.println(rowsUpdated+" row updated");
//        }else {
//            System.out.println("Update Failed");
//        }
// ============================== Deleting data=============================
        int rowsDeleted=statement.executeUpdate("delete from students where id=3");
        if (rowsDeleted>0){
            System.out.println(rowsDeleted+" row Deleted");
        }else {
            System.out.println("Delete  Failed");
        }
// ============================== Printing data=============================
        ResultSet rs= statement.executeQuery("Select * from students");
        while(rs.next()){
            int id=rs.getInt("id");
            String  name=rs.getString("name");
            int mark=rs.getInt("marks");
            System.out.println(id+" | "+name+" | "+ mark);
        }
        while (true){
            System.out.println("================= Enter your choice =================");
            int n= sc.nextInt();
            switch (n){
                case 1:
                    //add
                    break;
                case 2:
                    //update
                    break;
                case 3:
                    //view
                    break;
                case 4:
                    //delete
                    break;
                case 5:
                    //exit
                    break;
                default:
                    System.out.println("INVALID INPUT");
                    break;
            }
            connection.close();
        }
    }
}
