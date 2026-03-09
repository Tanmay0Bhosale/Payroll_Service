import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Enumeration;

public class EmployeePayrollService {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/payroll_service";
        String user = "root";
        String password = "root";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");

            Enumeration<java.sql.Driver> drivers = DriverManager.getDrivers();

            while (drivers.hasMoreElements()) {
                System.out.println("Registered Driver: " + drivers.nextElement());
            }

            Connection connection = DriverManager.getConnection(url, user, password);

            System.out.println("Connection Established");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}