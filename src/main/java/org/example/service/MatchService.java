package org.example.service;

import org.example.Main;
import org.example.model.Match;
import org.example.model.Team;
import org.example.repository.MatchRepo;
import org.example.repository.TeamRepo;

public class MatchService {
    private Match loggedInUser = null;


    public Match getLoggedInUser() {
        return loggedInUser;
    }

    public static void createMatch(Team team , int hometeamgoals, Team team_id ,int awayteamgoals) {

        Match match = new Match(team , hometeamgoals ,team_id , awayteamgoals);
        MatchRepo.createMatch(match);
    }
    public void addMatch(Team team , int hometeamgoals,Team teamId , int awayteamgoals){
        MatchService.createMatch(team , hometeamgoals,teamId , awayteamgoals);
    }


}
