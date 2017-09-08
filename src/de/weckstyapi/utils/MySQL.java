package de.weckstyapi.utils;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

import de.weckstyapi.main.Main;

public class MySQL {

	

    public static int pingTimer = 1200;
    public static BukkitTask pingTask;
    public static java.sql.Connection con;
    public static String host = Main.plugin.getConfig().getString("Config.MySQL.Host");
    public static int port = Main.plugin.getConfig().getInt("Config.MySQL.Port");
    public static String database = Main.plugin.getConfig().getString("Config.MySQL.Database");
    public static String user = Main.plugin.getConfig().getString("Config.MySQL.User");
    public static String password = Main.plugin.getConfig().getString("Config.MySQL.Password");


    public static boolean connectMySQL(){
        boolean connected = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, password);
            connected = true;
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage("§c[WeckstyAPI] Ein Fehler ist beim Verbindungsaufbau zur MySQL-Datenbank aufgetreten.");
        } catch (ClassNotFoundException localClassNotFoundException) { }
        return connected;
    }
    public static boolean isConnected() {
        boolean connected = false;
        if (con != null) {
            connected = true;
        }
        return connected;
    }
    public static void pingMySQLServer() {
        pingTask = Bukkit.getScheduler().runTaskTimerAsynchronously(Main.plugin, new Runnable() {
            public void run() {
                try {

                    if (MySQL.isConnected()) {
                        Statement s = MySQL.con.createStatement();

                        s.executeQuery("/* ping */ SELECT 1");
                        s.close();
                        Bukkit.getConsoleSender().sendMessage("§a[WeckstyAPI] Der MySQL-Server wurde erfolgreich angepingt");
                    } else {
                        MySQL.connectMySQL();
                    }
                }
                catch (SQLException e) {
                    Bukkit.getConsoleSender().sendMessage("§c[WeckstyAPI] Der MySQL-Server konnte nicht angepingt werden.");
                }
            }
        }, 20L, 20 * pingTimer);
    }
    
}
