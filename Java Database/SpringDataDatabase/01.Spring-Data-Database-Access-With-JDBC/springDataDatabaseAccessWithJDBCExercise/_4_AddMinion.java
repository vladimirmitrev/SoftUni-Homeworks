package springDataDatabaseAccessWithJDBCExercise;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;


public class _4_AddMinion {
    public static void main(String[] args) throws SQLException {

        Connection connection = getConnection();

        Scanner scanner = new Scanner(System.in);

        String[] minionsInfo = scanner.nextLine().split(" ");
        String minionName = minionsInfo[1];
        int minionAge = Integer.parseInt(minionsInfo[2]);
        String townName = minionsInfo[3];

        String[] villainInfo = scanner.nextLine().split(" ");
        String villainName = villainInfo[1];

        int townId = getInsertTown(connection, townName);
        int villainId = getInsertVillain(connection, villainName);

        insertMinions(connection, minionName, minionAge, villainName, townId, villainId);

    }

    private static void insertMinions(Connection connection, String minionName, int minionAge, String villainName, int townId, int villainId) throws SQLException {
        PreparedStatement insertMinion = connection
                .prepareStatement("INSERT INTO minions (name, age, town_id) " +
                        "VALUES (?,?,?)");

        insertMinion.setString(1, minionName);
        insertMinion.setInt(2, minionAge);
        insertMinion.setInt(3, townId);
        insertMinion.executeUpdate();

        PreparedStatement selectLastMinionId = connection
                .prepareStatement("SELECT id FROM minions ORDER BY id DESC LIMIT 1");
        ResultSet lastMinionSet = selectLastMinionId.executeQuery();
        lastMinionSet.next();
        int lastMinionId = lastMinionSet.getInt("id");

        PreparedStatement insertMinionsVillains = connection
                .prepareStatement("INSERT INTO minions_villains (minion_id, villain_id) " +
                        "VALUES (?, ?)");
        insertMinionsVillains.setInt(1, lastMinionId);
        insertMinionsVillains.setInt(2, villainId);
        insertMinionsVillains.executeUpdate();

        System.out.printf("Successfully added %s to be minion of %s.%n", minionName, villainName);
    }

    private static int getInsertVillain(Connection connection, String villainName) throws SQLException {
        PreparedStatement selectVillain = connection
                .prepareStatement("SELECT id FROM villains WHERE name = ?");

        selectVillain.setString(1, villainName);

        ResultSet villainSet = selectVillain.executeQuery();

        int villainId = 0;

        if(!villainSet.next()) {
            PreparedStatement insertVillain = connection
                    .prepareStatement("INSERT INTO villains (name, evilness_factor) " +
                            "VALUES (?, 'evil')");
            insertVillain.setString(1, villainName);
            insertVillain.executeUpdate();

            ResultSet newVillainSet = selectVillain.executeQuery();
            newVillainSet.next();
            villainId = newVillainSet.getInt("id");

            System.out.printf("Villain %s was added to the database.%n", villainName);
        } else {
            villainId = villainSet.getInt("id");
        }

        return villainId;
    }

    private static int getInsertTown(Connection connection, String townName) throws SQLException {
        PreparedStatement selectTown = connection
                .prepareStatement("SELECT id FROM towns WHERE name = ?");
        selectTown.setString(1, townName);
        ResultSet townSet = selectTown.executeQuery();

        int townId = 0;

        if(!townSet.next()) {
            PreparedStatement insertTown = connection
                    .prepareStatement("INSERT INTO towns (name) VALUES (?);");
            insertTown.setString(1, townName);
            insertTown.executeUpdate();

            ResultSet newTownSet = selectTown.executeQuery();
            newTownSet.next();
            townId = newTownSet.getInt("id");

            System.out.printf("Town %s was added to the database.%n", townName);

        } else {
            townId = townSet.getInt("id");
        }

        return townId;
    }

    private static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "12345");

        return DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", properties);
    }


}
