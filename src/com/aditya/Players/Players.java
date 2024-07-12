package com.aditya.Players;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Players {
    String PlayerName;
    int matchesPlayed;
    int runs;
    int wickets;
    int jerseyNumber;

    static int numberOfPlayers = 0;
    static ArrayList<Players> playerList = new ArrayList<>();

    public Players() {
        this.jerseyNumber = 0;
        this.matchesPlayed = 0;
        this.PlayerName = "Not Given";
        this.wickets = 0;
        this.runs = 0;
    }

    Scanner S1 = new Scanner(System.in);

    public Players(String playerName, int matchesPlayed, int runs, int wickets, int jerseyNumber) {
        super();
        PlayerName = playerName;
        this.matchesPlayed = matchesPlayed;
        this.runs = runs;
        this.wickets = wickets;
        this.jerseyNumber = jerseyNumber;
    }

    public String getPlayerName() {
        return PlayerName;
    }

    public void setPlayerName(String playerName) {
        PlayerName = playerName;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public void addPlayers() {
        if (numberOfPlayers == 100) {
            System.out.println("Max limit reached");
        } else {
            System.out.println("Enter the Name of the player:-");
            String name = S1.next();
            System.out.println("Enter the Jersey No. of the player:-");
            int jersey = S1.nextInt();
            System.out.println("Enter the No Of Matches Played By the player:-");
            int matches = S1.nextInt();
            System.out.println("Enter the No. of Wickets Taken By the player:-");
            int wickets = S1.nextInt();
            System.out.println("Enter the No. of Runs By the player:-");
            int runs = S1.nextInt();
            Players p1 = new Players(name, matches, runs, wickets, jersey);
            playerList.add(p1);
            numberOfPlayers++;
        }
    }

    public void display() {
        if (numberOfPlayers == 0) {
            System.out.println("No Data to show");
        } else {
            System.out.println("+-----------------+-------------------+-------------------+----------------+-------------------+");
            System.out.println("|   Player Name   |   Jersey Number   |   Total Matches   |   Total Runs   |   Total Wickets   |");
            System.out.println("+-----------------+-------------------+-------------------+----------------+-------------------+");
            for (Players p : playerList) {
                System.out.printf("|   %-14s | %14d | %17d | %14d | %17d |\n", p.getPlayerName(), p.getJerseyNumber(), p.getMatchesPlayed(), p.getRuns(), p.getWickets());
            }
        }
    }

    public void search() {
        int choice = 0;
        System.out.println("1) Search by Jersey Number\n2) Search player by the Name");
        choice = S1.nextInt();
        if (choice == 1) {
            System.out.println("Enter the Jersey Number of the Player");
            int jerseyNumber = S1.nextInt();
            boolean found = false;
            for (Players p : playerList) {
                if (p.getJerseyNumber() == jerseyNumber) {
                    System.out.println("Player found: " + p.getPlayerName());
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Player not found.");
            }
        } else if (choice == 2) {
            System.out.println("Enter the Name of the Player");
            String playerName = S1.next();
            boolean found = false;
            for (Players p : playerList) {
                if (p.getPlayerName().equalsIgnoreCase(playerName)) {
                    System.out.println("Player found: " + p.getPlayerName());
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Player not found.");
            }
        }
    }

    public void sortPlayersByRuns() {
        Collections.sort(playerList, Comparator.comparingInt(Players::getRuns).reversed());
    }

    public void sortPlayersByWickets() {
        Collections.sort(playerList, Comparator.comparingInt(Players::getWickets).reversed());
    }
}

       
