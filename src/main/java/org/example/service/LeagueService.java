package org.example.service;

import org.example.model.League;
import org.example.model.Team;
import org.example.repository.LeagueRepo;
import org.example.repository.TeamRepo;

import java.util.ArrayList;

public class LeagueService {
    private static League team = null;
    public static void createLeague(String leaguename) {
        League league = new League(leaguename);
        LeagueRepo.createLeague(league);
    }
    public void addLeague(String leagueName){
        LeagueService.createLeague(leagueName);
    }
    public static void showTable(Team team){
        ArrayList<Team> teams = TeamRepo.table(team);
        for (int i = 1; i <=teams.size(); i++) {
            TeamRepo.sortedTeam(team);
        }
    }
    public static void showtable(int leagueid){
        Team team1 = new Team(leagueid);
        showTable(team1);
    }
////    if (team != null){
//        int teamId = team.getId();
//        Team team1 = new Team(teamId);
//        LeagueService.showTable(team1);
//
//    }
}
