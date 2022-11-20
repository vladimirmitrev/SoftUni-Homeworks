package DesignPatternsExercise.singleton.databaseExample;

public class DatabaseConnection {

    private static DatabaseConnection instance;

    public DatabaseConnection() {

        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConnection getInstance() {

        if(instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void readData() {
        System.out.println("Reading from DB");
    }

    public void writeData() {
        System.out.println("Writing to DB");
    }
}
