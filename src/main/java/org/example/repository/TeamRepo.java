package org.example.repository;

import org.example.config.DatabaseConnection;
import org.example.model.League;
import org.example.model.Team;

import java.sql.*;
import java.util.ArrayList;


public class TeamRepo {

    private static final String INSERT_QUERY = "insert into team(teamname,point,league_id) values (?,?,?)";
    private static final String UPDATE_TEAM_QUERY = "update team set (point,wins,faild,equal) = (point + ? , wins + ? , faild + ? , equal + ?) where id = ?";
    private static final String UPDATE_QUERY = "UPDATE team SET (point) = point + ? WHERE id = ?";
    private static final String SELECT_QUERY = "select * from team inner join league l on l.id = team.league_id where team.id = ?";
    private static final String DELETE_QUERY = "DELETE FROM team WHERE id= ?";
    private static final String QUERY = "SELECT * FROM team where league_id = ? ORDER BY point DESC ";
    private static final String QUERY1 = "SELECT * FROM team where league_id = ?";


    public static void createTeam(Team team) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
//            preparedStatement.setInt(1, team.getTeamId());
            preparedStatement.setString(1, team.getTeamname());
            preparedStatement.setInt(2, team.getPoint());
            preparedStatement.setInt(3, team.getLeague().getId());


            preparedStatement.execute();
            System.out.println("Your team created Successfully");

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static Team updateTeam(int points, int wins, int faild, int equal, int id) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TEAM_QUERY);
            preparedStatement.setInt(1, points);
            preparedStatement.setInt(2, wins);
            preparedStatement.setInt(3, faild);
            preparedStatement.setInt(4, equal);
            preparedStatement.setInt(5, id);


            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

//    public static Team teamPoint(int point, int Id) {
//        try (Connection connection = DatabaseConnection.getInstance(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {
//            preparedStatement.setInt(1, point);
//            preparedStatement.setInt(2, Id);
//
//            preparedStatement.executeUpdate();
//            preparedStatement.close();
//            connection.close();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return null;
//    }

    public static Team findTeam(int id) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
            preparedStatement.setInt(1, id);


            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int Id = resultSet.getInt("id");
                String teamname = resultSet.getString("teamname");
                int point = resultSet.getInt("point");
                int league_id = resultSet.getInt("league_id");
                League league = new League(league_id);
                return new Team(id, teamname, point, league);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (
                SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void deleteTeam(Team team) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY);
            preparedStatement.setInt(1, team.getId());

            preparedStatement.execute();

            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static Team sortedTeam(Team team) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
//            preparedStatement.setInt(1,team.getPoint());

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int point = resultSet.getInt("point");
                return new Team(point);
            }
            resultSet.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static ArrayList<Team> table(int leagueId) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, leagueId);
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Team> teams = new ArrayList<>();
            League league = new League(leagueId);
            while (resultSet.next()) {
                Team team = new Team();
                team.setId(resultSet.getInt("id"));
                team.setLeague(league);
                team.setPoint(resultSet.getInt("point"));
                team.setTeamname(resultSet.getString("teamname"));
                team.setWins(resultSet.getInt("wins"));
                team.setFaild(resultSet.getInt("faild"));
                team.setEqual(resultSet.getInt("equal"));

                teams.add(team);
            }
            resultSet.close();
            connection.close();
            return teams;
//            preparedStatement.executeQuery();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
