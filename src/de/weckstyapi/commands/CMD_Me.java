package de.weckstyapi.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.weckstyapi.main.Main;

public class CMD_Me implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player)sender;
		
		p.sendMessage(Main.name_prefix+ "§cUnbekanter Befehl");
		
		return true;
	}

}
