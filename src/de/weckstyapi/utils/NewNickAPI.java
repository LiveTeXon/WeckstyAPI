package de.weckstyapi.utils;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class NewNickAPI {

	private static ArrayList<String> Names = new ArrayList<String>();

    static {
        Names.add("AirFusion");
        Names.add("AmazingHuh");
        Names.add("aranamor");
        Names.add("atomic7732");
        Names.add("Carmelpop");
        Names.add("catlover2011");
        Names.add("Chan14551");
        Names.add("Zoarium");
        Names.add("Chzydeath");
        Names.add("CoolBlueJ");
        Names.add("DaBomb");
        Names.add("Darvince");
        Names.add("DaSnipeKid");
        Names.add("Dawnofdusk");
        Names.add("De_n00bWOLF");
        Names.add("DeepDarkSamu");
        Names.add("DefaultStu");
        Names.add("diamond146");
        Names.add("DirtDog");
        Names.add("DivinityV2");
        Names.add("F0R1");
        Names.add("faloxx");
        Names.add("fire3232");
        Names.add("firehawk729");
        Names.add("Firestix");
        Names.add("Fixin");
        Names.add("For_the_lol");
        Names.add("FoxHound42");
        Names.add("Entophobia");
        Names.add("Erak606");
        Names.add("Peaa");
        sfgd
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
