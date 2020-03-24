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
<<<<<<< Updated upstream
    public ChessGame(Player p1,Player p2,int limit){
        this.player1=p1;
        this.player2=p2;
        this.currentMoves=0;
        this.limit=limit;
        theGamePieces=new ChessPiece[9][9];
        GameMoves=new ArrayList<ChessMove>();
=======
    public ChessGame(Player p1,Player p2,int limit) {
        this.player1 = p1;
        this.player2 = p2;
        this.currentMoves = 0;
        this.limit = limit;
        theGamePieces = new ChessPiece[9][9];
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream

    public boolean MakeMove(int fx,int fy,int tx,int ty){
        if(fx<1||fy<1||tx<1||ty<1
                ||fx>8||fy>8||tx>8||ty>8){
            //invalid
            return false;
        }

        ChessPiece fromPiece=theGamePieces[fx][fy];
        ChessPiece toPiece=theGamePieces[tx][ty];


        if(fromPiece==null){
            //invalid
            return false;
=======
    public static void startTheGame(String p1,String p2,int limit){
        if(!p1.matches(Constant.regexAcceptableCharacters)){
            System.out.println(Constant.errInvalidUsername);
            return;
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream

        //===================================
        //Make the move
        GameMoves.add(new ChessMove(theGamePieces,fx,fy,tx,ty));//Save History

        theGamePieces[tx][ty]=null;//Capture if any exists

        theGamePieces[tx][ty]=fromPiece;//move
        theGamePieces[fx][fy]=null;
        fromPiece.isFirstMove=false;
        return true;
=======
        else {
            ChessGame theGame = new ChessGame(Player.getPlayerByName(p1),Player.getPlayerByName(p2),limit);
            Menu.setMenuSituation(Menu.situation.gameMenue);
        }

>>>>>>> Stashed changes
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
