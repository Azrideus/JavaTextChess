package com.company.Structs;

import com.company.Classes.Constant;

import java.util.List;

public class ChessGame {
    ChessPiece[][] theGamePieces;

    Player player1;
    Player player2;

    Player currentPlayer;
    int limit;
    int currentMoves=0;
    public ChessGame(Player p1,Player p2,int limit){
        this.player1=p1;
        this.player2=p2;
        this.currentMoves=0;
        this.limit=limit;
        theGamePieces=new ChessPiece[9][9];
        //=========================================

        if(p1.getPlayerColor()==p2.getPlayerColor()){
            //Wrong player colors :
            p1.setPlayerColor(Constant.PlayerColor.White);
            p2.setPlayerColor(Constant.PlayerColor.Black);
            //colors fixed.
        }

        for (ChessPiece p:
        ChessPiece.CreatePieces(p1)) {
            theGamePieces[p.OriginalX][p.OriginalY]=p;
        }
        for (ChessPiece p:
                ChessPiece.CreatePieces(p2)) {
            theGamePieces[p.OriginalX][p.OriginalY]=p;
        }
        //=========================================

        PrintBoard(true);
    }
    public void PrintBoard(boolean fancy){
        boolean IsFirst=true;
        for (int i = 1; i < theGamePieces.length; i++) {

            IsFirst=true;
            for (int j = 1; j < theGamePieces[i].length; j++) {
                ChessPiece p=theGamePieces[i][j];

                if(IsFirst)IsFirst=false;
                else System.out.print("|");

                if (fancy){
                    if(p==null) System.out.print(" ");
                    else System.out.print(p.mapIcon);
                }else{
                    if(p==null) System.out.print("  ");
                    else System.out.print(p.mapChar);
                }

            }
            System.out.print("\n");
        }
    }


}
