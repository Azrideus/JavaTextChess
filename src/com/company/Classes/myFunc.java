package com.company.Classes;

import com.company.Structs.Player;

import java.util.List;

public class myFunc {


    public static double Distance(int fx,int fy,int tx,int ty){
        return ((fx-tx)^2)+((fy-ty)^2);
    }
    public static Object SearchInList(List<Object> tList, Object search) {
        for (Object v:tList) {
            if(v==search)return v;
        }
        return null;
    }
    private static List<Player> playersOrderAlphabetically(List<Player> players){
        for (int i=0;i<players.size();i++){
            for(int j=0;j<players.size()-1-i;j++){
                if(players.get(j).getPlayerName().compareTo(players.get(j+1).getPlayerName())>0){
                    Player player = players.get(j);
                    players.set(j,players.get(j+1));
                    players.set(j+1,player);
                }
            }
        }
        return players;
    }
    public static void printPlayerNamesByAlphabeticallyOrder(List<Player> players){
        List<Player> p = playersOrderAlphabetically(players);
        for(int i=0;i<players.size();i++){
            System.out.println(players.get(i).getPlayerName());
        }
    }
}
