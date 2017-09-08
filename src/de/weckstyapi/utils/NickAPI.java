package de.weckstyapi.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.google.common.collect.Maps;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.util.UUIDTypeAdapter;

public class NickAPI {
   private static HashMap<UUID, GameProfile> nickedPlayers = Maps.newHashMap();
   private static final Map<String, GameProfile> BY_NAME = Maps.newHashMap();
   private static final Map<UUID, GameProfile> BY_UUID = Maps.newHashMap();
   
   private static ArrayList<String> Names = new ArrayList<String>();
   
    public static void nameAdd(final String Name) {
        if(Name.length() < 17) {
            Names.add(Name);
        } else {
           
        }
    }
    public static void nameRemove(final String Name) {
        if(Names.contains(Name)) {
            Names.remove(Name);
        }
    }
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
    }
    public static void setNick(final Player player) {
        final int zufall = new Random().nextInt(Names.size());
        final String nick = Names.get(zufall);
        final GameProfile profile = getProfile(player);
        if (profile != null) {
           if (nickedPlayers.containsKey(player.getUniqueId()) == false) {
              nickedPlayers.put(player.getUniqueId(), profile);
           }
            final GameProfile profile2 = getProfile(nick, player.getUniqueId());
            if (profile2 != null) {
                setProfile(player, profile2);
            }
            player.setDisplayName(nick);
            player.setPlayerListName(nick);
            for(final Player players : Bukkit.getOnlinePlayers()) {
               if (players.equals(player) == false) {
                  players.hidePlayer(player);
                  players.showPlayer(player);
               }
            }
        }
    }
    private static GameProfile getProfile(final Player player) {
        final String version = Bukkit.getServer().getClass().getPackage().getName().substring(23);
        try {
         return (GameProfile) Class.forName("org.bukkit.craftbukkit."+version+".entity.CraftPlayer").getDeclaredMethod("getProfile").invoke(player);
      } catch (final Exception e) {
         e.printStackTrace();
      }
      return null;
   }
   public static String getRealName(final Player player) {
      if (nickedPlayers.containsKey(player.getUniqueId())) {
         return nickedPlayers.get(player.getUniqueId()).getName();
      }
      return player.getName();
   }
   public static void removeNick(final Player player) {
        if (nickedPlayers.containsKey(player.getUniqueId())) {
           setProfile(player, nickedPlayers.get(player.getUniqueId()));
           nickedPlayers.remove(player.getUniqueId());
            player.setDisplayName(player.getName());
            player.setPlayerListName(player.getName());
            for(final Player players : Bukkit.getOnlinePlayers()) {
               if (players.equals(player) == false) {
                  players.hidePlayer(player);
                  players.showPlayer(player);
               }
            }
        }
       
    }
   private static void setProfile(final Player player, final GameProfile profile) {
        final String version = Bukkit.getServer().getClass().getPackage().getName().substring(23);
        try {
           final Class<?> clazz = Class.forName("org.bukkit.craftbukkit."+version+".entity.CraftPlayer");
           final Field field = getField(Class.forName("net.minecraft.server."+version+".EntityPlayer"));
           if (field != null) {
              field.set(clazz.getMethod("getHandle").invoke(player), profile);
           }
      } catch (final Exception e) {
         e.printStackTrace();
      }
   }
   private static Field getField(final Class<?> clazz) {
      Field field = null;
      for (final Field f : clazz.getDeclaredFields()) {
         f.setAccessible(true);
         if (f.getType().equals(GameProfile.class)) {
            field = f;
         }
      }
      if (field == null) {
         for (final Field f : clazz.getFields()) {
            f.setAccessible(true);
            if (f.getType().equals(GameProfile.class)) {
               field = f;
            }
         }
      }
      if (clazz.getSuperclass() != null && field == null) {
         field = getField(clazz.getSuperclass());
      }
      return field;
   }
   public static boolean hasNick(final Player player) {
      return nickedPlayers.containsKey(player.getUniqueId());
   }
   public static GameProfile getProfile(final String name, final UUID realUniqueId) {
      if (BY_NAME.containsKey(name)) {
         return BY_NAME.get(name);
      }
        try {
            final URL url = new URL("https://api.mojang.com/users/profiles/minecraft/" + name);
            final InputStream is = url.openStream();
            final BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            UUID id = null;
            while((line = br.readLine()) != null) {
                final JsonObject json = (JsonObject) new JsonParser().parse(line);
                id = UUIDTypeAdapter.fromString(json.get("id").getAsString());
            }
            if (id != null) {
               return getProfile(id, realUniqueId);
            } else {
               final GameProfile profile = new GameProfile(realUniqueId, name);
               BY_NAME.put(name, profile);
                return profile;
            }
        } catch (final Exception e) {
         e.printStackTrace();
        }
        return null;
    }
   public static GameProfile getProfile(final UUID uuid, final UUID realUniqueId) {
      if (BY_UUID.containsKey(uuid)) {
         return BY_UUID.get(uuid);
      }
        try {
            final URL url1 = new URL("https://sessionserver.mojang.com/session/minecraft/profile/" + uuid.toString().replace("-", "")+"?unsigned=false");
            final InputStream is1 = url1.openStream();
            final BufferedReader br1 = new BufferedReader(new InputStreamReader(is1));
            String line1;
            String name;
            while((line1 = br1.readLine()) != null) {
                final JsonObject json = (JsonObject) new JsonParser().parse(line1);
                name = json.get("name").getAsString();
                final JsonArray array = json.getAsJsonArray("properties");
                final JsonElement element = array.get(0);
                if (element.isJsonObject()) {
                   final JsonObject object = element.getAsJsonObject();
                   final Property property = new Property(object.get("name").getAsString(), object.get("value").getAsString(), object.get("signature").getAsString());
                   final GameProfile profile = new GameProfile(realUniqueId, name);
                   profile.getProperties().put(property.getName(), property);
                   BY_UUID.put(uuid, profile);
                   BY_NAME.put(name, profile);
                   return profile;
                }
         }
            br1.close();
            is1.close();
        } catch (final Exception e) {
         e.printStackTrace();
        }
        return null;
    }
}