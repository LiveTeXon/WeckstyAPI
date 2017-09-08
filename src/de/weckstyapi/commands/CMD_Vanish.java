package de.weckstyapi.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.weckstyapi.main.Main;

public class CMD_Vanish implements CommandExecutor {
	
	ArrayList<String> Vanish = new ArrayList<String>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	
		Player p = (Player)sender;
		
		if(sender instanceof ConsoleCommandSender) {
			Bukkit.getConsoleSender().sendMessage("§cNur Für Spieler");
		}
		
		if(p.hasPermission("rank.sup")) {
			if(Vanish.contains(p.getName())) {
				Vanish.remove(p.getName());
				p.sendMessage(Main.name_prefix+ "§aDu bist nun nicht mehr im Vanish");
				for(Player all : Bukkit.getOnlinePlayers()) {
					all.showPlayer(p);
					p.removePotionEffect(PotionEffectType.INVISIBILITY);
				}
			}else {
				for(Player all : Bukkit.getOnlinePlayers()) {
					
					p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 99999, 1));
					
				}
				Vanish.add(p.getName());
				p.sendMessage(Main.name_prefix+ "§aDu bist nun im Vanish");
			}

		}else if(p.hasPermission("rank.admin") || p.hasPermission("rank.mod")) {
			if(Vanish.contains(p.getName())) {
				Vanish.remove(p.getName());
				p.sendMessage(Main.name_prefix+ "§aDu bist nun nicht mehr im Vanish");
				for(Player all : Bukkit.getOnlinePlayers()) {
					all.showPlayer(p);
					
					
				}
			}else {
				for(Player all : Bukkit.getOnlinePlayers()) {
					all.hidePlayer(p);
					
				}
				Vanish.add(p.getName());
				p.sendMessage(Main.name_prefix+ "§aDu bist nun im Vanish");
			}

		}else{
			p.sendMessage(Main.name_prefix+ "§cUnbekannter Befehl");
		}
		

		return true;
	}

}
