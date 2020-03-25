package com.company.Structs;

public class ChessMove {
    public final int fromX,fromY;
    public final int toX,toY;
    public final ChessPiece[][] theGamePiecesBeforeMove;
    public final ChessPiece fromPiece;
    public final ChessPiece toPiece;

    public ChessMove(ChessPiece[][] theGamePiecesBeforeMove,
                     ChessPiece fromPiece, ChessPiece toPiece){

        this.fromPiece=fromPiece;
        this.toPiece=toPiece;

        if(fromPiece!=null) {
            this.fromX = fromPiece.x;
            this.fromY = fromPiece.y;
        }else{
            this.fromX =-1;
            this.fromY =-1;
        }
        if(toPiece!=null){
            this.toX=toPiece.x;
            this.toY=toPiece.y;
        }else{
            this.toX=-1;
            this.toY=-1;
        }

        this.theGamePiecesBeforeMove=theGamePiecesBeforeMove;
    }

    public ChessMove(ChessPiece[][] theGamePiecesBeforeMove,int fx,int fy,int tx,int ty){



        this.fromX=fx;
        this.fromY=fy;
        this.toX=tx;
        this.toY=ty;

        if(fx>=1&&fy>=1&&fx<=8&&fy<=8){
            fromPiece=theGamePiecesBeforeMove[fx][fy];
        }else{
            fromPiece=null;
        }

        if(tx>=1&&ty>=1&&tx<=8&&ty<=8){
            toPiece=theGamePiecesBeforeMove[tx][ty];
        }else{
            toPiece=null;
        }


        this.theGamePiecesBeforeMove=theGamePiecesBeforeMove;

    }

}
