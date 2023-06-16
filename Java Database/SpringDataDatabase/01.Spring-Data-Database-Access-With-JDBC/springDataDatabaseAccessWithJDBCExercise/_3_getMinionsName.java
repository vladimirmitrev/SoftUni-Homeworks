package springDataDatabaseAccessWithJDBCExercise;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;


public class _3_getMinionsName {

    public static void main(String[] args) throws SQLException {


        Scanner scanner = new Scanner(System.in);
        int villainId = Integer.parseInt(scanner.nextLine());

        Connection connection = getConnection();

        ResultSet villainSet = getVillainSet(villainId, connection);

        if (!villainSet.next()) {
            System.out.printf("No villain with ID %d exists in the database.", villainId);
            return;
        }

        ResultSet minionsSet = getMinionsSet(villainId, connection);

        System.out.printf("Villain: %s%n", villainSet.getString("v.name"));

        for (int i = 1; minionsSet.next(); i++) {
            System.out.printf("%d. %s %d%n",
                    i,
                    minionsSet.getString("m.name"),
                    minionsSet.getInt("m.age"));
        }

        connection.close();
    }

    private static ResultSet getMinionsSet(int villainId, Connection connection) throws SQLException {
        PreparedStatement minionsStatement = connection.prepareStatement("SELECT m.name, m.age " +
                "FROM minions AS m " +
                "JOIN minions_villains mv on m.id = mv.minion_id " +
                "WHERE mv.villain_id = ?;");

        minionsStatement.setInt(1, villainId);

        return minionsStatement.executeQuery();
    }

    private static ResultSet getVillainSet(int villainId, Connection connection) throws SQLException {
        PreparedStatement villainStatement = connection
                .prepareStatement("SELECT v.name FROM villains AS v WHERE id = ?");


        villainStatement.setInt(1, villainId);

        return villainStatement.executeQuery();
    }

    private static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "12345");

        return DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", properties);
    }
}