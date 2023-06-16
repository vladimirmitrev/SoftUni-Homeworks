package springDataDatabaseAccessWithJDBCExercise;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _9_IncreaseAgeStoredProcedure {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        int inputId = Integer.parseInt(scanner.nextLine());

        Connection connection = getConnection();

        updateMinionAge(inputId, connection);

        printMinion(inputId, connection);

        connection.close();

    }

    private static void updateMinionAge(int inputId, Connection connection) throws SQLException {
        CallableStatement updateAgeStatement = connection
                .prepareCall("CALL usp_get_older(?)");

        updateAgeStatement.setInt(1, inputId);

        updateAgeStatement.execute();
    }

    private static void printMinion(int inputId, Connection connection) throws SQLException {
        PreparedStatement selectMinionStatement = connection
                .prepareStatement("SELECT name, age " +
                        "FROM minions " +
                        "WHERE id = ?");
        selectMinionStatement.setInt(1, inputId);

        ResultSet resultSet = selectMinionStatement.executeQuery();
        resultSet.next();
        System.out.printf("%s %d%n", resultSet.getString("name"),
                resultSet.getInt("age"));
    }

    private static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "12345");

        return DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", properties);
    }
}
