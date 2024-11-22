package org.softuni.recursionandcombinatorialproblemsexercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P07CinemaFaster {
    public static String[] seats;
    public static List<String> freePeople;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Parse input: all friends
        freePeople = new ArrayList<>(Arrays.asList(reader.readLine().split(", ")));

        // Initialize seats with null (indicating unassigned seats)
        seats = new String[freePeople.size()];

        // Read fixed positions
        String line = reader.readLine();
        while (!line.equals("generate")) {
            String[] tokens = line.split(" - ");
            String name = tokens[0];
            int position = Integer.parseInt(tokens[1]) - 1;

            // Assign fixed seat and remove person from the free list
            seats[position] = name;
            freePeople.remove(name);

            line = reader.readLine();
        }

        // Generate permutations for remaining free people
        permute(0);
    }

    private static void permute(int index) {
        // Base case: if all free people are placed, print the arrangement
        if (index == freePeople.size()) {
            printSeats();
            return;
        }

        // Iterate over available seats
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == null) { // If the seat is free
                // Place the current person
                seats[i] = freePeople.get(index);

                // Recurse for the next person
                permute(index + 1);

                // Backtrack: remove the person from the seat
                seats[i] = null;
            }
        }
    }

    private static void printSeats() {
        System.out.println(String.join(" ", seats));
    }
}
