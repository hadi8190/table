package org.example.repository;

import org.example.config.DatabaseConnection;
import org.example.model.League;
import org.example.model.Team;

import java.sql.*;


public class TeamRepo {

    private static final String INSERT_QUERY = "insert into team(teamname,point,league_id) values (?,?,?)";
    private static final String UPDATE_TEAM_QUERY = "update team set point = ? where id = ?";
    private static final String SELECT_QUERY = "select * from team inner join league l on l.id = team.league_id where team.id = ?";
    private static final String DELETE_QUERY = "DELETE FROM team WHERE id= ?";
    private static final String QUERY = "SELECT * FROM team ORDER BY point DESC";
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

    public static Team updateTeam(Team team, int points) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TEAM_QUERY);
            preparedStatement.setInt(1, points);
            preparedStatement.setInt(2, team.getId());


            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

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
            preparedStatement.setInt(1,team.getPoint());

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int point = resultSet.getInt("point");
                return new Team(point);
            }
            resultSet.close();
            connection.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static Team table(Team team) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY1);
            preparedStatement.setInt(1,team.getLeague().getId());

            preparedStatement.executeQuery();

        } catch (SQLException e) {
            System.out.println("An error occurred while retrieving data from the database: " + e.getMessage());
        }
        return null;
    }
}
