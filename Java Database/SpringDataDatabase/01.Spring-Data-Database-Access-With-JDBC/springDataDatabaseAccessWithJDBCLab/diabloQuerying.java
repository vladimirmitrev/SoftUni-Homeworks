package springDataDatabaseAccessWithJDBC;

import java.sql.*;
import java.util.Scanner;

public class diabloQuerying {
    private static final String SELECT_USER_GAMES_COUNT_BY_USERNAME =
            "SELECT u.first_name," +
                    " u.last_name, " +
                    "COUNT(ug.game_id) AS 'count' " +
                    "FROM users AS u " +
                    "         JOIN users_games ug on u.id = ug.user_id " +
                    "WHERE u.user_name = ? " +
                    "GROUP BY u.first_name, u.last_name";

    public static void main(String[] args) throws SQLException {

        Connection connection = getMySQLConnection();

        String username = readUsername();

        PreparedStatement statement = connection.prepareStatement(SELECT_USER_GAMES_COUNT_BY_USERNAME);

        statement.setString(1, username);

        ResultSet result = statement.executeQuery();

        boolean hasRow = result.next();

        if (hasRow) {
            System.out.println("User: " + username);
            System.out.printf(
                    "%s %S has played %d games",
                    result.getString("first_name"),
                    result.getString("last_name"),
                    result.getInt(3)
            );
        } else {
            System.out.println("No such user exist");
        }


    }

    private static Connection getMySQLConnection() throws SQLException {
        Connection connection =
                DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/diablo",
                        "root",
                        "12345");
        return connection;
    }

    private static String readUsername() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");

        String username = scanner.nextLine();

        return username;
    }
}