package org.example;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.Scanner;


public class ProjectManagement {

    static void add(Connection connection, Scanner sc) throws SQLException{
        Statement statement = connection.createStatement();
        System.out.println("Enter Product ID");
        int id= sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the product name");
        String name=sc.nextLine();
        System.out.println("Enter your price. Note Price must be greater than 0");
        double price= sc.nextDouble();
        System.out.println("Enter the Quantity. Note that Quantity can not be negative");
        int quantity=sc.nextInt();
        System.out.println("Enter your Category");
        sc.nextLine();
        String category=sc.nextLine();
        System.out.println("Enter the rating");
        double rating=sc.nextDouble();
        System.out.println("Enter the Manufaturer");
        sc.nextLine();
        String manufacturer=sc.nextLine();

        String query = "INSERT INTO products VALUES ("+ id + ", '"+ name + "', '"+ category + "', "+ price + ", "+ quantity + ", "+ rating + ", '"+ manufacturer + "', "+ "null"+ ")";
        try {
            int rowInserted = statement.executeUpdate(query);
            if(rowInserted>0){
                System.out.println(rowInserted+" row inserted");
            }else {
                System.out.println("Insert Failed");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    static void view(Connection connection, Scanner sc) throws SQLException {

        Statement statement = connection.createStatement();

        System.out.println("Product List is");

        ResultSet rs = statement.executeQuery("SELECT * FROM products");

        while (rs.next()) {
            int id = rs.getInt("product_id");
            String name = rs.getString("product_name");
            String category = rs.getString("category");
            int price = rs.getInt("price");
            int quantity = rs.getInt("quantity");
            String manu = rs.getString("manufacturer");
            int rating = rs.getInt("rating");

            System.out.println(id + " | " + name + " | "+ category + " | "+ price + " | "+ quantity + " | " + manu + " | "+ rating );
        }
    }

    static void delete(Connection connection, Scanner sc) throws SQLException {

       Statement statement = connection.createStatement();
        System.out.println("Enter the ID which you want to delete");
        int id = sc.nextInt();
        int rowsDeleted=statement.executeUpdate("delete from products where product_id=3");
        if (rowsDeleted>0){
            System.out.println(rowsDeleted+" row Deleted");
        }else {
            System.out.println("Delete  Failed");
        }

    }

    static void update(Connection connection, Scanner sc) throws SQLException {

        Statement statement = connection.createStatement();
        System.out.println("Enter the ID on which you want to update");
        int id = sc.nextInt();
        String query ="update products set quantity =200 where id ="+"id";
        int rowsUpdated=statement.executeUpdate(query);
        if (rowsUpdated>0){
            System.out.println(rowsUpdated+" row updated and Quantity is setted to 200");
        }else {
            System.out.println("Update Failed");
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
            while (true){
            System.out.println("================= Enter your choice =================");
            System.out.println("1 = add\n2 = update\n3 = view\n4 = delete\n5 = exit");
            int n= sc.nextInt();
            switch (n){
                case 1:
                    //add
                    add(connection,sc);
                    break;
                case 2:
                    //update
                    break;
                case 3:
                    //view
                    view(connection,sc);
                    break;
                case 4:
                    //delete
                    delete(connection,sc);
                    break;
                case 5:
                    //exit
                    break;
                default:
                    System.out.println("INVALID INPUT");
                    break;
            }
        }
    }
}
