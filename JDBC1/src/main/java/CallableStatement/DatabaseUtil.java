package CallableStatement;
import java.io.*;
import java.util.*;
import java.sql.*;

public class DatabaseUtil {
    private static Properties properties= new Properties();
    static {
        try {
            FileInputStream fis= new FileInputStream("C:\\Users\\USER\\IdeaProjects\\JDBC1\\Temp.properties");
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static  Connection getConnection() throws Exception{
        return DriverManager.getConnection(
                properties.getProperty("Temp.url"),
                properties.getProperty("Temp.user"),
                properties.getProperty("Temp.password")
        );
    }
}
