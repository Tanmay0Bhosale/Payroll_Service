import java.sql.*;

public class EmployeePayrollService {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/payroll_service";
        String user = "root";
        String password = "root";

        try {

            Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM employee_payroll");

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                Date startDate = rs.getDate("start_date");

                System.out.println(id + " " + name + " " + salary + " " + startDate);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}