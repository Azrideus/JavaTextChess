package com.company.Structs;

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

}
