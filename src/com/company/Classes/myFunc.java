package com.company.Classes;

import com.company.Structs.Player;

import java.util.List;

public class myFunc {

    public static Object SearchInList(List<Object> tList, Object search) {
        for (Object v:tList) {
            if(v==search)return v;
        }
        return null;
    }
    public static List<Player> orderAlphabetically(List<Player> players){
        for (int i=0;i<players.size();i++){
            for(int j=0;j<players.size()-1;j++){
                if(players.get(j))
            }
        }
    }
}
