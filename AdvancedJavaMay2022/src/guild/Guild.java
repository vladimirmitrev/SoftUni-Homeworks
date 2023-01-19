package guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if(capacity > roster.size()) {
            roster.add(player);
        }
    }
    public boolean removePlayer(String name) {
        return roster.removeIf(player -> player.getName().equals(name));
    }
    public void promotePlayer(String name) {
        roster.stream().filter(player -> player.getName().equals(name)).findFirst()
                .ifPresent(player -> player.setRank("Member"));
    }
    public void demotePlayer(String name) {
        roster.stream().filter(player -> player.getName().equals(name)).findFirst()
                .ifPresent(player -> player.setRank("Trial"));
    }
    public Player[] kickPlayersByClass(String clazz) {
        Player[] result = roster.stream().filter(player -> player.getClazz().equals(clazz)).toArray(Player[]::new);

        setRoster(roster.stream().filter(player -> !player.getClazz().equals(clazz)).collect(Collectors.toList()));

        return result;
    }
    public int count() {
        return roster.size();
    }
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Players in the guild: %s:%n", name));
        roster.forEach(player -> sb.append(player).append(System.lineSeparator()));

        return sb.toString().trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Player> getRoster() {
        return roster;
    }

    public void setRoster(List<Player> roster) {
        this.roster = roster;
    }
}
