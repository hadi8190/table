package org.example.service;

import org.example.Main;
import org.example.model.League;
import org.example.model.Match;
import org.example.model.Team;
import org.example.repository.TeamRepo;

import java.util.ArrayList;

public class TeamService {
    public int pointToAdd = 3;
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

    public void updateTeam(int point , int wins , int faild , int equal,int Id) {
//        Team team1 = new Team(Id);
       TeamRepo.updateTeam(point,wins,faild,equal,Id);

}

    public void calculateWinner(int homeid, int hometeamgoals , int awayid ,int awayteamgoals ){
        if (hometeamgoals > awayteamgoals){
            updateTeam(3,1,0,0,homeid);
        } else {
            updateTeam(0,0,1,0,homeid);
        } if (awayteamgoals > hometeamgoals) {
            updateTeam(3,1,0,0,awayid);
        } else {
            updateTeam(0,0,1,0,awayid);
        }if (hometeamgoals == awayteamgoals){
            updateTeam(1,0,0,1,awayid);
            updateTeam(1,0,0,1,homeid);
        }
    }
    }
