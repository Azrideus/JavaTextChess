package com.company.Structs;

import com.company.Classes.Constant;

public class ChessPiece {
    public ChessPiece(Player Owner,String name){
        this.name=name;
        this.Owner=Owner;
        this.OwnerColor=Owner.getPlayerColor();
    }
    private String name;
    private Player Owner;
    private Constant.PlayerColor OwnerColor;
}
