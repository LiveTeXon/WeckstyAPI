package de.weckstyapi.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.weckstyapi.main.Main;

public class ServerJoin {
	
	public static void JoinServer(Player p, String servername) {
	  
		 ByteArrayOutputStream b = new ByteArrayOutputStream();
		 DataOutputStream out = new DataOutputStream(b);
		
		try {
    		out.writeUTF("Connect");
			out.writeUTF(servername);
		} catch (IOException e) {
			Bukkit.getConsoleSender().sendMessage("§cFehler beim connecten bei "+servername);
		}
	
		
		p.sendPluginMessage(Main.plugin, "BungeeCord", b.toByteArray());
	}

}
