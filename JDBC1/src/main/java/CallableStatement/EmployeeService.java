package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class EmployeeService {
    public void InsertEmployee(String name, double salary) throws Exception {
        String sql="{CALL InsertEmployee(?, ?)}";
        try(Connection conn = DatabaseUtil.getConnection();
        CallableStatement stmt= conn.prepareCall(sql)) {
            stmt.setString(1,name);
            stmt.setDouble(2,salary);
            stmt.execute();
            System.out.println("Employee Inserted Successfully");
        } catch (Exception e) {
                e.printStackTrace();
        }
    }
    public void updateEmployee(int id, String name, double salary) {

        String sql = "{CALL UpdateEmployee(?, ?, ?)}";

        try (Connection conn = DatabaseUtil.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setDouble(3, salary);

            int rows = stmt.executeUpdate();

            if (rows > 0)
                System.out.println(" Employee Updated Successfully");
            else
                System.out.println("Employee Not Found");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
