package springDataDatabaseAccessWithJDBCExercise;

import java.sql.*;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

public class _8_IncreaseMinionsAge {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);


        int[] inputIds = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Connection connection = getConnection();

        updateMinionsWithGivenId(inputIds, connection);

        printAllMinions(connection);

        connection.close();

    }

    private static void updateMinionsWithGivenId(int[] inputIds, Connection connection) throws SQLException {
        PreparedStatement updateStatement =
                connection.prepareStatement("UPDATE minions AS m " +
                        "SET m.age = m.age + 1, m.name = LOWER(m.name)\n" +
                        "WHERE m.id = ?;");

        for (int id : inputIds) {
            updateStatement.setInt(1, id);
            updateStatement.executeUpdate();
        }
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

    private static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "12345");

        return DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", properties);
    }
}
