package dao;

import model.Product;
import util.DBConnection;

import java.sql.*;

public class ProductDAO {

    // Add Product
    public void addProduct(Product p) {

        String sql = "INSERT INTO products(product_id,product_name,category,price,quantity,rating) VALUES(?,?,?,?,?,?)";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1,p.getProductId());
            ps.setString(2,p.getProductName());
            ps.setString(3,p.getCategory());
            ps.setDouble(4,p.getPrice());
            ps.setInt(5,p.getQuantity());
            ps.setDouble(6,p.getRating());

            ps.executeUpdate();

            System.out.println("Product added successfully!");

        } catch(SQLException e) {
            System.out.println("Error: Product ID already exists.");
        }
    }


    // View All Products
    public void viewAllProducts(){

        String sql = "SELECT * FROM products";

        try(Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)){

            System.out.println("ID   Name   Category   Price   Qty   Rating");

            while(rs.next()){

                System.out.println(
                        rs.getInt("product_id")+"   "+
                                rs.getString("product_name")+"   "+
                                rs.getString("category")+"   "+
                                rs.getDouble("price")+"   "+
                                rs.getInt("quantity")+"   "+
                                rs.getDouble("rating")
                );
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    // View Product By ID
    public void viewProductById(int id){

        String sql="SELECT * FROM products WHERE product_id=?";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setInt(1,id);

            ResultSet rs=ps.executeQuery();

            if(rs.next()){

                System.out.println(
                        rs.getInt("product_id")+" "+
                                rs.getString("product_name")+" "+
                                rs.getString("category")+" "+
                                rs.getDouble("price")+" "+
                                rs.getInt("quantity")+" "+
                                rs.getDouble("rating")
                );

            }else{
                System.out.println("Product not found.");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    // Update Price
    public void updatePrice(int id,double price){

        String sql="UPDATE products SET price=? WHERE product_id=?";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setDouble(1,price);
            ps.setInt(2,id);

            int rows=ps.executeUpdate();

            if(rows>0)
                System.out.println("Price updated successfully.");
            else
                System.out.println("Product not found.");

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    // Update Quantity
    public void updateQuantity(int id,int quantity){

        String sql="UPDATE products SET quantity=? WHERE product_id=?";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setInt(1,quantity);
            ps.setInt(2,id);

            ps.executeUpdate();

            System.out.println("Quantity updated successfully.");

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    // Dele Product
    public void deleteProduct(int id){

        String sql="DELETE FROM products WHERE product_id=?";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setInt(1,id);

            int rows=ps.executeUpdate();

            if(rows>0)
                System.out.println("Product deleted.");
            else
                System.out.println("Product does not exist.");

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    // Search Product
    public void searchProduct(String keyword){

        String sql="SELECT * FROM products WHERE product_name LIKE ?";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setString(1,"%"+keyword+"%");

            ResultSet rs=ps.executeQuery();

            while(rs.next()){

                System.out.println(rs.getString("product_name"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    // Low Stock
    public void lowStockProducts(){

        String sql="SELECT * FROM products WHERE quantity < 5";

        try(Connection con=DBConnection.getConnection();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql)){

            System.out.println("Low Stock Products");

            while(rs.next()){

                System.out.println(
                        rs.getInt("product_id")+" "+
                                rs.getString("product_name")+" "+
                                rs.getInt("quantity")
                );
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}