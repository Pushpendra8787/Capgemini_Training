package com.capgi.dao;

import com.capgi.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.capgi.*;
import com.capgi.repository.playerRepo;

public class PlayerDAOImpl implements PlayerDAO{
    @Override
    public void insertPlayer(Player player) {
        String sql ="insert into players values(?,?,?)";
        try(Connection conn = playerRepo.getConnection();
            PreparedStatement pstmt =conn.prepareStatement(sql)) {
            pstmt.setInt(1,player.getPlayerId());
            pstmt.setString(2,player.getPlayerName());
            pstmt.setString(3,player.getPlayerCountry());
            pstmt.executeUpdate();
            System.out.println("Player inserted Successfully");

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    @Override
    public void updatePlayer(Player player) {
        String sql = "UPDATE players SET player_name = ?, player_country = ? WHERE player_id = ?";
        try (Connection conn = playerRepo.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, player.getPlayerName());
            pstmt.setString(2, player.getPlayerCountry());
            pstmt.setInt(3, player.getPlayerId());

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Player updated Successfully");
            } else {
                System.out.println("Player not found");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();
        }

    }

    @Override
    public void deletePlayer(int playerId) {
        String sql="delete from players where playerId =(?)";
        try (Connection conn = playerRepo.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, playerId);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Player Deleted Successfully");
            } else {
                System.out.println("Player not found");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();
        }


    }

    @Override
    public List<Player> getAllPlayers() {
        String sql="select* from players";
        try (Connection conn = playerRepo.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                int id=rs.getInt(1);
                String name =rs.getString(2);
                String country=rs.getString(3);
                System.out.println(id+" | "+name+" | "+country);
            }
            if (1>0) {
                System.out.println("Player Deleted Successfully");
            } else {
                System.out.println("Player not found");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();
        }


        return List.of();
    }
}
