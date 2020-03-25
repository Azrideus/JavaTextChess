package com.company.Classes;

import com.company.Main;
import com.company.Structs.ChessHistory;
import com.company.Structs.ChessPiece;
import com.company.Structs.Player;

import java.util.ArrayList;
import java.util.List;

public class PrintFormatted {
    public static void printPlayerNamesByOrder(List<Player> players, Boolean isScoarBoard) {
        if (!isScoarBoard) {
            List<Player> p = myFunc.playersOrderAlphabetically(players);
        } else {
            List<Player> p = myFunc.playersOrderScoreboard(players);
        }
        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);
            if(!isScoarBoard) System.out.println(p.getPlayerName());
            else System.out.println(p.getPlayerName()+" "+p.getScore()+" "+p.getWin()+" "+p.getDraw()+" "+p.getLose());
        }
    }
    public static void printHistoryMoves(boolean allMoves){
        List<ChessHistory> templist= new ArrayList<ChessHistory>();
        templist.addAll(  Main.theGame.moveHistory);
        if(Main.theGame.LastMove!=null) templist.add(Main.theGame.LastMove);
        for (ChessHistory item:templist) {
            if(!allMoves && item.fromPiece.OwnerColor!=Main.theGame.currentPlayer.getPlayerColor()) continue;
            String move = "" +item.fromPiece.mapChar+" "+"x1,y1 to x2,y2";
           move= move.replace("x1",item.fromX+"").replace("y1",item.fromY+"");
           move= move.replace("x2",item.toX+"").replace("y2",item.toY+"");

            if(item.toPiece!=null) move+=" destroyed "+item.toPiece.mapChar;
            move+="";
            System.out.println(move);
        }
    }
    public static void printKilledPieces(boolean allpieces){
        List<ChessHistory> templist= new ArrayList<ChessHistory>();
        templist.addAll(  Main.theGame.killHistory);
        if(Main.theGame.LastMove!=null) templist.add(Main.theGame.LastMove);

        for (ChessHistory item:templist) {
            //System.out.println(item.fromPiece.mapIcon+":"+item.fromPiece.OwnerColor);
            //System.out.println("current player color"+":"+Main.theGame.currentPlayer.getPlayerColor());
            if(item.toPiece==null)continue;
            if(!allpieces &&
                    item.toPiece.OwnerColor
                    !=Main.theGame.currentPlayer.getPlayerColor()) continue;

            String killed = "" ;
            killed += "" +item.toPiece.mapChar+" "+"killed in spot "+"x1,y1";
            killed=killed.replace("x1",item.toPiece.x+"").replace("y1",item.toPiece.y+"");
            killed+="";
            System.out.println(killed);
        }
    }public static void printCurrentPlayerUndoNumber(){
        System.out.println(ConstantVar.strShowUndoNum
                .replace("[n]",Main.theGame.currentPlayer.undo_remain+"")

        );
    }
    public static void  printGameRes(Player winner,boolean isDraw){
        if(isDraw)System.out.println("draw");
        String s ="player [username] with color [color] won";
        s=s.replace("[username]",winner.getPlayerName());
        s=s.replace("[color]",winner.getPlayerColor().toString());
        System.out.println(s);
    }
}
