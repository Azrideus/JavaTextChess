package com.company.Structs;

import com.company.Classes.Constant;
import com.company.Classes.myFunc;

import java.util.ArrayList;
import java.util.List;

public class ChessGame {

    List<ChessMove> GameMoves;
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
        GameMoves=new ArrayList<ChessMove>();
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
            p.isFirstMove=true;
        }
        for (ChessPiece p:
                ChessPiece.CreatePieces(p2)) {
            theGamePieces[p.OriginalX][p.OriginalY]=p;
            p.isFirstMove=true;
        }
        currentPlayer=player1;
        //=========================================
        //PrintBoard(true);
    }

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
        }

        if(fromPiece.OwnerColor!=currentPlayer.getPlayerColor()){
            //invalid  , NOT your turn
            return false;
        }

        if(toPiece!=null&&fromPiece.OwnerColor==toPiece.OwnerColor){
            //invalid, same color
            return false;
        }

        if(!isValidMove(fromPiece,toPiece,tx,fy,tx,ty)){
            //invalid , cant make that move
            return false;
        }

        //===================================
        //Make the move
        GameMoves.add(new ChessMove(theGamePieces,fx,fy,tx,ty));//Save History

        theGamePieces[tx][ty]=null;//Capture if any exists

        theGamePieces[tx][ty]=fromPiece;//move
        theGamePieces[fx][fy]=null;
        fromPiece.isFirstMove=false;
        return true;
    }
    public boolean isValidMove(ChessPiece p,ChessPiece tp,int fx,int fy,int tx,int ty){

        if(tp!=null&&p.OwnerColor==tp.OwnerColor)return false;

        switch (p.name){
            case "king":
                return myFunc.Distance(fx,fy,tx,ty) <= 1; // if distance is lower than 1
            case "pawn":
                if(tp!=null){//Capture
                    //check move
                    if(p.OwnerColor== Constant.PlayerColor.White){

                        //Valid pos in CAPTURE MODE

                        if(ty!=fy-1)return false;

                        if((tx==fx-1)
                           ||(tx==fx+1&&tx>0))return true;

                        return false;
                    }

                    return true;
                }else if(p.isFirstMove){

                }

                break;
            case "rook":
                break;
            case "knight":
                break;
        }
        return true;
    }

    public ChessPiece GetPieceAtPos(int x,int y){
        if(x>0&&y>0&&x<=8&&y<=8)return theGamePieces[x][y];
        else return null;
    }
    public void PrintBoard(boolean fancy,boolean flip)
    {
        boolean IsFirst=true;
        for (int i = 1; i < theGamePieces.length; i++) {

            IsFirst=true;
            for (int j = 1; j < theGamePieces[i].length; j++) {
                ChessPiece p;
                if(flip){
                    p=theGamePieces[9-i][j];
                }else{
                    p=theGamePieces[i][j];
                }


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
