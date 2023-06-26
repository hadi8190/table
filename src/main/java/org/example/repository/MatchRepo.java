package org.example.repository;

import org.example.config.DatabaseConnection;
import org.example.model.Match;
import org.example.model.Team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MatchRepo {

    private static final String INSERT_QUERY = "insert into match(team_id , hometeamgoals , teamId , awayteamgoals) values (?,?,?,?)";
    private static final String SELECT_QUERY = "select * from team inner join match m on m.id = team.league_id where team.id = ?";




    public static Match createMatch(Match match) {
        try {
            Connection connection = DatabaseConnection.getInstance();

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setInt(1,match.getTeam().getId());
            preparedStatement.setInt(2, match.getHometeamgoals());
            preparedStatement.setInt(3,match.getTeam1().getId());
            preparedStatement.setInt(4, match.getAwayteamgoals());


            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }


    public static Match findMatch(int teamId) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
            preparedStatement.setInt(1, teamId);


            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int team_id = resultSet.getInt("team_id");
                int hometeamgoals = resultSet.getInt("hometeamgoals");
                int team1 = resultSet.getInt("teamId");
                int awayteamgoals = resultSet.getInt("awayteamgoals");
                Team team = new Team(team_id);
                Team team2 = new Team(team1);
                return new Match(id,team,hometeamgoals,awayteamgoals,team2);
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
}
