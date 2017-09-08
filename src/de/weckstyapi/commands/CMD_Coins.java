package de.weckstyapi.commands;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.weckstyapi.main.Main;
import de.weckstyapi.utils.Methodes_MySQL;

public class CMD_Coins implements CommandExecutor {
	
	 @Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		 Player p = (Player)sender;
		 //COINS
		 if(args.length == 0) {
			 p.sendMessage(Main.coin_prefix+ "§7Du hast §e"+Methodes_MySQL.getCoins(p)+" §7Coins");
			 
		 }else if(args.length == 1) {
			 p.sendMessage(Main.coin_prefix+ "§cBitte benutze /coins add <Spieler> <Coins>");
		 }
		 
		 //COINSADD
		 if(p.hasPermission("coins.add") || p.hasPermission("coins.*")) {
		
			 if(args.length == 1 && args[0].equals("add")) {
				 p.sendMessage(Main.coin_prefix+ "§cBitte benutze /coins add <Spieler> <Coins>");

			 }else if(args.length == 2 && args[0].equalsIgnoreCase("add") && args[1].equalsIgnoreCase(args[1])) {
				 p.sendMessage(Main.coin_prefix+ "§cBitte benutze /coins add <Spieler> <Coins>");
				 
			 }else if(args.length == 3 && args[0].equalsIgnoreCase("add") && args[1].equalsIgnoreCase(args[1]) && args[2].equalsIgnoreCase(args[2])) {
				 if(Methodes_MySQL.hasPlayerProfiel(args[1]) == null) {
					 p.sendMessage(Main.coin_prefix+ "§cDiesen Spieler gibt es nicht");
					 
				 }else {
					Player target = Bukkit.getPlayer(args[1]);
					int coins = Integer.parseInt(args[2]);
					
					Methodes_MySQL.addCoins(target, coins);
					p.sendMessage(Main.coin_prefix+ "§aDu hast dem Spieler "+args[1]+" "+coins +" hinzugefügt");

				 }
			 }
		 }
		 
		 //COINSSET
		 if(p.hasPermission("coins.set") || p.hasPermission("coins.*")) {
		
			 if(args.length == 1 && args[0].equals("set")) {
				 p.sendMessage(Main.coin_prefix+ "§cBitte benutze /coins set <Spieler> <Coins>");

			 }else if(args.length == 2 && args[0].equalsIgnoreCase("set") && args[1].equalsIgnoreCase(args[1])) {
				 p.sendMessage(Main.coin_prefix+ "§cBitte benutze /coins set <Spieler> <Coins>");
				 
			 }else if(args.length == 3 && args[0].equalsIgnoreCase("set") && args[1].equalsIgnoreCase(args[1]) && args[2].equalsIgnoreCase(args[2])) {
				 if(Methodes_MySQL.hasPlayerProfiel(args[1]) == null) {
					 p.sendMessage(Main.coin_prefix+ "§cDiesen Spieler gibt es nicht");
					 
				 }else {
					Player target = Bukkit.getPlayer(args[1]);
					int coins = Integer.parseInt(args[2]);
					
					Methodes_MySQL.setCoins(target, coins);
					p.sendMessage(Main.coin_prefix+ "§aDu hast dem Spieler "+args[1]+" "+coins +" gesetzt");

				 }
			 }
		 }
		 

		
		return true;
	}

}




































































