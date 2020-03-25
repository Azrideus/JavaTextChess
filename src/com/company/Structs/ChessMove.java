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
        this.fromX=fromPiece.x;
        this.fromY=fromPiece.y;
        this.toX=toPiece.x;
        this.toY=toPiece.y;
        this.theGamePiecesBeforeMove=theGamePiecesBeforeMove;
    }

    public ChessMove(ChessPiece[][] theGamePiecesBeforeMove,int fx,int fy,int tx,int ty){

        this.fromX=fx;
        this.fromY=fy;
        this.toX=tx;
        this.toY=ty;

        fromPiece=theGamePiecesBeforeMove[fx][fy];
        toPiece=theGamePiecesBeforeMove[toX][toY];

        this.theGamePiecesBeforeMove=theGamePiecesBeforeMove;

    }

}
