package de.weckstyapi.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import de.weckstyapi.utils.ItemBuilder;
import de.weckstyapi.utils.Methodes_MySQL;
import de.weckstyapi.utils.NickAPI;

public class InteractListener implements Listener {
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();

		if(p.getItemInHand().hasItemMeta()) {
		
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			

				
				//NICK ANSCHALTEN
				if(p.getItemInHand().getItemMeta().getDisplayName().equals("§8» §cNick aus §8«")) {
					p.sendMessage("sgsg");
					Methodes_MySQL.setNick(p, 1);
					NickAPI.setNick(p);
					p.setItemInHand(new ItemBuilder(Material.NAME_TAG).name("§8» §aNick an §8«").build());
				}
				
				//NICK AUSSCHALTEN
				if(p.getItemInHand().getItemMeta().getDisplayName().equals("§8» §aNick an §8«")) {
					Methodes_MySQL.setNick(p, 0);
					NickAPI.removeNick(p);
					p.setItemInHand(new ItemBuilder(Material.NAME_TAG).name("§8» §cNick aus §8«").build());
				}
			}
		}
	}

}
