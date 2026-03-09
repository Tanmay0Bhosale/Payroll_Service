import java.sql.*;

public class EmployeePayrollService {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/payroll_service";
        String user = "root";
        String password = "root";

        try {

            Connection connection = DriverManager.getConnection(url, user, password);

            String query = """
            SELECT gender,
            SUM(salary) AS total,
            AVG(salary) AS average,
            MIN(salary) AS minimum,
            MAX(salary) AS maximum,
            COUNT(*) AS count
            FROM employee_payroll
            GROUP BY gender
            """;

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {

                System.out.println(
                        "Gender: " + rs.getString("gender") +
                        " SUM: " + rs.getDouble("total") +
                        " AVG: " + rs.getDouble("average") +
                        " MIN: " + rs.getDouble("minimum") +
                        " MAX: " + rs.getDouble("maximum") +
                        " COUNT: " + rs.getInt("count"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}