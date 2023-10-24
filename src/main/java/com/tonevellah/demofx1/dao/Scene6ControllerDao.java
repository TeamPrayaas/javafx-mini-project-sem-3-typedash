package com.tonevellah.demofx1.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Scene6ControllerDao {
    private final String INSERT_INTO_USERS_RECORD = "INSERT INTO users_record(username,wpm,accuracy,totword,wrongWords) VALUES(?,?,?,?,?)";
    PreparedStatement psInsert = null;

    private JdbcConnection jdbcConnection = new JdbcConnection();

    public void insertIntoUsersRecord(String username,int wpm, int totWord){
        try {
            psInsert = jdbcConnection.con().prepareStatement(INSERT_INTO_USERS_RECORD);

            psInsert.setString(1, username);
            psInsert.setInt(2, wpm);
            int accuracy = (int) Math.round((wpm * 1.0 / totWord) * 100);
            psInsert.setInt(3, accuracy);
            psInsert.setInt(4, totWord);
            psInsert.setInt(5,totWord-wpm); // wrong words
            psInsert.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
 }

}
}