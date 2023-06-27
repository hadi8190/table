package org.example.model;

import java.util.ArrayList;

public class Team extends ArrayList<Team> {
    private int id;
    private String teamname;
    private int point;
    private League league;
    private int wins;
    private int faild;
    private int equal;

    public Team(){
    }

    public Team(int id, String teamname, int point, League league) {
        this.id = id;
        this.teamname = teamname;
        this.point = point;
        this.league = league;
    }

    public Team(String teamname,League league) {
        this.teamname = teamname;
        this.point = 0;
        this.wins = 0;
        this.faild = 0;
        this.equal = 0;
        this.league = league;
    }

    public Team(int id, int point, int wins, int faild, int equal) {
        this.id = id;
        this.point = point;
        this.wins = wins;
        this.faild = faild;
        this.equal = equal;
    }

    public Team(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getFaild() {
        return faild;
    }

    public void setFaild(int faild) {
        this.faild = faild;
    }

    public int getEqual() {
        return equal;
    }

    public void setEqual(int equal) {
        this.equal = equal;
    }
    public void winMatch(){
        point += 3;
        wins++;
    }

    @Override
    public String toString() {
        return "Team{" +
                ", teamname='" + teamname + '\'' +
                ", point=" + point +
                ", wins=" + wins +
                ", faild=" + faild +
                ", equal=" + equal +
                '}';
    }
}
