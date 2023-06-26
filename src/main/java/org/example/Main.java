package org.example;

import org.example.model.League;
import org.example.model.Team;
import org.example.service.LeagueService;
import org.example.service.MatchService;
import org.example.service.MenuService;
import org.example.service.TeamService;
import java.util.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MatchService match = new MatchService();
        TeamService team = new TeamService();
        LeagueService league = new LeagueService();
        MenuService.printMainMenu();


        boolean quit = false;
        boolean quit2 = false;
        boolean quit3 = false;
        boolean quit4 = false;


        while (!quit) {

            System.out.println("Please Enter your choice(0 for Main Menu): ");
            int choice = scanner.nextByte();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    MenuService.printMainMenu();
                    break;
                case 1:
                    System.out.print("Please Enter leagueName: ");
                    String nameLeague = scanner.nextLine();
                    league.addLeague(nameLeague);
                    break;
                case 2:
                    System.out.println("please enter teamName: ");
                    String teamName = scanner.nextLine();
//                    System.out.println("enter team's point: ");
//                    int point = scanner.nextInt();
                    System.out.println("enter league_id: ");
                    int leagueId = scanner.nextInt();
                    League league1 = new League(leagueId);
                    team.addTeam(teamName, league1);

                    while (!quit2) {
                        System.out.println("Please Enter the Number of your choice (0 for User Menu): ");
                        int choice2 = scanner.nextByte();
                        scanner.nextLine();
                        switch (choice2) {
                            case 0:
                                MenuService.printTeamMenu();
                                break;
                            case 1:
                                System.out.println("Enter team id: ");
                                int id = scanner.nextInt();
                                team.deleteTeam(id);
                                break;
                        }}
                case 3 :
                    while (!quit3) {
                        System.out.println("Please Enter the Number of your choice(0 for menu): ");
                        int choice3 = scanner.nextByte();
                        scanner.nextLine();
                        switch (choice3) {
                            case 0:
                                MenuService.printMatchMenu();
                                break;
                            case 1:
                                quit3 = true;
                                break;
                            case 2:
                                System.out.print("Please Enter team ID: ");
                                int teamId = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Please Enter home team goals: ");
                                int hometeamgoals = scanner.nextInt();
                                System.out.println("Please enter team id: ");
                                int teamiD = scanner.nextInt();
                                System.out.println("Please enter away team goals: ");
                                int awayteamgoals = scanner.nextInt();
                                Team team1 = new Team(teamId);
                                Team team2 = new Team(teamiD);
                                match.addMatch(team1, hometeamgoals, team2, awayteamgoals);
                                team.calculateWinner(teamId, hometeamgoals, teamiD, awayteamgoals);
                                System.out.println("Match done");
                        }
                                    }
                case 4:
                    while (!quit4) {
                        System.out.println("Please Enter the Number of your choice(0 for menu): ");
                        int choice3 = scanner.nextByte();
                        scanner.nextLine();
                        switch (choice3) {
                            case 0:
                                MenuService.printTableMenu();
                                break;
                            case 1:
                                quit3 = true;
                                break;
                            case 2:
                                System.out.println("Enter league id: ");
                                int leagueID = scanner.nextInt();
//                                Team team1 = new Team(leagueID);
                                LeagueService.showtable(leagueID);

                                }
                        }
                    }
            }}}