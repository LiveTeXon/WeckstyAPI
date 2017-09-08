package de.weckstyapi.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.weckstyapi.main.Main;
import de.weckstyapi.utils.ServerJoin;



public class CMD_Lobby implements CommandExecutor {

	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player)sender;
		
		if(p.getServer().getServerName().equals("Lobby-01") || p.getServer().getServerName().equals("Lobby-02") || p.getServer().getServerName().equals("Lobby-03") || p.getServer().getServerName().equals("Lobby-04") || p.getServer().getServerName().equals("Lobby-05")) {
			p.sendMessage(Main.name_prefix+ "§cDu bist bereits auf der Lobby");
		}else {
			ServerJoin.JoinServer(p, "Lobby-01");
		}
    	
    	
		
		return true;
	}

}
