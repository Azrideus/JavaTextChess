package com.company.Structs;

import com.company.Classes.Constant;

import java.util.List;

public class ChessGame {
    ChessPiece[][] TheGamePieces;
    List<Player> AllPlayers;
    Player CurrentPlayer;
    int CurrentMoves=0;
    public ChessGame(List<Player> AllPlayers){
        this.AllPlayers=AllPlayers;
        this.CurrentMoves=0;
        TheGamePieces=new ChessPiece[9][9];
    }
    private static void startTheGame(String p1,String p2,int limit){
        if(!p1.matches(Constant.regexAcceptableCharacters)){
            System.out.println(Constant.errInvalidUsername);
            return;
        }
        else if(limit<0){
            System.out.println(Constant.errInvalidLimit);
            return;
        }
        else if(p1.equals(p2)) {
            System.out.println(Constant.errChooseAnotherPlayer);
            return;
        }
        else if(Player.getPlayerByName(p2)==null) {
            System.out.println(Constant.errNotExistPlayer);
            return;
        }
        
    }

}
