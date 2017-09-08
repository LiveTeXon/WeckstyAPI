package de.weckstyapi.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;



public class Methodes_MySQL {
	
	public static void createDefaultMySQL() {
		try {
			Statement s = MySQL.con.createStatement();
			
			s.executeUpdate("CREATE TABLE IF NOT EXISTS Profiel (UUID VARCHAR(100), Spielername VARCHAR(100), Nick INT(100), Coins INT(100), Globalmute INT(100), LetherChestPlate INT(100), Heads INT(100), Banner INT(100))");
			s.executeUpdate("CREATE TABLE IF NOT EXISTS OnlineUser (Online INT (100))");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//GETCOINS //CODE 1
	public static int getCoins(Player p) {
		try {
			Statement s = MySQL.con.createStatement();
			ResultSet rs = s.executeQuery("SELECT Coins FROM Profiel WHERE UUID= '"+p.getUniqueId()+"'");
			while(rs.next()) {
				return rs.getInt("Coins");
			}
			s.close();
		}catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage("§c[SQLFehler] Code: 001");
		}
		return 0;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//SETCOINS //CODE 2
	public static void setCoins(Player p, int Coins) {
		try {
			Statement s = MySQL.con.createStatement();
			
			s.executeUpdate("UPDATE Profiel SET Coins = "+Coins+" WHERE UUID= '"+p.getUniqueId()+"'");
		}catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage("§c[SQLFehler] Code: 002");
		}
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//ADDCOINS //CODE: 3
    public static void addCoins(Player p, int Coins) {
    	int Playercoins = getCoins(p);
    	int total = Playercoins + Coins;
    	
    	try {
    		Statement s = MySQL.con.createStatement();
    		
    		s.executeUpdate("UPDATE Profiel SET Coins = "+total+" WHERE UUID= '"+p.getUniqueId()+"'");
    		
    	} catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage("§c[SQLFehler] Code: 003");
		}
    }
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//REMOVECOINS //CODE: 4
	public static void removeCoins(Player p, int Coins) {
		
		int Playercoins = getCoins(p);
		int total = Playercoins - Coins;
		
		try {
			Statement s = MySQL.con.createStatement();
			
			s.executeUpdate("UPDATE Profiel SET Coins = "+total+" WHERE UUID= '"+p.getUniqueId()+"'");
		}catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage("§c[SQLFehler] Code: 004");
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//CREATEPROFIEL //CODE: 5
	public static void createPlayerProfiel(Player p) {
		try {
			Statement s = MySQL.con.createStatement();
			
			s.executeUpdate("INSERT INTO Profiel (`UUID`, `Spielername`,`Nick`, `Coins`, `Globalmute`, `LetherChestPlate`, `Heads`, `Banner`) VALUES ('"+p.getUniqueId()+"', '"+p.getName()+"','0', '0', '0', '0', '0', '0')");
			s.close();
		}catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage("§c[SQLFehler] Code: 005");
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//HASPROFIEL //CODE: 6
	public static String hasPlayerProfiel(String player) {
		try {
			Statement s = MySQL.con.createStatement();
			ResultSet rs = s.executeQuery("SELECT Spielername FROM Profiel WHERE Spielername= '"+player+"'");
			
			while (rs.next()) {
				return rs.getString("Spielername");
			}
			s.close();
		}catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage("§c[SQLFehler] Code: 006");
		}
		
		return null;
		
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//SETLEATHERPLATE //CODE: 7
	public static void setLeatherPlate(Player p, int num) {
		try {
			Statement s = MySQL.con.createStatement();
			
			s.executeUpdate("UPDATE Profiel SET LetherChestPlate = "+num+" WHERE UUID= '"+p.getUniqueId()+"'");
		}catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage("§c[SQLFehler] Code: 007");
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//GETONLINESTATUS //CODE: 8
	public static int getLeatherPlate(Player p) {
		try {
			Statement s = MySQL.con.createStatement();
			ResultSet rs = s.executeQuery("SELECT LetherChestPlate FROM Profiel WHERE UUID= '"+p.getUniqueId()+"'");
			while(rs.next()) {
				return rs.getInt("LetherChestPlate");
			}
			s.close();
		}catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage("§c[SQLFehler] Code: 008");
		}
		return 0;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//SETHEADS //CODE: 9
	public static void setHeads(Player p, int num) {
		try {
			Statement s = MySQL.con.createStatement();
			
			s.executeUpdate("UPDATE Profiel SET Heads = "+num+" WHERE UUID= '"+p.getUniqueId()+"'");
		}catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage("§c[SQLFehler] Code: 009");
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//GETHEADS //CODE: 10
	public static int getHeads(Player p) {
		try {
			Statement s = MySQL.con.createStatement();
			ResultSet rs = s.executeQuery("SELECT Heads FROM Profiel WHERE UUID= '"+p.getUniqueId()+"'");
			while(rs.next()) {
				return rs.getInt("Heads");
			}
			s.close();
		}catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage("§c[SQLFehler] Code: 010");
		}
		return 0;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//SETBANNER //CODE: 11
	public static void setBanner(Player p, int num) {
		try {
			Statement s = MySQL.con.createStatement();
			
			s.executeUpdate("UPDATE Profiel SET Banner = "+num+" WHERE UUID= '"+p.getUniqueId()+"'");
		}catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage("§c[SQLFehler] Code: 011");
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//GETBANNER //CODE: 11
	public static int getBanner(Player p) {
		try {
			Statement s = MySQL.con.createStatement();
			ResultSet rs = s.executeQuery("SELECT Banner FROM Profiel WHERE UUID= '"+p.getUniqueId()+"'");
			while(rs.next()) {
				return rs.getInt("Banner");
			}
			s.close();
		}catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage("§c[SQLFehler] Code: 011");
		}
		return 0;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//SETONLINEUSER //CODE: 12
	public static void setOnlineUser(int num) {
		try {
			Statement s = MySQL.con.createStatement();
			
			s.executeUpdate("UPDATE OnlineUser SET Online = "+num);
		}catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage("§c[SQLFehler] Code: 012");
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//GETONLINEUSER //CODE: 13
	public static int getOnlineUser() {
		try {
			Statement s = MySQL.con.createStatement();
			ResultSet rs = s.executeQuery("SELECT Online FROM OnlineUser");
			while(rs.next()) {
				return rs.getInt("Online");
			}
			s.close();
		}catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage("§c[SQLFehler] Code: 013");
		}
		return 0;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//SETNICK_AN/AUS //CODE 14
	public static void setNick(Player p, int num) {
		try {
			Statement s = MySQL.con.createStatement();
			
			s.executeUpdate("UPDATE Profiel SET Nick = "+num+" WHERE UUID= '"+p.getUniqueId()+"'");
		}catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage("§c[SQLFehler] Code: 0014");
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//GETNICK //CODE: 15
	public static int getNick() {
		try {
			Statement s = MySQL.con.createStatement();
			ResultSet rs = s.executeQuery("SELECT Nick FROM Profiel");
			while(rs.next()) {
				return rs.getInt("Nick");
			}
			s.close();
		}catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage("§c[SQLFehler] Code: 015");
		}
		return 0;
	}
}










































