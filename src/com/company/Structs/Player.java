package com.company.Structs;

import com.company.Classes.Constant;

import java.util.ArrayList;
import java.util.List;

public class Player {
	public static List<Player> allPlayers = new ArrayList<Player>();
	private String name;
	private String pass;
	private boolean isLogined;
	private Constant.PlayerColor playerColor;
	private int win;
	private int lose;
	private int draw;
	public Player(String name,String pass,Boolean isLogined) {
		this.name=name;
		this.pass=pass;
		this.isLogined=isLogined;
		allPlayers.add(this);
	}
	public static void register(String name,String pass) {
		if(!MatchAcceptableUsername(name))return;
		else if(!MatchAcceptablePass(pass))return;

		Player player = getPlayerByName(name);
		if(player!=null) {
			System.out.println(Constant.errUserAlreadyExist);
			return;
		}
		Player p = new Player(name,pass,false);
		System.out.println(Constant.successRegister);
	}
	public static void login(String name,String pass) {
		if(!MatchAcceptableUsername(name))return;
		else if(!MatchAcceptablePass(pass))return;

		Player player = getPlayerByName(name);
		if(player==null) {
			System.out.println(Constant.errNotExistPlayer);
			return;
		}
		else if(!player.pass.equals(pass)) {
			System.out.println(Constant.errincorrectPass);
			return;
		}
		else player.isLogined=true;
		System.out.println(Constant.successLogin);

		//=============CHANGE SITUATION=====================
		Menu.setMenuSituation(Menu.situation.mainMenu);
		//=============CHANGE SITUATION=====================
	}
	public static void remove(String name,String pass) {
		if(!MatchAcceptableUsername(name))return;
		else if(!MatchAcceptablePass(pass))return;

		Player player = getPlayerByName(name);
		if(player==null) {
			System.out.println(Constant.errNotExistPlayer);
			return;
		}
		else if(!player.pass.equals(pass)) {
			System.out.println(Constant.errincorrectPass);
			return;
		}
		for(int i=0;i<allPlayers.size();i++) {
			if(name.equals(allPlayers.get(i).name)) allPlayers.remove(i);
		}
		System.out.println(Constant.successRemove.replace("*",name ));
	}

	public static boolean MatchAcceptableUsername(String name) {
		if(!name.matches(Constant.regexAcceptableCharacters)) {
			System.out.println(Constant.errInvalidUsername);
			return false;
		}
		return true;
	}
	public static boolean MatchAcceptablePass(String pass) {
		if(!pass.matches(Constant.regexAcceptableCharacters)) {
			System.out.println(Constant.errInvalidPass);
			return false;
		}
		return true;
	}

	public static Player getPlayerByName(String name) {
		for(int i=0;i<allPlayers.size();i++) 
			if(allPlayers.get(i).name.equals(name)) return allPlayers.get(i);
		return null;
	}

	public String getPlayerName() {
		return name;
	}
	public Constant.PlayerColor getPlayerColor() {
		return playerColor;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}
}

