package org.example.service;

import org.example.Main;
import org.example.model.League;
import org.example.model.Match;
import org.example.model.Team;
import org.example.repository.TeamRepo;

import java.util.ArrayList;

public class TeamService {
    private static Team chosenTeam = null;
    public static void createTeam(String teamname, League league) {
        Team team1 = new Team(teamname, league);
        TeamRepo.createTeam(team1);
    }
    public void addTeam(String teamname , League league){
        TeamService.createTeam(teamname ,league);
    }

    public  void deleteTeam(int id) {
        Team team = new Team(id);
        TeamRepo.deleteTeam(team);
    }

    public void updateTeam(int Id, int point) {
        Team team1 = new Team(Id,point+3);
        TeamRepo.updateTeam(team1,point);

}

    public void calculateWinner(int homeid, int hometeamgoals , int awayid ,int awayteamgoals ){

        if (hometeamgoals > awayteamgoals){
            updateTeam(homeid, 3);
        } else if (awayteamgoals > hometeamgoals) {
            updateTeam(awayid, +3);
        }else{
            System.out.println("It's a draw!");
        }
}
    }
