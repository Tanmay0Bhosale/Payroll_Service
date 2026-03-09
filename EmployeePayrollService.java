import java.sql.*;

public class EmployeePayrollService {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/payroll_service";
        String user = "root";
        String password = "root";

        try {

            Connection connection = DriverManager.getConnection(url, user, password);

            String query = "UPDATE employee_payroll SET salary = ? WHERE name = ?";

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setDouble(1, 3000000);
            ps.setString(2, "Terisa");

            int rows = ps.executeUpdate();

            System.out.println("Rows Updated: " + rows);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}