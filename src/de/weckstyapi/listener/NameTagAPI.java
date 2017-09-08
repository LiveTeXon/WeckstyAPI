package de.weckstyapi.listener;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import com.mojang.authlib.GameProfile;

import net.minecraft.server.v1_8_R3.EntityHuman;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy;
import net.minecraft.server.v1_8_R3.PacketPlayOutNamedEntitySpawn;



public class NameTagAPI {
	
	private static Player p;
	
	public static void setPlayerTagName(String name) {
        EntityHuman eh = ((CraftPlayer)p).getHandle();           
                PacketPlayOutEntityDestroy p29 = new PacketPlayOutEntityDestroy();         
                PacketPlayOutNamedEntitySpawn p20 = new PacketPlayOutNamedEntitySpawn(eh);

        try {                
                         Field profileField = p20.getClass().getDeclaredField("b");
                         profileField.setAccessible(true);
                         profileField.set(p20, new GameProfile(p.getUniqueId(), name));
        } catch (Exception e) {
                         e.printStackTrace();
                }    
        for(Player o : Bukkit.getOnlinePlayers()) {
                         if(!o.getName().equals(p.getName())) {
                                   ((CraftPlayer)o).getHandle().playerConnection.sendPacket(p29);
                                   ((CraftPlayer)o).getHandle().playerConnection.sendPacket(p20);
                         }
                 }
}
}
