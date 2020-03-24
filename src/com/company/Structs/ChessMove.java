package com.company.Structs;

public class ChessMove {
    public int fromX,fromY;
    public int toX,toY;
    ChessPiece[][] theGamePiecesBeforeMove;
    ChessPiece fromPiece;
    ChessPiece toPiece;

    public ChessMove(ChessPiece[][] theGamePiecesBeforeMove,
                     ChessPiece fromPiece, ChessPiece toPiece){
        this.fromX=fromPiece.x;
        this.fromY=fromPiece.y;
        this.toX=toPiece.x;
        this.toY=toPiece.y;
        this.theGamePiecesBeforeMove=theGamePiecesBeforeMove;
    }

    public ChessMove(ChessPiece[][] theGamePiecesBeforeMove,int fx,int fy,int tx,int ty){
        if(fx<1||fy<1||tx<1||ty<1
        ||fx>8||fy>8||tx>8||ty>8){
            return;
        }
        this.fromX=fx;
        this.fromY=fy;
        this.toX=tx;
        this.toY=ty;

        fromPiece=theGamePiecesBeforeMove[fx][fy];
        toPiece=theGamePiecesBeforeMove[toX][toY];

        this.theGamePiecesBeforeMove=theGamePiecesBeforeMove;
    }

}
