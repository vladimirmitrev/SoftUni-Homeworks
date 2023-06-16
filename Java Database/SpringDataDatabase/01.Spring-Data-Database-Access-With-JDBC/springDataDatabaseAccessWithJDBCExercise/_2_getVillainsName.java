package springDataDatabaseAccessWithJDBCExercise;

import java.sql.*;
import java.util.Properties;

public class _2_getVillainsName {
    public static void main(String[] args) throws SQLException {

        Connection connection = getConnection();

        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT v.name, COUNT(DISTINCT mv.minion_id) AS minions_count " +
                        "FROM villains AS v " +
                        "JOIN minions_villains mv on v.id = mv.villain_id " +
                        "GROUP BY v.id " +
                        "HAVING minions_count > 15 " +
                        "ORDER BY minions_count DESC;");

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %d %n", resultSet.getString("name"),
                    resultSet.getInt(2));
        }

        connection.close();

    }

    private static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "12345");

        return DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", properties);
    }
}
