package com.capgi;

import com.capgi.dao.PlayerDAO;
import com.capgi.dao.PlayerDAOImpl;
import com.capgi.entity.Player;

public class Application {
    public static void main(String[] args) {
        PlayerDAO dao= new PlayerDAOImpl();
//        dao.insertPlayer(new Player(2,"Harshit","INDIA"));
//        dao.insertPlayer(new Player(3,"Alice","USA"));
//        dao.deletePlayer(1);
        dao.getAllPlayers();
    }
}

