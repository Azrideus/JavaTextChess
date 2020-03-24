package com.company;

import com.company.Classes.Constant;
import com.company.Classes.myFunc;
import com.company.Structs.ChessGame;
import com.company.Structs.ChessPiece;
import com.company.Structs.Menu;
import com.company.Structs.Player;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static Player p1;
    public static ChessGame TheGame;

    public static ChessGame theGame;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        theGame=new ChessGame(
                new Player("test1","123",true)
                ,new Player("test2","123",true),100);

        theGame.PrintBoard(true,true);
        var p1= theGame.GetPieceAtPos(1,4);
        System.out.println(p1.mapIcon+" is at "+p1.x+" : "+p1.y);
        theGame.MakeMove(1,2,3,1);
        theGame.PrintBoard(true,true);
        while(true) {
            String line=in.nextLine();
            if(Menu.situ== Menu.situation.loginMenu) loginMenu(line);
        }


    }

    private static void mainMenu(String input){
        if(input.matches(Constant.regexNewGame)){
            Matcher matcher = getMatcher(input,Constant.regexNewGame);
            ChessGame.startTheGame(matcher.group(1),p1.getPlayerName(),Integer.valueOf(matcher.group(2)));
        }
        else if(input.equals("list_users")) {
            myFunc.printPlayerNamesByOrder(Player.allPlayers,false);
        }
        else if(input.equals("help")) {
            System.out.println(Menu.help);

        }
        else if(input.equals("scoreboard")){
            myFunc.printPlayerNamesByOrder(Player.allPlayers,true);
        }
        else if(input.equals("logout")) p1.logOut();
        else System.out.println(Constant.errInvalidCmd);
    }


    private static void loginMenu(String input) {
        if(input.matches(Constant.regexRegister)) {
            Matcher matcher = getMatcher(input,Constant.regexRegister);
            Player.register(matcher.group(1),matcher.group(2));
        }
        else if(input.matches(Constant.regexLogin)) {
            Matcher matcher = getMatcher(input,Constant.regexLogin);
            Player.login(matcher.group(1),matcher.group(2));
        }
        else if(input.matches(Constant.regexRemove)) {
            Matcher matcher = getMatcher(input,Constant.regexRemove);
            Player.remove(matcher.group(1),matcher.group(2));
        }
        else if(input.equals("list_users")) {
            myFunc.printPlayerNamesByOrder(Player.allPlayers,false);
        }
        else if(input.equals("help")) {
            System.out.println(Menu.help);
        }
        else if(input.equals("exit")) System.out.println("program ended");
        else System.out.println(Constant.errInvalidCmd);
    }


    private static Matcher getMatcher(String line, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        matcher.find();
        return matcher;
    }



}
