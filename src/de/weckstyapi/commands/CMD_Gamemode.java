package de.weckstyapi.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.weckstyapi.main.Main;


public class CMD_Gamemode implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player)sender;
		
		if(p.hasPermission("server.gm")) {
			
			if(args.length == 0) {
				p.sendMessage(Main.name_prefix+ "§cBitte benutze /gm [0] Survival, [1] Creative, [2] Adventure, [3] Spectator");
				
				
			}else if(args.length == 1 && args[0].equalsIgnoreCase("0")) {
				p.sendMessage(Main.name_prefix+ "§aDu bist nun im Survival-Modus");
				p.setGameMode(GameMode.SURVIVAL);
			}else if(args.length == 1 && args[0].equalsIgnoreCase("survival")) {
				p.sendMessage(Main.name_prefix+ "§aDu bist nun im Survival-Modus");
				p.setGameMode(GameMode.SURVIVAL);
				
				
			}else if(args.length == 1 && args[0].equalsIgnoreCase("1")) {
				p.sendMessage(Main.name_prefix+ "§aDu bist nun im Creative-Modus");
				p.setGameMode(GameMode.CREATIVE);
				
			}else if(args.length == 1 && args[0].equalsIgnoreCase("creative")) {
				p.sendMessage(Main.name_prefix+ "§aDu bist nun im Creative-Modus");
				p.setGameMode(GameMode.CREATIVE);
				
				
			}else if(args.length == 1 && args[0].equalsIgnoreCase("2")) {
				p.sendMessage(Main.name_prefix+ "§aDu bist nun im Adventure-Modus");
				p.setGameMode(GameMode.ADVENTURE);
				
			}else if(args.length == 1 && args[0].equalsIgnoreCase("adventure")) {
				p.sendMessage(Main.name_prefix+ "§aDu bist nun im Adventure-Modus");
				p.setGameMode(GameMode.ADVENTURE);
				
				
			}else if(args.length == 1 && args[0].equalsIgnoreCase("3")) {
				p.sendMessage(Main.name_prefix+ "§aDu bist nun im Spectartor-Modus");
				p.setGameMode(GameMode.SPECTATOR);
				
			}else if(args.length == 1 && args[0].equalsIgnoreCase("spectartor")) {
				p.sendMessage(Main.name_prefix+ "§aDu bist nun im Spectartor-Modus");
				p.setGameMode(GameMode.SPECTATOR);
				
			}
			
			
		}else{
			p.sendMessage(Main.name_prefix+ "§cUnbekannter Befehl");
		}
		
		
		
		return true;
	}

}
