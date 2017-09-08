package de.weckstyapi.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.weckstyapi.main.Main;
import de.weckstyapi.utils.Methodes_MySQL;
import de.weckstyapi.utils.NewNickAPI;

public class CMD_Nick implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player)sender;
		
		if(p.hasPermission("server.nick")) {
			
			
			if(args.length == 1 && args[0].equalsIgnoreCase("AN")) {
				if(Methodes_MySQL.getNick() == 0) {
					p.sendMessage(Main.name_prefix+ "§aDu bist nun genickt");
					Methodes_MySQL.setNick(p, 1);
					NewNickAPI.setNick(p);
				}	
			}
			
			if(args.length == 1 && args[0].equalsIgnoreCase("AUS")) {
				if(Methodes_MySQL.getNick() == 1) {
					p.sendMessage(Main.name_prefix+ "§aDu bist nun micht mehr genickt");
					Methodes_MySQL.setNick(p, 0);
					NewNickAPI.removeNick(p);
				}	
			}
		}
		
		
		return true;
	}

}
