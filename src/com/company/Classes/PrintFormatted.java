package com.company.Classes;

import com.company.Main;
import com.company.Structs.ChessHistory;
import com.company.Structs.ChessPiece;
import com.company.Structs.Player;

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
            System.out.println(p.getPlayerName()+" "+p.getScore()+" "+p.getWin()+" "+p.getDraw()+" "+p.getLose());
        }
    }
    public static void printHistoryMoves(boolean allMoves){
        for (ChessHistory item:
             Main.theGame.moveHistory) {
            if(!allMoves && item.fromPiece.Owner!=Main.theGame.currentPlayer) continue;
            String move = "**" +item.fromPiece.mapChar+" "+"x1,y1 to x2,y2";
           move= move.replace("x1",item.fromX+"").replace("y1",item.fromY+"");
           move= move.replace("x2",item.toX+"").replace("y2",item.toY+"");

            if(item.toPiece!=null) move+=" destroyed "+item.toPiece.mapChar;
            move+="**";
            System.out.println(move);
        }
    }
    public static void printKilledPieces(boolean allpieces){
        for (ChessHistory item:
                Main.theGame.killHistory) {
            if(!allpieces && item.fromPiece.Owner!=Main.theGame.currentPlayer) continue;
            String killed = "**" +item.fromPiece.name+" "+"killed in spot "+"x1,y1";
            killed=killed.replace("x1",item.toPiece.x+"").replace("y1",item.toPiece.y+"");
            killed+="**";
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
        s=s.replace("[username]",winner.getPlayerName()
                .replace("[color]",winner.getPlayerColor().toString()))

                ;
        System.out.println(s);
    }
}
