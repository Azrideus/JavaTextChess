package com.company.Structs;

import com.company.Classes.Constant;

import java.util.ArrayList;
import java.util.List;

public class ChessPiece {





    public List<ChessPiece> CreatePieces(Player p){
        List<ChessPiece> AllPieces=new ArrayList<ChessPiece>();
        var PColor=p.getPlayerColor();

        int PawnRow=7;
        int DefaultRow=8;
        if(PColor==Constant.PlayerColor.White){
            PawnRow=2;
            DefaultRow=1;
        }

        if(PColor==Constant.PlayerColor.White) {
            for (int i = 1; i <= 8; i++) {
                AllPieces.add(new ChessPiece(p,"pawn","Pw","♙",i,PawnRow));
            }
            AllPieces.add(new ChessPiece(p,"rook","Rw","♖",1,DefaultRow));
            AllPieces.add(new ChessPiece(p,"rook","Rw","♖",8,DefaultRow));

            AllPieces.add(new ChessPiece(p,"knight","Nw","♘",2,DefaultRow));
            AllPieces.add(new ChessPiece(p,"knight","Nw","♘",7,DefaultRow));

            AllPieces.add(new ChessPiece(p,"bishop","Bb","♗",3,DefaultRow));
            AllPieces.add(new ChessPiece(p,"bishop","Bb","♗",7,DefaultRow));

            AllPieces.add(new ChessPiece(p,"queen" ,"Qw","♕" ,4,DefaultRow));
            AllPieces.add(new ChessPiece(p,"king"  ,"Qb","♔" ,5,DefaultRow));
        }else{
            for (int i = 1; i <= 8; i++) {
                AllPieces.add(new ChessPiece(p,"pawn","Pb","♟",i,PawnRow));
            }
            AllPieces.add(new ChessPiece(p,"rook","Rb","♜",1,DefaultRow));
            AllPieces.add(new ChessPiece(p,"rook","Rb","♜",8,DefaultRow));
            AllPieces.add(new ChessPiece(p,"knight","Nb","♞",2,DefaultRow));
            AllPieces.add(new ChessPiece(p,"knight","Nb","♞",7,DefaultRow));
            AllPieces.add(new ChessPiece(p,"bishop","Bb","♝",3,DefaultRow));
            AllPieces.add(new ChessPiece(p,"bishop","Bb","♝",7,DefaultRow));
            AllPieces.add(new ChessPiece(p,"queen" ,"Qb","♛",4,DefaultRow));
            AllPieces.add(new ChessPiece(p,"king"  ,"Kb","♚",5,DefaultRow));
        }



        return AllPieces;

    }


    public ChessPiece(Player Owner,String name,String mapChar,String mapIcon,int x,int y){
        this.name=name;
        this.Owner=Owner;
        this.OwnerColor=Owner.getPlayerColor();
        this.mapIcon=mapChar;
        this.mapIcon=mapIcon;
        //==========
        this.OriginalX=x;
        this.OriginalY=y;
        this.x=x;
        this.x=y;
        //==========
    }
    private String mapIcon;
    private String mapChar;

    private String name;
    private Constant.PlayerColor OwnerColor;
    private Player Owner;

    private int x,y;
    private int OriginalX,OriginalY;
}
