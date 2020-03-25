package com.company;

import com.company.Classes.ConstantVar;
import com.company.Classes.PrintFormatted;
import com.company.Structs.ChessGame;
import com.company.Structs.Menu;
import com.company.Structs.Player;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static Player p1;
    public static ChessGame theGame;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);



        //System.out.println(p1.mapIcon+" is at "+p1.x+" : "+p1.y );
        while(true) {
            String line=in.nextLine();
            try{
                if(Menu.situ== Menu.situation.loginMenu) loginMenu(line);
                else if(Menu.situ==Menu.situation.gameMenu)gameMenu(line);
                else mainMenu(line);
            }catch (Exception ex){
                ex.printStackTrace();
                System.out.println(ConstantVar.errInvalidCmd);
            }
        }


    }

    private static void mainMenu(String input){
        if(input.matches(ConstantVar.regexNewGame)){
            Matcher matcher = getMatcher(input, ConstantVar.regexNewGame);
            ChessGame.startTheGame(p1.getPlayerName(),matcher.group(1),Integer.valueOf(matcher.group(2)));
        }
        else if(input.equals("list_users"))  PrintFormatted.printPlayerNamesByOrder(Player.allPlayers,false);
        else if(input.equals("help")) System.out.println(Menu.help);
        else if(input.equals("scoreboard")) PrintFormatted.printPlayerNamesByOrder(Player.allPlayers,true);
        else if(input.equals("logout")) p1.logOut();
        else System.out.println(ConstantVar.errInvalidCmd);
    }
    private static void gameMenu(String input){
        if(input.matches(ConstantVar.regexSelect)){
            Matcher matcher = getMatcher(input, ConstantVar.regexSelect);
            int x=Integer.parseInt(matcher.group(1));
            int y=Integer.parseInt(matcher.group(2));
            theGame.currentPlayerSelect(x,y);
        }else if(input.matches(ConstantVar.regexMove)){
            Matcher matcher = getMatcher(input, ConstantVar.regexMove);

            int tx=Integer.parseInt(matcher.group(1));
            int ty=Integer.parseInt(matcher.group(2));
            theGame.MakeMove(tx,ty);
        }else if(input.matches(ConstantVar.regexSelectMove)){
            Matcher matcher = getMatcher(input, ConstantVar.regexSelectMove);

            int fx=Integer.parseInt(matcher.group(1));
            int fy=Integer.parseInt(matcher.group(2));
            int tx=Integer.parseInt(matcher.group(3));
            int ty=Integer.parseInt(matcher.group(4));
            theGame.currentPlayerSelect(fx,fy);
            if(theGame.currentPlayer.selectedPiece!=null) {
                theGame.MakeMove(tx,ty);
                theGame.currentPlayerEndTurn();
            }
        }
        else if(input.equals("deselect"))theGame.currentPlayerDeselect();
        else if(input.equals("show_board"))theGame.PrintBoard(false,true);
        else if(input.equals("end_turn"))theGame.currentPlayerEndTurn();
        else if(input.equals("show_turn"))theGame.currentPlayerShowTurn();
        else if(input.equals("show_moves")) PrintFormatted.printHistoryMoves(false);
        else if(input.equals("show_moves -all")) PrintFormatted.printHistoryMoves(true);
        else if(input.equals("undo"))theGame.currentPlayerUndo();
        else if(input.equals("undo_number"))PrintFormatted.printCurrentPlayerUndoNumber();
        else if(input.equals("show_killed"))PrintFormatted.printKilledPieces(false);
        else if(input.equals("show_killed -all"))PrintFormatted.printKilledPieces(true);
         else if(input.equals("help")) System.out.println(Menu.help);
        else if(input.equals("forfeit")) theGame.currentForfeit();
        else System.out.println(ConstantVar.errInvalidCmd);
    }
    private static void loginMenu(String input) {
        if(input.matches(ConstantVar.regexRegister)) {
            Matcher matcher = getMatcher(input, ConstantVar.regexRegister);
            Player.register(matcher.group(1),matcher.group(2));
        }
        else if(input.matches(ConstantVar.regexLogin)) {
            Matcher matcher = getMatcher(input, ConstantVar.regexLogin);
            Player.login(matcher.group(1),matcher.group(2));
        }
        else if(input.matches(ConstantVar.regexRemove)) {
            Matcher matcher = getMatcher(input, ConstantVar.regexRemove);
            Player.remove(matcher.group(1),matcher.group(2));
        }
        else if(input.equals("list_users")) {
            PrintFormatted.printPlayerNamesByOrder(Player.allPlayers,false);
        }
        else if(input.equals("help")) {
            System.out.println(Menu.help);
        }
        else if(input.equals("auto")) {
            System.out.println("Auto register/login/new game");
            Player.register("A","A");
            Player.register("B","B");
            Player.login("A","A");
            ChessGame.startTheGame(p1.getPlayerName(),"B",100);
            theGame.PrintBoard(false,true);
        }
        else if(input.equals("exit")) System.out.println("program ended");
        else System.out.println(ConstantVar.errInvalidCmd);
        return;
    }


    private static Matcher getMatcher(String line, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        matcher.find();
        return matcher;
    }



}
