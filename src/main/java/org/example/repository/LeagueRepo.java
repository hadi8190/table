package org.example.repository;

import org.example.config.DatabaseConnection;
import org.example.model.League;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LeagueRepo {

    private static final String INSERT_QUERY = "insert into league(leagueName) values(?)";


    public static League createLeague(League league) {
        try {
            Connection connection = DatabaseConnection.getInstance();

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
//            preparedStatement.setString(1, newLeague);
//            preparedStatement.setInt(1,league.getLeagueId());
            preparedStatement.setString(1, league.getLeaguename());

            preparedStatement.execute();
            System.out.println("league created Successfully");

            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
