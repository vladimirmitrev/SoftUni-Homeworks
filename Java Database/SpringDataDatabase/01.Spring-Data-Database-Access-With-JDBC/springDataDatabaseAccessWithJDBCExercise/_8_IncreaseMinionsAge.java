package springDataDatabaseAccessWithJDBCExercise;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _8_IncreaseMinionsAge {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        String[] inputIDs = scanner.nextLine().split(" ");

        int firstId = Integer.parseInt(inputIDs[0]);
        int secondId = Integer.parseInt(inputIDs[1]);
        int thirdId = Integer.parseInt(inputIDs[2]);

        Connection connection = getConnection();

        updateMinionAgeAndName(firstId, connection);
        updateMinionAgeAndName(secondId, connection);
        updateMinionAgeAndName(thirdId, connection);

        printAllMinions(connection);

        connection.close();

    }

    private static void printAllMinions(Connection connection) throws SQLException {
        PreparedStatement selectAllMinions = connection
                .prepareStatement("SELECT name, age FROM minions");

        ResultSet resultSet = selectAllMinions.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %d%n",
                    resultSet.getString("name"),
                    resultSet.getInt("age"));
        }
    }

    private static void updateMinionAgeAndName(int firstId, Connection connection) throws SQLException {
        PreparedStatement updateStatement = connection
                .prepareStatement("UPDATE minions AS m " +
                        "SET m.age = m.age + 1, m.name = LOWER(m.name) " +
                        "WHERE m.id = ?;");

        updateStatement.setInt(1, firstId);
        updateStatement.executeUpdate();
    }

    private static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "12345");

        return DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", properties);
    }
}
