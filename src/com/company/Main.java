package com.company;

import com.company.Classes.Constant;
import com.company.Classes.myFunc;
import com.company.Structs.Menu;
import com.company.Structs.Player;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static Matcher getMatcher(String line, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        matcher.find();
        return matcher;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        while(true) {
            String line=in.nextLine();
            if(Menu.situ== Menu.situation.loginMenu) loginMenu(line);
        }
    }
    private static void mainMenu(String input){
        if(input.matches())
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
            myFunc.printPlayerNamesByAlphabeticallyOrder(Player.allPlayers);
        }
        else if(input.equals("help")) {
            System.out.println(Menu.help);
        }
        else System.out.println(Constant.errInvalidCmd);
    }

}
