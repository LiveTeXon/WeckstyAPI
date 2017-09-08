package de.weckstyapi.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.weckstyapi.utils.Methodes_MySQL;
import de.weckstyapi.utils.NewNickAPI;
import de.weckstyapi.utils.PackageSender;

public class JoinListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		int user = Methodes_MySQL.getOnlineUser();
		int total = user + 1;
		
		Player p = e.getPlayer();
		
		Methodes_MySQL.setNick(p, 0);
		
		Methodes_MySQL.setOnlineUser(total);
		
		e.setJoinMessage(null);	

		PackageSender.sendHeaderAndFooter(p, "§7-« §6Wecksty.de - Dein SkyPvP Netzwerk §7»- \n §7-« §cTeamspeak: Wecksty.de §7»-","§7-« §aOnline: "+Methodes_MySQL.getOnlineUser()+" §7»- \n §7-« §cTeamspeak: Wecksty.de §7»- \n §7-« §6Wecksty.de - Dein SkyPvP Netzwerk §7»-");
		
		for(Player all : Bukkit.getOnlinePlayers()) {
			PackageSender.sendHeaderAndFooter(all, "§7-« §6Wecksty.de - Dein SkyPvP Netzwerk §7»- \n §7-« §cTeamspeak: Wecksty.de §7»-","§7-« §aOnline: "+Methodes_MySQL.getOnlineUser()+" §7»- \n §7-« §cTeamspeak: Wecksty.de §7»- \n §7-« §6Wecksty.de - Dein SkyPvP Netzwerk §7»-");
		}
		
		if(Methodes_MySQL.hasPlayerProfiel(p.getName()) == null) {
			Methodes_MySQL.createPlayerProfiel(p);
		}
		
		if(Methodes_MySQL.getNick() == 0) {
			if(p.hasPermission("rank.admin") || p.isOp()) {
				
			} else if(p.hasPermission("rank.moderator") &&  (!p.isOp())) {
				
				
			} else if(p.hasPermission("rank.developer") &&  (!p.isOp())) {
				
				
			} else if(p.hasPermission("rank.supporter") &&  (!p.isOp())) {
				
				
			} else if(p.hasPermission("rank.builder") &&  (!p.isOp())) {
				
				
			} else if(p.hasPermission("rank.youtuber") &&  (!p.isOp())) {
				
				
			} 
			
		}else if(Methodes_MySQL.getNick() == 1) {
			
			if(p.hasPermission("rank.admin") || p.isOp()) {
				NewNickAPI.setNick(p);
				
			} else if(p.hasPermission("rank.moderator") &&  (!p.isOp())) {
				NewNickAPI.setNick(p);
				
				
			} else if(p.hasPermission("rank.developer") &&  (!p.isOp())) {
				NewNickAPI.setNick(p);
				
				
			} else if(p.hasPermission("rank.supporter") &&  (!p.isOp())) {
				NewNickAPI.setNick(p);
				
				
			} else if(p.hasPermission("rank.builder") &&  (!p.isOp())) {
				NewNickAPI.setNick(p);
				
				
			} else if(p.hasPermission("rank.youtuber") &&  (!p.isOp())) {
				NewNickAPI.setNick(p);
				
				
			} 
		}
		
		
		
	}

}
