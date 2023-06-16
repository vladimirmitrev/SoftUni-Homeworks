package springDataDatabaseAccessWithJDBCExercise;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class _5_ChangeTownNamesCasing {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        String inputCountry = scanner.nextLine();

        Connection connection = getConnection();

        int affectedTowns = getAffectedTowns(inputCountry, connection);

        if (affectedTowns == 0) {
            System.out.println("No town names were affected.");
            return;
        }

        List<String> townsList = getTownsList(inputCountry, connection);

        System.out.printf("%d town names were affected.%n", affectedTowns);
        System.out.print(townsList);

        connection.close();
    }

    private static List<String> getTownsList(String inputCountry, Connection connection) throws SQLException {
        PreparedStatement selectTowns = connection
                .prepareStatement("SELECT t.name FROM towns AS t WHERE t.country = ?");

        selectTowns.setString(1, inputCountry);

        ResultSet townsResultSet = selectTowns.executeQuery();

        List<String> townsList = new ArrayList<>();

        for (int i = 1; townsResultSet.next(); i++) {
            String townName = townsResultSet.getString("t.name");
            townsList.add(townName);
        }
        return townsList;
    }

    private static int getAffectedTowns(String inputCountry, Connection connection) throws SQLException {
        PreparedStatement updateTownNames = connection
                .prepareStatement("UPDATE towns " +
                        "SET name = UPPER(name) " +
                        "WHERE country = ?");

        updateTownNames.setString(1, inputCountry);

        return updateTownNames.executeUpdate();
    }

    private static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "12345");

        return DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", properties);
    }
}
