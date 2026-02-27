package CallableStatement;

public class MainApp {
    public static void main(String[] args) throws Exception {
        EmployeeService service= new EmployeeService();
        service.InsertEmployee("veer",123.23);

    }
}
