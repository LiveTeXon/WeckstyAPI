package de.weckstyapi.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.weckstyapi.commands.CMD_Coins;
import de.weckstyapi.commands.CMD_Gamemode;
import de.weckstyapi.commands.CMD_Help;
import de.weckstyapi.commands.CMD_Lobby;
import de.weckstyapi.commands.CMD_Me;
import de.weckstyapi.commands.CMD_Nick;
import de.weckstyapi.commands.CMD_Ping;
import de.weckstyapi.commands.CMD_Plugins;
import de.weckstyapi.commands.CMD_Vanish;
import de.weckstyapi.listener.ChatPrefix;
import de.weckstyapi.listener.InteractListener;
import de.weckstyapi.listener.JoinListener;
import de.weckstyapi.listener.QuitListener;
import de.weckstyapi.utils.Methodes_MySQL;
import de.weckstyapi.utils.MySQL;


public class Main extends JavaPlugin {
	
	public static Main plugin;
	public static String name_prefix = "§7[§6Wecksty.de§7] ";
	public static String coin_prefix = "§7[§eCoin-System§7] ";
	
	
	@Override
	public void onEnable() {
		plugin = this;
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		loadListener();
		loadCommands();
		loadConfig();
		checkConfig();
		
		
		MySQL.connectMySQL();
		
		if(MySQL.isConnected()){
			MySQL.pingMySQLServer();
			Bukkit.getConsoleSender().sendMessage("§a[WeckstyAPI] §7MySQL §aerfolgreich §7hergestellt!");
			Methodes_MySQL.createDefaultMySQL();
			
		}else {
			Bukkit.getServer().shutdown();
		}
	}
	
	@Override
	public void onDisable() {

		int alluser = Methodes_MySQL.getOnlineUser();
		int serveruser = Bukkit.getOnlinePlayers().size();
		int total = alluser - serveruser;
		
	Methodes_MySQL.setOnlineUser(total);
		
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void loadListener() {
		PluginManager pm = Bukkit.getPluginManager();
		
		pm.registerEvents(new JoinListener(), this);
		pm.registerEvents(new QuitListener(), this);
		pm.registerEvents(new ChatPrefix(), this);
		pm.registerEvents(new InteractListener(), this);
	}
	
	public void loadCommands() {
		getCommand("coins").setExecutor(new CMD_Coins());
		getCommand("lobby").setExecutor(new CMD_Lobby());
		getCommand("help").setExecutor(new CMD_Help());
		getCommand("me").setExecutor(new CMD_Me());
		getCommand("gamemode").setExecutor(new CMD_Gamemode());
		getCommand("ping").setExecutor(new CMD_Ping());
		getCommand("plugins").setExecutor(new CMD_Plugins());
		getCommand("vanish").setExecutor(new CMD_Vanish());
		getCommand("nick").setExecutor(new CMD_Nick());
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private void loadConfig(){
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

	private void checkConfig(){
		if (!plugin.getConfig().contains("Config.MySQL.Host")) {
            plugin.getConfig().set("Config.MySQL.Host", "localhost");
            plugin.saveConfig();
        }
        if (!plugin.getConfig().contains("Config.MySQL.Port")) {
            plugin.getConfig().set("Config.MySQL.Port", Integer.valueOf(3306));
            plugin.saveConfig();
        }
        if (!plugin.getConfig().contains("Config.MySQL.User")) {
            plugin.getConfig().set("Config.MySQL.User", "user");
            plugin.saveConfig();
        }
        if (!plugin.getConfig().contains("Config.MySQL.Password")) {
            plugin.getConfig().set("Config.MySQL.Password", "password");
            plugin.saveConfig();
        }
        if (!plugin.getConfig().contains("Config.MySQL.Database")) {
            plugin.getConfig().set("Config.MySQL.Database", "database");
            plugin.saveConfig();
        } 
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


}







































