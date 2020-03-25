package com.company.Structs;

public class Menu {
	public static situation getSitu() {
		return situ;
	}

	public  static enum situation{loginMenu,mainMenu,gameMenu};
	private  static situation situ=situation.loginMenu;
	public  static String help;
	static public void setMenuSituation(situation situ) {
		Menu.situ=situ;
		if(situ==situation.loginMenu) Menu.help="register [username] [password]\r\n" + 
				"login [username] [password]\r\n" + 
				"remove [username] [password]\r\n" + 
				"list_users\r\n" + 
				"help\r\n" + 
				"exit";
		else if(situ==situation.mainMenu) Menu.help="new_game [username] [limit]\r\n" + 
				"scoreboard\r\n" + 
				"list_users\r\n" + 
				"help\r\n" + 
				"logout";
		else if(situ==situation.gameMenu) Menu.help="select [x],[y]\r\n" +
				"deselect\r\n" + 
				"move [x],[y]\r\n" + 
				"next_turn\r\n" + 
				"show_turn\r\n" + 
				"undo\r\n" + 
				"undo_number\r\n" + 
				"show_moves [-all]\r\n" + 
				"show_killed [-all]\r\n" + 
				"show_board\r\n" + 
				"help\r\n" + 
				"forfeit";
	}
}
