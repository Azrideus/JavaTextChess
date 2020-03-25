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
             Main.theGame.MoveHistory) {
            if(!allMoves && item.fromPiece.Owner!=Main.theGame.currentPlayer) continue;
            String move = "** " +item.fromPiece.mapChar+" "+"x1, y1 to x2, y2";
            move.replace("x1",item.fromPiece.x+"").replace("y1",item.fromPiece.y+"");
            move.replace("x2",item.toPiece.x+"").replace("y2",item.toPiece.y+"");
            if(item.toPiece!=null) move+="destroyed "+item.toPiece.mapChar;
            move+=" **";
            System.out.println(move);
        }
    }
    public static void printKilledPieces(boolean allPeaces){
        for (ChessPiece item:
                Main.theGame.) {
            if(!allMoves && item.fromPiece.Owner!=Main.theGame.currentPlayer) continue;
            String move = "** " +item.fromPiece.mapChar+" "+"x1, y1 to x2, y2";
            move.replace("x1",item.fromPiece.x+"").replace("y1",item.fromPiece.y+"");
            move.replace("x2",item.toPiece.x+"").replace("y2",item.toPiece.y+"");
            if(item.toPiece!=null) move+="destroyed "+item.toPiece.mapChar;
            move+=" **";
            System.out.println(move);
        }
    }
}
