package com.company.Structs;

import com.company.Classes.ConstantVar;
import com.company.Main;

import java.util.ArrayList;
import java.util.List;

public class Player {

	enum gameResultSituation {
		Win,Lose,Draw,Forfeit
	}
	public static List<Player> allPlayers = new ArrayList<Player>();


	private final String name;
	private final String pass;

	private boolean isLogined;


	private ConstantVar.PlayerColor playerColor;
	private int win;
	private int lose;
	private int draw;
	private int score;

	public ChessPiece selectedPiece;

	public boolean hasMoved;
	public boolean usedUndo;
	public int undo_remain;



	public Player(String name, String pass, Boolean isLogined) {
		this.name = name;
		this.pass = pass;
		this.isLogined = isLogined;
		allPlayers.add(this);
	}
	public void playerGameEnd(gameResultSituation wld) {
		switch (wld){
			case Draw:
				setScore(getScore()+1);
				setDraw(getDraw()+1);
				break;
			case Win:
				setScore(getScore()+2);
				setWin(getWin()+1);
				break;
			case Lose:
				setScore(getScore()-1);
				setLose(getLose()-1);
				break;
			case Forfeit:
				setScore(getScore()-1);
				setLose(getLose()-1);
				break;
		}
	}
	public void logOut() {
		System.out.println(ConstantVar.successLogOut);
		this.isLogined = false;
		//=============CHANGE SITUATION=====================
		Menu.setMenuSituation(Menu.situation.loginMenu);
		//=============CHANGE SITUATION=====================
	}

	public static void register(String name, String pass) {
		if (!MatchAcceptableUsername(name)) return;
		else if (!MatchAcceptablePass(pass)) return;

		Player player = getPlayerByName(name);
		if (player != null) {
			System.out.println(ConstantVar.errUserAlreadyExist);
			return;
		}
		Player p = new Player(name, pass, false);
		System.out.println(ConstantVar.successRegister);
	}

	public static void login(String name, String pass) {
		if (!MatchAcceptableUsername(name)) return;
		else if (!MatchAcceptablePass(pass)) return;

		Player player = getPlayerByName(name);
		if (player == null) {
			System.out.println(ConstantVar.errNotExistPlayer);
			return;
		} else if (!player.pass.equals(pass)) {
			System.out.println(ConstantVar.errincorrectPass);
			return;
		} else player.isLogined = true;
		System.out.println(ConstantVar.successLogin);
		Main.p1 = player;
		//=============CHANGE SITUATION=====================
		Menu.setMenuSituation(Menu.situation.mainMenu);
		//=============CHANGE SITUATION=====================
	}

	public static void remove(String name, String pass) {
		if (!MatchAcceptableUsername(name)) return;
		else if (!MatchAcceptablePass(pass)) return;

		Player player = getPlayerByName(name);
		if (player == null) {
			System.out.println(ConstantVar.errNotExistPlayer);
			return;
		} else if (!player.pass.equals(pass)) {
			System.out.println(ConstantVar.errincorrectPass);
			return;
		}
		for (int i = 0; i < allPlayers.size(); i++) {
			if (name.equals(allPlayers.get(i).name)) allPlayers.remove(i);
		}
		System.out.println(ConstantVar.successRemove.replace("*", name));
	}

	private static boolean MatchAcceptableUsername(String name) {
		if (!name.matches(ConstantVar.regexAcceptableCharacters)) {
			System.out.println(ConstantVar.errInvalidUsername);
			return false;
		}
		return true;
	}

	private static boolean MatchAcceptablePass(String pass) {
		if (!pass.matches(ConstantVar.regexAcceptableCharacters)) {
			System.out.println(ConstantVar.errInvalidPass);
			return false;
		}
		return true;
	}

	public static Player getPlayerByName(String name) {
		for (int i = 0; i < allPlayers.size(); i++)
			if (allPlayers.get(i).name.equals(name)) return allPlayers.get(i);
		return null;
	}

	public String getPlayerName() {
		return name;
	}

	public ConstantVar.PlayerColor getPlayerColor() {
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

	public void setPlayerColor(ConstantVar.PlayerColor playerColor) {
		this.playerColor = playerColor;
	}


	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}