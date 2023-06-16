package springDataDatabaseAccessWithJDBCExercise;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _6_RemoveVillain {
    public static void main(String[] args) throws SQLException {

        Connection connection = getConnection();

        Scanner scanner = new Scanner(System.in);

        int inputId = Integer.parseInt(scanner.nextLine());

        int releasedMinionsCount = getReleasedMinionsCount(connection, inputId);

        if(releasedMinionsCount == 0) {
            System.out.println("No such villain was found");
            return;
        }

        String villainName = getVillainName(connection, inputId);

        deleteVillain(connection, inputId);

        System.out.printf("%s was deleted%n", villainName);
        System.out.printf("%d minions released", releasedMinionsCount);

        connection.close();
    }

    private static void deleteVillain(Connection connection, int inputId) throws SQLException {
        PreparedStatement deleteVillain = connection
                .prepareStatement("DELETE FROM villains WHERE id = ?");

        deleteVillain.setInt(1, inputId);

        deleteVillain.executeUpdate();
    }

    private static String getVillainName(Connection connection, int inputId) throws SQLException {
        PreparedStatement deletedVillainName = connection
                .prepareStatement("SELECT name FROM villains WHERE id = ?");

        deletedVillainName.setInt(1, inputId);

        ResultSet villainName = deletedVillainName.executeQuery();
        villainName.next();
        return villainName.getString("name");
    }

    private static int getReleasedMinionsCount(Connection connection, int inputId) throws SQLException {
        PreparedStatement releaseMinions = connection
                .prepareStatement("DELETE " +
                        "FROM minions_villains " +
                        "WHERE villain_id = ?");

        releaseMinions.setInt(1, inputId);

        return releaseMinions.executeUpdate();
    }

    private static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "12345");

        return DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", properties);
    }
}
