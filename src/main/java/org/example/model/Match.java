package org.example.model;

public class Match {
    private int id;
    private Team team;
    private int hometeamgoals;
    private Team team1;
    private int awayteamgoals;

    public Match(int id, Team team, int hometeamgoals, int awayteamgoals, Team team1) {
        this.id = id;
        this.team = team;
        this.hometeamgoals = hometeamgoals;
        this.awayteamgoals = awayteamgoals;
        this.team1 = team1;
    }

    public Match(Team team, int hometeamgoals, Team team1, int awayteamgoals) {
        this.team = team;
        this.hometeamgoals = hometeamgoals;
        this.team1 = team1;
        this.awayteamgoals = awayteamgoals;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getHometeamgoals() {
        return hometeamgoals;
    }

    public void setHometeamgoals(int hometeamgoals) {
        this.hometeamgoals = hometeamgoals;
    }

    public int getAwayteamgoals() {
        return awayteamgoals;
    }

    public void setAwayteamgoals(int awayteamgoals) {
        this.awayteamgoals = awayteamgoals;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }
}
