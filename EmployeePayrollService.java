import java.sql.*;

public class EmployeePayrollService {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/payroll_service";
        String user = "root";
        String password = "root";

        try {

            Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();

            String query = "UPDATE employee_payroll SET salary = 3000000 WHERE name='Terisa'";

            int rows = statement.executeUpdate(query);

            System.out.println("Rows Updated: " + rows);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}