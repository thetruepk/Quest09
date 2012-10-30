package edu.unca.jlmccask.Quest08;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

public class PlayerLoginListner implements Listener {

	private Quest08 plugin;
	
	public PlayerLoginListner(Quest08 plugin){
		this.plugin = plugin;
	}
	
	@EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
	public void onPlayerLogin(PlayerLoginEvent event){
		String playerName = event.getPlayer().getName();
		
		if (plugin.bannedPlayers.contains(playerName)){
			event.setKickMessage("You have been Baned");
			event.setResult(Result.KICK_BANNED);
		}
		
	}
	
	
}
