package org.example.model;

public class League {
    private int id;
    private String leaguename;

    public League(int id, String leaguename) {
        this.id = id;
        this.leaguename = leaguename;
    }

    public League(String leaguename) {
        this.leaguename = leaguename;
    }

    public League(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLeaguename() {
        return leaguename;
    }

    public void setLeaguename(String leaguename) {
        this.leaguename = leaguename;
    }
}
