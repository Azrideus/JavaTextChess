package com.company.Structs;

import java.util.List;

public class ChessGame {
    ChessPiece[][] TheGamePieces;

    Player Player1;
    Player Player2;

    Player CurrentPlayer;
    int CurrentMoves=0;
    public ChessGame(Player p1,Player p2){
        this.Player1=p1;
        this.Player2=p2;
        this.CurrentMoves=0;
        TheGamePieces=new ChessPiece[9][9];
      //=========================================
    }

}
