package com.company.Structs;

import com.company.Classes.Constant;

import java.util.ArrayList;
import java.util.List;

public class Player {
	static List<Player> allPlayers = new ArrayList<Player>();
	private String name;
	private String pass;
	private boolean isLogined;
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
		Menu.setMenuSituation(Menu.situation.mainMenu);
		System.out.println(Constant.successLogin);
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
	}public static boolean MatchAcceptablePass(String pass) {
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

}

