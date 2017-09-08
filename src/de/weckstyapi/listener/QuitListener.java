package de.weckstyapi.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import de.weckstyapi.utils.Methodes_MySQL;
import de.weckstyapi.utils.PackageSender;

public class QuitListener implements Listener {
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		
		int user = Methodes_MySQL.getOnlineUser();
		int total = user - 1;
		
		Methodes_MySQL.setOnlineUser(total);
		
		for(Player all : Bukkit.getOnlinePlayers()) {
			PackageSender.sendHeaderAndFooter(all, "§7-« §6Wecksty.de - Dein SkyPvP Netzwerk §7»- \n §7-« §cTeamspeak: Wecksty.de §7»-","§7-« §aOnline: "+Methodes_MySQL.getOnlineUser()+" §7»- \n §7-« §cTeamspeak: Wecksty.de §7»- \n §7-« §6Wecksty.de - Dein SkyPvP Netzwerk §7»-");
		}
		
		e.setQuitMessage(null);
		
	}

}
