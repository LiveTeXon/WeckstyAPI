package de.weckstyapi.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import de.weckstyapi.main.Main;
import net.minecraft.server.v1_8_R3.EntityPlayer;

public class CMD_Ping implements CommandExecutor  {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player)sender;
		
		if(args.length == 0) {
			p.sendMessage(Main.name_prefix+ "§aDein Ping: "+ getPing(p));
		}
		
		return true;
	}
	
	public int getPing(Player p) {
		CraftPlayer ping = (CraftPlayer) p;
		EntityPlayer pinge = ping.getHandle();
		return pinge.ping;
	}

}
