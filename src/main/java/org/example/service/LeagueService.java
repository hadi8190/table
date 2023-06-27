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
    public static void showTable(int leagueId ){

        ArrayList<Team> teams = TeamRepo.table(leagueId);

        for (int i = 0; i <teams.size() ; i++) {
            System.out.println(teams.get(i));
        }
}}
