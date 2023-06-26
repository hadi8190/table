package org.example.model;

import java.util.ArrayList;

public class Team extends ArrayList<Team> {
    private int id;
    private String teamname;
    private int point;
    private League league;

    public Team(int id, String teamname, int point, League league) {
        this.id = id;
        this.teamname = teamname;
        this.point = point;
        this.league = league;
    }

    public Team(String teamname,League league) {
        this.teamname = teamname;
        this.point = 0;
        this.league = league;
    }

    public Team(int id,int point) {
        this.id = id;
        this.point = point;
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

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", teamname='" + teamname + '\'' +
                ", point=" + point +
                ", league=" + league +
                '}';
    }
}
