package com.company.Structs;

import com.company.Classes.Constant;

import java.util.ArrayList;
import java.util.List;

public class ChessGame {
    ChessPiece[][] theGamePieces;
    List<ChessMove> MoveHistory;
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
        MoveHistory=new ArrayList<ChessMove>();
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
        SwitchPlayer(1);
        //========================================
        //PrintBoard(true);
    }


    public void SwitchPlayer(int pIndex){

        if(pIndex<=0){//If index == 0  toggle the Player
            if(currentPlayer!=player1){
                pIndex=1;
            }else{
                pIndex=2;
            }
        }

        //=== set player from index
        if(pIndex==1)currentPlayer=player1;
        else if(pIndex==2)currentPlayer=player2;
        if(currentPlayer!=null){
            if(Constant._isDebug){
                System.out.println("[ Its "+currentPlayer.getPlayerName()+"'s turn ! ]");
            }
            currentPlayer.selectedPiece=null;
            currentPlayer.hasMoved=false;
        }
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
        else if(toPiece!=null&&fromPiece.OwnerColor==toPiece.OwnerColor){
            //invalid same color
            return false;
        }
        else if(fromPiece==toPiece){
            //invalid same position
            return false;
        }



        //===================================
        //Make the move
        MoveHistory.add(new ChessMove(theGamePieces,fx,fy,tx,ty));//Save History

        theGamePieces[tx][ty]=null;//Capture if any exists

        theGamePieces[tx][ty]=fromPiece;//move
        theGamePieces[fx][fy]=null;//Set old to null
        fromPiece.isFirstMove=false;
        return true;
    }
    public void PrintBoard(boolean fancy,boolean flip){
        boolean IsFirst=true;
        System.out.println("");

        if(!fancy)fancy=Constant._isDebug;

        for (int i = 1; i < theGamePieces.length; i++) {
            IsFirst=true;
            for (int j = 1; j < theGamePieces[i].length; j++) {
                ChessPiece p;
                if(flip){
                    p=theGamePieces[i][9-j];
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

    public static void startTheGame(String p1,String p2,int limit){
        if (!p1.matches(Constant.regexAcceptableCharacters)) {
            System.out.println(Constant.errInvalidUsername);
            return;
        } else if (limit < 0) {
            System.out.println(Constant.errInvalidLimit);
            return;
        } else if (p1.equals(p2)) {
            System.out.println(Constant.errChooseAnotherPlayer);
            return;
        } else {
            var p1c=Player.getPlayerByName(p1);
            var p2c=Player.getPlayerByName(p2);
            if (p1c == null) {
                System.out.println(Constant.errNotExistPlayer);
                return;
            }
            else if (p2c == null) {
                System.out.println(Constant.errNotExistPlayer);
                return;
            }else{
                ChessGame theGame = new ChessGame(p1c, p2c, limit);
                Menu.setMenuSituation(Menu.situation.gameMenue);
                System.out.println(Constant.successNewGame
                        .replace("[first]",p1)
                        .replace("[second]",p2)
                        .replace("[limit]",limit+"")
                )
                        ;
            }

        }
    }
}
