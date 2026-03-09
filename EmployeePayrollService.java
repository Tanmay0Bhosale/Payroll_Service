import java.sql.*;

public class EmployeePayrollService {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/payroll_service";
        String user = "root";
        String password = "root";

        try {

            Connection connection = DriverManager.getConnection(url, user, password);

            String query = "SELECT * FROM employee_payroll WHERE start_date BETWEEN ? AND ?";

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setDate(1, Date.valueOf("2020-01-01"));
            ps.setDate(2, Date.valueOf("2023-12-31"));

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " " +
                        rs.getString("name") + " " +
                        rs.getDouble("salary") + " " +
                        rs.getDate("start_date"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}