package com.aditya.Players;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		 Players playersManager = new Players();
	        Scanner scanner = new Scanner(System.in);
	        boolean running = true;

	        while (running) {
	            System.out.println("1) Add Player\n2) Display Players\n3) Search Player\n4) Sort Players by Runs\n5) Sort Players by Wickets\n6) Exit");
	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    playersManager.addPlayers();
	                    break;
	                case 2:
	                    playersManager.display();
	                    break;
	                case 3:
	                    playersManager.search();
	                    break;
	                case 4:
	                    playersManager.sortPlayersByRuns();
	                    System.out.println("Players sorted by runs.");
	                    playersManager.display();
	                    break;
	                case 5:
	                    playersManager.sortPlayersByWickets();
	                    System.out.println("Players sorted by wickets.");
	                    playersManager.display();
	                    break;
	                case 6:
	                    running = false;
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }

	}
