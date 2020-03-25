package com.company.Classes;

import com.company.Structs.Player;

import java.util.List;

public class myFunc {

    public static Object SearchInList(List<Object> tList, Object search) {
        for (Object v : tList) {
            if (v == search) return v;
        }
        return null;
    }

    private static List<Player> playersOrderAlphabetically(List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < players.size() - 1 - i; j++) {
                if (players.get(j).getPlayerName().compareTo(players.get(j + 1).getPlayerName()) > 0) {
                    Player player = players.get(j);
                    players.set(j, players.get(j + 1));
                    players.set(j + 1, player);
                }
            }
        }
        return players;
    }

    public static void printPlayerNamesByOrder(List<Player> players, Boolean isScoarBoard) {
        if (!isScoarBoard) {
            List<Player> p = playersOrderAlphabetically(players);
        } else {
            List<Player> p = playersOrderScoreboard(players);
        }
        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);
            System.out.println(p.getPlayerName()+" "+p.getScore()+" "+p.getWin()+" "+p.getDraw()+" "+p.getLose());
        }
    }

    private static List<Player> swichPlayers(List<Player> players, int index1, int index2) {
        Player player = players.get(index1);
        players.set(index1,players.get(index2));
        players.set(index2,player);
        return players;
    }

    private static List<Player> playersOrderScoreboard(List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < players.size() - 1 - i; j++) {
                Player p1 = players.get(j);
                Player p2 = players.get(j + 1);
                if (p1.getScore() < p2.getScore()) {
                    players = swichPlayers(players, j, j + 1);
                } else if (p1.getScore() == p2.getScore()) {
                    if (p1.getWin() < p2.getWin()) {
                        players = swichPlayers(players, j, j + 1);
                    } else if (p1.getWin() == p2.getWin()) {
                        if (p1.getDraw() < p2.getDraw()) {
                            players = swichPlayers(players, j, j + 1);
                        } else if (players.get(j).getPlayerName().compareTo(players.get(j + 1).getPlayerName()) > 0)
                            players = swichPlayers(players, j, j + 1);
                    }
                }

            }
        }
        return players;
    }
}
