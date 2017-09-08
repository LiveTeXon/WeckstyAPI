package de.weckstyapi.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import de.weckstyapi.utils.Methodes_MySQL;

public class ChatPrefix implements Listener {
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		
		if(Methodes_MySQL.getNick() == 0) {
			if(p.hasPermission("rank.admin") || p.isOp()) {
				e.setFormat("§4Administrator §8| §4"+p.getDisplayName() +" §7» "+e.getMessage());
				
			} else if(p.hasPermission("rank.moderator") &&  (!p.isOp())) {
				e.setFormat("§cModerator §8| §c"+p.getDisplayName() +" §7» "+e.getMessage());
				
			} else if(p.hasPermission("rank.developer") &&  (!p.isOp())) {
				e.setFormat("§bDeveloper §8| §b"+p.getDisplayName() +" §7» "+e.getMessage());
				
			} else if(p.hasPermission("rank.supporter") &&  (!p.isOp())) {
				e.setFormat("§9Moderator §8| §9"+p.getDisplayName() +" §7» "+e.getMessage());
				
			} else if(p.hasPermission("rank.builder") &&  (!p.isOp())) {
				e.setFormat("§2Builder §8| §2"+p.getDisplayName() +" §7» "+e.getMessage());
				
			} else if(p.hasPermission("rank.youtuber") &&  (!p.isOp())) {
				e.setFormat("§5Youtuber §8| §5"+p.getDisplayName() +" §7» "+e.getMessage());
				
			} else if(p.hasPermission("rank.premium") &&  (!p.isOp())) {
				e.setFormat("§6"+p.getDisplayName() +" §7» "+e.getMessage());
				
			} else if(p.hasPermission("rank.spieler") &&  (!p.isOp())) {
				e.setFormat("§a"+p.getDisplayName() +" §7» "+e.getMessage());
				
			}	
			
			
		}
		 
		if(Methodes_MySQL.getNick() == 1) {
			if(p.hasPermission("rank.admin") || p.isOp()) {
				e.setFormat("§6"+p.getDisplayName() +" §7» "+e.getMessage());
				
			} else if(p.hasPermission("rank.moderator") &&  (!p.isOp())) {
				e.setFormat("§6"+p.getDisplayName() +" §7» "+e.getMessage());
				
			} else if(p.hasPermission("rank.developer") &&  (!p.isOp())) {
				e.setFormat("§6"+p.getDisplayName() +" §7» "+e.getMessage());
				
			} else if(p.hasPermission("rank.supporter") &&  (!p.isOp())) {
				e.setFormat("§6"+p.getDisplayName() +" §7» "+e.getMessage());
				
			} else if(p.hasPermission("rank.builder") &&  (!p.isOp())) {
				e.setFormat("§6"+p.getDisplayName() +" §7» "+e.getMessage());
				
			} else if(p.hasPermission("rank.youtuber") &&  (!p.isOp())) {
				e.setFormat("§6"+p.getDisplayName() +" §7» "+e.getMessage());
				
			}
		}
	}

}
