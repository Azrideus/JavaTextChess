package com.company.Structs;

import com.company.Classes.Constant;

import java.util.ArrayList;
import java.util.List;

public class ChessPiece  implements Cloneable {


    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }
    public static List<ChessPiece> CreatePieces(Player p){
        List<ChessPiece> AllPieces=new ArrayList<ChessPiece>();
        var PColor=p.getPlayerColor();

        int PawnRow;
        int DefaultRow;
        if(PColor==Constant.PlayerColor.White){
            PawnRow=2;
            DefaultRow=1;
        }else{
            PawnRow=7;
            DefaultRow=8;
        }

        if(PColor==Constant.PlayerColor.Black) {

            for (int i = 1; i <= 8; i++) {
                AllPieces.add(new ChessPiece(p,"pawn","Pb","♙",PawnRow,i));
            }
            AllPieces.add(new ChessPiece(p,"rook",  "Rb","♖"   ,DefaultRow,1));
            AllPieces.add(new ChessPiece(p,"rook",  "Rb","♖"   ,DefaultRow,8));
            AllPieces.add(new ChessPiece(p,"knight","Nb","♘" ,DefaultRow,2));
            AllPieces.add(new ChessPiece(p,"knight","Nb","♘" ,DefaultRow,7));
            AllPieces.add(new ChessPiece(p,"bishop","Bb","♗" ,DefaultRow,3));
            AllPieces.add(new ChessPiece(p,"bishop","Bb","♗" ,DefaultRow,6));
            AllPieces.add(new ChessPiece(p,"queen" ,"Qb","♕" ,DefaultRow,4));
            AllPieces.add(new ChessPiece(p,"king"  ,"Qb","♔" ,DefaultRow,5));
        }else{
            for (int i = 1; i <= 8; i++) {
                AllPieces.add(new ChessPiece(p,"pawn","Pw","♟",PawnRow,i));
            }
            AllPieces.add(new ChessPiece(p,"rook",  "Rw",  "♜"  ,DefaultRow,1));
            AllPieces.add(new ChessPiece(p,"rook",  "Rw",  "♜"  ,DefaultRow,8));
            AllPieces.add(new ChessPiece(p,"knight","Nw","♞",DefaultRow,2));
            AllPieces.add(new ChessPiece(p,"knight","Nw","♞",DefaultRow,7));
            AllPieces.add(new ChessPiece(p,"bishop","Bw","♝",DefaultRow,3));
            AllPieces.add(new ChessPiece(p,"bishop","Bw","♝",DefaultRow,6));
            AllPieces.add(new ChessPiece(p,"queen" ,"Qw","♛",DefaultRow,4));
            AllPieces.add(new ChessPiece(p,"king"  ,"Kw","♚",DefaultRow,5));
        }

        return AllPieces;

    }


    public ChessPiece(Player Owner,String name,String mapChar,String mapIcon,int x,int y){
        this.name=name;

        this.Owner=Owner;
        this.OwnerColor=Owner.getPlayerColor();

        this.mapIcon=mapIcon;
        this.mapChar=mapChar;
        //==========
        this.OriginalX=x;
        this.OriginalY=y;
        this.x=x;
        this.y=y;
        this.isFirstMove=true;
        //==========
    }
    public final int OriginalX,OriginalY;
    public final String mapIcon;
    public final String mapChar;
    public final String name;
    public final Constant.PlayerColor OwnerColor;
    public final Player Owner;

    public boolean isFirstMove;
    public int x,y;

}
