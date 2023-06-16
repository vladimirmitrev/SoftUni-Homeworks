package springDataDatabaseAccessWithJDBCExercise;

import java.sql.*;
import java.util.ArrayDeque;
import java.util.Properties;

public class _7_PrintAllMinionNames {
    public static void main(String[] args) throws SQLException {

        Connection connection = getConnection();

        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT name FROM minions");

        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayDeque<String> minionsList = new ArrayDeque<>();

        while (resultSet.next()) {
           minionsList.add(resultSet.getString("name"));
        }

        int totalMinions = minionsList.size();

        for (int i = 0; i < totalMinions / 2 ; i++) {
            System.out.println(minionsList.pollFirst());
            System.out.println(minionsList.pollLast());
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
