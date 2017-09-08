package de.weckstyapi.utils;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class NewNickAPI {

	private static ArrayList<String> Names = new ArrayList<String>();

    static {

    }
    
    public static void setNick(final Player p) {
    	final int zufall = new Random().nextInt(Names.size());
    	final String nick = Names.get(zufall);
        p.setDisplayName(nick);
	    p.setPlayerListName(nick);
	
	    for(final Player all : Bukkit.getOnlinePlayers()) {
	    	all.hidePlayer(p);
	    	all.showPlayer(p);
	    }
	        
    }
    
    public static void removeNick(final Player p) {
        p.setDisplayName(p.getName());
        p.setPlayerListName(p.getName());
        
        for(final Player all : Bukkit.getOnlinePlayers()) {
            all.hidePlayer(p);
            all.showPlayer(p);
        }
    }
	
}
